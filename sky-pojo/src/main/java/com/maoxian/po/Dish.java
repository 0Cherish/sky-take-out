package com.maoxian.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 菜品
 *
 * @author Lin
 * @date 2023/12/31 11:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private Long id;
    /**
     * 菜品名称
     */
    private String name;
    /**
     * 菜品分类
     */
    private Long categoryId;
    /**
     * 菜品价格
     */
    private BigDecimal price;
    /**
     * 图片
     */
    private String image;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 菜品状态 0:停售 1:启售
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
