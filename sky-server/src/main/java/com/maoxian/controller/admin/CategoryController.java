package com.maoxian.controller.admin;

import com.maoxian.dto.CategoryDTO;
import com.maoxian.dto.CategoryPageQueryDTO;
import com.maoxian.po.Category;
import com.maoxian.result.PageResult;
import com.maoxian.result.Result;
import com.maoxian.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类管理
 *
 * @author Lin
 * @date 2024/1/1 11:30
 */
@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     *
     * @param categoryDTO 分类信息
     * @return 响应结果
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result<String> save(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增分类：{}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO 分页查询参数
     * @return 响应结果
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult<Category>> page(@RequestBody CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("分类分页查询：{}", categoryPageQueryDTO);
        PageResult<Category> pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 删除分类
     *
     * @param id id
     * @return 响应结果
     */
    @DeleteMapping
    @ApiOperation("删除分类")
    public Result<String> deleteById(Long id) {
        log.info("删除分类：{}", id);
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 修改分类
     *
     * @param categoryDTO 分类信息
     * @return 响应结果
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result<String> update(@RequestBody CategoryDTO categoryDTO) {
        log.info("修改分类：{}", categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }


    /**
     * 启用禁用分类
     *
     * @param status 状态
     * @param id     分类id
     * @return 响应结果
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result<String> startOrStop(@PathVariable Integer status, Long id) {
        log.info("启用禁用分类：{}，{}", status, id);
        categoryService.startOrStop(status, id);
        return Result.success();
    }

    /**
     * 根据类型查询分类
     *
     * @param type 类型
     * @return 响应结果
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type) {
        log.info("根据类型查询分类：{}", type);
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }
}
