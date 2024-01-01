package com.maoxian.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 购物车
 * @author Lin
 * @date 2023/12/31 11:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 菜品id
     */
    private Long dishId;
    /**
     * 套餐id
     */
    private Long setmealId;
    /**
     * 口味
     */
    private String dishFlavor;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 图片
     */
    private String image;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
