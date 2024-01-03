package com.maoxian.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.maoxian.constant.MessageConstant;
import com.maoxian.constant.StatusConstant;
import com.maoxian.context.BaseContext;
import com.maoxian.dto.CategoryDTO;
import com.maoxian.dto.CategoryPageQueryDTO;
import com.maoxian.exception.DeletionNotAllowedException;
import com.maoxian.mapper.CategoryMapper;
import com.maoxian.mapper.DishMapper;
import com.maoxian.mapper.SetmealMapper;
import com.maoxian.po.Category;
import com.maoxian.result.PageResult;
import com.maoxian.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Lin
 * @date 2024/1/1 11:32
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    public void save(CategoryDTO categoryDTO) {
        Category category = new Category();

        // 对象属性拷贝
        BeanUtils.copyProperties(categoryDTO, category);

        // 分类状态默认为禁用
        category.setStatus(StatusConstant.DISABLE);

//        // 设置当前记录的创建时间和修改时间
//        category.setCreateTime(LocalDateTime.now());
//        category.setUpdateTime(LocalDateTime.now());
//
//        // 设置当前记录的创建人和修改人
//        category.setCreateUser(BaseContext.getCurrentId());
//        category.setUpdateUser(BaseContext.getCurrentId());

        categoryMapper.insert(category);
    }

    @Override
    public PageResult<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(), categoryPageQueryDTO.getPageSize());
        Page<Category> page = categoryMapper.pageQuery(categoryPageQueryDTO);

        long total = page.getTotal();
        List<Category> records = page.getResult();

        return new PageResult<>(total, records);
    }

    @Override
    public void deleteById(Long id) {
        // 查询当前分类是否关联了菜品
        Integer count = dishMapper.countByCategoryId(id);
        if (count > 0) {
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_DISH);
        }

        // 查询当前分类是否关联了套餐
        count = setmealMapper.countByCategoryId(id);
        if (count > 0) {
            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BY_RELATED_BY_SETMEAL);
        }

        categoryMapper.deleteById(id);
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);

//        category.setUpdateTime(LocalDateTime.now());
//        category.setUpdateUser(BaseContext.getCurrentId());

        categoryMapper.update(category);
    }

    @Override
    public void startOrStop(Integer status, Long id) {
        Category category = new Category();
        category.setStatus(status);
        category.setId(id);
//        category.setUpdateTime(LocalDateTime.now());
//        category.setUpdateUser(BaseContext.getCurrentId());

        categoryMapper.update(category);
    }

    @Override
    public List<Category> list(Integer type) {
        return categoryMapper.list(type);
    }
}
