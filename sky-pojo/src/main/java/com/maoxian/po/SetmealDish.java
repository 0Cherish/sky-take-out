package com.maoxian.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 套餐菜品关系
 *
 * @author Lin
 * @date 2023/12/31 11:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetmealDish {
    private Long id;
    /**
     * 套餐id
     */
    private Long setmealId;
    /**
     * 菜品id
     */
    private Long dishId;
    /**
     * 菜品名称 （冗余字段）
     */
    private String name;
    /**
     * 菜品原价 （冗余字段）
     */
    private BigDecimal price;
    /**
     * 份数
     */
    private Integer copies;
}
