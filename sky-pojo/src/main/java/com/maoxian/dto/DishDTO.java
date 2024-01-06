package com.maoxian.dto;

import com.maoxian.po.DishFlavor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Lin
 * @date 2024/1/3 13:54
 */
@Data
public class DishDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private BigDecimal price;
    private String image;
    private String description;
    private Integer status;
    private List<DishFlavor> flavors;
}
