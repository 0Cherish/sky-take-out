package com.maoxian.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 菜品口味
 *
 * @author Lin
 * @date 2023/12/31 11:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishFlavor {
    private Long id;
    /**
     * 菜品id
     */
    private Long dishId;
    /**
     * 口味名称
     */
    private String name;
    /**
     * 口味数据
     */
    private String value;
}
