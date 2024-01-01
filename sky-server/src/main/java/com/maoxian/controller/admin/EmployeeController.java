package com.maoxian.controller.admin;

import com.maoxian.constant.JwtClaimsConstant;
import com.maoxian.dto.EmployeeLoginDTO;
import com.maoxian.po.Employee;
import com.maoxian.properties.JwtProperties;
import com.maoxian.result.Result;
import com.maoxian.service.EmployeeService;
import com.maoxian.util.JwtUtil;
import com.maoxian.vo.EmployeeLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 员工管理
 *
 * @author Lin
 * @date 2023/12/31 11:42
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
@Api(tags = "员工相关接口")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 员工登录
     *
     * @param employeeLoginDTO 员工登录信息
     * @return 员工信息
     */
    @PostMapping("/login")
    @ApiOperation("员工登录")
    public Result<EmployeeLoginVo> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        // 登录成功，生成jwt令牌
        HashMap<String, Object> claims = new HashMap<>(1);
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJwt(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims
        );

        EmployeeLoginVo employeeLoginVo = new EmployeeLoginVo(employee.getId(), employee.getUsername(), employee.getName(), token);

        return Result.success(employeeLoginVo);
    }

    /**
     * 员工注销
     *
     * @return 响应结果
     */
    @PostMapping("/logout")
    @ApiOperation("员工注销")
    public Result<String> logout() {
        return Result.success();
    }
}
