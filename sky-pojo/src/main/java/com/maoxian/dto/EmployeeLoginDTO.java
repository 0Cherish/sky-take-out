package com.maoxian.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lin
 * @date 2023/12/31 12:12
 */
@Data
@ApiModel(description = "员工登录时传递的数据模型")
public class EmployeeLoginDTO {
    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;
}
