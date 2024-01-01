package com.maoxian.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lin
 * @date 2023/12/31 12:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "员工登录时返回的数据模型")
public class EmployeeLoginVo {
    @ApiModelProperty("主键值")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("jwt令牌")
    private String token;
}
