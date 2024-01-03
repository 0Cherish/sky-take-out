package com.maoxian.dto;

import lombok.Data;

/**
 * @author Lin
 * @date 2024/1/1 11:35
 */
@Data
public class CategoryDTO {
    private Long id;
    private Integer type;
    private String name;
    private Integer sort;
}
