package com.maoxian.mapper;

import com.github.pagehelper.Page;
import com.maoxian.dto.CategoryPageQueryDTO;
import com.maoxian.po.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Lin
 * @date 2024/1/1 11:32
 */
@Mapper
public interface CategoryMapper {
    /**
     * 插入分类数据
     *
     * @param category 员工信息
     */
    @Insert("insert into category (type, name, sort, status, create_time, update_time, create_user, update_user)" +
            "values" +
            "(#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Category category);

    /**
     * 分页查询
     *
     * @param categoryPageQueryDTO 查询条件
     * @return 查询结果
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据id删除数据
     *
     * @param id id
     */
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    /**
     * 修改分类信息
     *
     * @param category 分类信息
     */
    void update(Category category);

    /**
     * 根据类型查询分类
     *
     * @param type 类型
     * @return 查询结果
     */
    List<Category> list(Integer type);
}
