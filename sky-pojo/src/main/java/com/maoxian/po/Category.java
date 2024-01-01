package com.maoxian.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 菜品及套餐分类
 *
 * @author Lin
 * @date 2023/12/31 10:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;
    /**
     * 类型 1:菜品分类 2:套餐分类
     */
    private Integer type;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 顺序
     */
    private Integer sort;
    /**
     * 分类状态 0:禁用 1:启用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 创建人
     */
    private Long createUser;
    /**
     * 修改人
     */
    private Long updateUser;
}
