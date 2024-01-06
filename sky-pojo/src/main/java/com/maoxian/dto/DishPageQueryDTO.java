package com.maoxian.dto;

import lombok.Data;

/**
 * @author Lin
 * @date 2024/1/4 11:58
 */
@Data
public class DishPageQueryDTO {
    private Integer page;
    private Integer pageSize;
    private String name;
    private Integer categoryId;
    private Integer status;
}
