package com.maoxian.mapper;

import com.github.pagehelper.Page;
import com.maoxian.annotation.AutoFill;
import com.maoxian.dto.DishPageQueryDTO;
import com.maoxian.enumeration.OperationType;
import com.maoxian.po.Dish;
import com.maoxian.vo.DishVo;
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

    /**
     * 插入菜品数据
     *
     * @param dish 菜品信息
     */
    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    /**
     * 菜品分页查询
     *
     * @param dishPageQueryDTO 查询条件
     * @return 查询结果
     */
    Page<DishVo> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 查询菜品
     *
     * @param id id
     * @return 查询结果
     */
    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    /**
     * 删除菜品
     *
     * @param id id
     */
    @Select("delete from dish where id = #{id}")
    void deleteById(Long id);

    /**
     * 根据id修改菜品信息
     *
     * @param dish 菜品信息
     */
    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);
}
