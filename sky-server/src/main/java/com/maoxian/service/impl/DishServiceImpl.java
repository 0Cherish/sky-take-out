package com.maoxian.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.maoxian.constant.MessageConstant;
import com.maoxian.constant.StatusConstant;
import com.maoxian.dto.DishDTO;
import com.maoxian.dto.DishPageQueryDTO;
import com.maoxian.exception.DeletionNotAllowedException;
import com.maoxian.mapper.DishFlavorMapper;
import com.maoxian.mapper.DishMapper;
import com.maoxian.mapper.SetmealDishMapper;
import com.maoxian.po.Dish;
import com.maoxian.po.DishFlavor;
import com.maoxian.result.PageResult;
import com.maoxian.service.DishService;
import com.maoxian.vo.DishVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lin
 * @date 2024/1/2 9:18
 */
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    @Autowired
    private SetmealDishMapper setmealDishMapper;

    @Override
    public void saveWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);

        // 向菜品插入一条数据
        dishMapper.insert(dish);

        // 获取insert语句生成的id
        Long dishId = dish.getId();

        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && !flavors.isEmpty()) {
            flavors.forEach(dishFlavor -> dishFlavor.setDishId(dishId));
            dishFlavorMapper.insetBatch(flavors);
        }
    }

    @Override
    public PageResult<DishVo> pageQuery(DishPageQueryDTO dishPageQueryDTO) {
        PageHelper.startPage(dishPageQueryDTO.getPage(), dishPageQueryDTO.getPageSize());
        Page<DishVo> page = dishMapper.pageQuery(dishPageQueryDTO);

        long total = page.getTotal();
        List<DishVo> records = page.getResult();

        return new PageResult<>(total, records);
    }

    @Override
    public void deleteBatch(List<Long> ids) {
        // 是否存在起售中的商品
        for (Long id : ids) {
            Dish dish = dishMapper.getById(id);
            if (dish.getStatus().equals(StatusConstant.ENABLE)) {
                throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
            }
        }

        // 是否关联了套餐
        List<Long> setmealIds = setmealDishMapper.getSetmealIdsByDishIds(ids);
        if (setmealIds != null && !setmealIds.isEmpty()) {
            throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
        }

        // 删除菜品和关联的口味
        for (Long id : ids) {
            dishMapper.deleteById(id);
            dishFlavorMapper.deleteByDishId(id);
        }
    }

    @Override
    public DishVo getByIdWithFlavor(Long id) {
        // 查询菜品信息
        Dish dish = dishMapper.getById(id);

        // 查询口味信息
        List<DishFlavor> dishFlavors = dishFlavorMapper.getByDishId(id);

        DishVo dishVo = new DishVo();
        BeanUtils.copyProperties(dish, dishVo);
        dishVo.setFlavors(dishFlavors);

        return dishVo;
    }

    @Override
    public void updateWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);

        // 修改菜品信息
        dishMapper.update(dish);

        // 删除原有口味数据
        dishFlavorMapper.deleteByDishId(dishDTO.getId());

        // 重新插入口味数据
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && !flavors.isEmpty()){
            flavors.forEach(dishFlavor -> dishFlavor.setDishId(dishDTO.getId()));
            dishFlavorMapper.insetBatch(flavors);
        }

    }
}
