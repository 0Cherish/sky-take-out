package com.maoxian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Lin
 * @date 2024/1/2 8:48
 */
@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品的数量
     *
     * @param categoryId 分类id
     * @return 套餐数量
     */
    @Select("select count(*) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
}
