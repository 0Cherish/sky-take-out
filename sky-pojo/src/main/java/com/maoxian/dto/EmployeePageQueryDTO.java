package com.maoxian.dto;

import lombok.Data;

/**
 * @author Lin
 * @date 2024/1/1 9:53
 */
@Data
public class EmployeePageQueryDTO {
    private String name;
    private Integer page;
    private Integer pageSize;
}
