package com.maoxian.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Lin
 * @date 2024/1/4 12:26
 */
@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应的套餐id
     * @param dishIds 菜品id
     * @return 查询结果
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);
}
