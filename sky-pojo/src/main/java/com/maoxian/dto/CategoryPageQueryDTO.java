package com.maoxian.dto;

import lombok.Data;

/**
 * @author Lin
 * @date 2024/1/1 11:40
 */
@Data
public class CategoryPageQueryDTO {
    private Integer page;
    private Integer pageSize;
    private String name;
    private Integer type;
}
