package com.maoxian.service;

import com.maoxian.dto.DishDTO;
import com.maoxian.dto.DishPageQueryDTO;
import com.maoxian.result.PageResult;
import com.maoxian.vo.DishVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lin
 * @date 2024/1/2 9:18
 */
public interface DishService {
    /**
     * 新增菜品和对应的口味
     *
     * @param dishDTO 菜品信息
     */
    void saveWithFlavor(@Param("dishDTO") DishDTO dishDTO);

    /**
     * 菜品分页查询
     *
     * @param dishPageQueryDTO 查询条件
     * @return 查询结果
     */
    PageResult<DishVo> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品批量处理
     *
     * @param ids ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id查询菜品和对应的口味数据
     *
     * @param id id
     * @return 查询结果
     */
    DishVo getByIdWithFlavor(Long id);

    /**
     * 修改菜品和对应的口味信息
     *
     * @param dishDTO 菜品信息
     */
    void updateWithFlavor(DishDTO dishDTO);
}
