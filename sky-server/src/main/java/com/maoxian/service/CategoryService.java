package com.maoxian.service;

import com.maoxian.dto.CategoryDTO;
import com.maoxian.dto.CategoryPageQueryDTO;
import com.maoxian.po.Category;
import com.maoxian.result.PageResult;

import java.util.List;

/**
 * @author Lin
 * @date 2024/1/1 11:31
 */
public interface CategoryService {
    /**
     * 新增分类
     *
     * @param categoryDTO 分类信息
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO 分页查询参数
     * @return 查询结果
     */
    PageResult<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 删除分类
     *
     * @param id id
     */
    void deleteById(Long id);

    /**
     * 修改分类
     *
     * @param categoryDTO 分类信息
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 启用禁用分类
     *
     * @param status 状态
     * @param id     分类id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 根据类型查询分类
     *
     * @param type 类型
     * @return 查询结果
     */
    List<Category> list(Integer type);
}
