package com.maoxian.controller.admin;

import com.maoxian.constant.JwtClaimsConstant;
import com.maoxian.dto.EmployeeDTO;
import com.maoxian.dto.EmployeeLoginDTO;
import com.maoxian.dto.EmployeePageQueryDTO;
import com.maoxian.po.Employee;
import com.maoxian.properties.JwtProperties;
import com.maoxian.result.PageResult;
import com.maoxian.result.Result;
import com.maoxian.service.EmployeeService;
import com.maoxian.util.JwtUtil;
import com.maoxian.vo.EmployeeLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 新增员工
     *
     * @param employeeDTO 员工信息
     * @return 响应结果
     */
    @PostMapping
    @ApiOperation("新增员工")
    public Result<String> save(@RequestBody EmployeeDTO employeeDTO) {
        log.info("新增员工：{}", employeeDTO);
        employeeService.save(employeeDTO);
        return Result.success();
    }

    /**
     * 员工分页查询
     *
     * @param employeePageQueryDTO 分页查询参数
     * @return 响应结果
     */
    @GetMapping("/page")
    @ApiOperation("员工分页查询")
    public Result<PageResult<Employee>> page(EmployeePageQueryDTO employeePageQueryDTO) {
        log.info("员工分页查询，参数为：{}", employeePageQueryDTO);
        PageResult<Employee> pageResult = employeeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 启用禁用员工账号
     *
     * @param status 状态
     * @param id     员工id
     * @return 响应结果
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用员工账号")
    public Result<String> startOrStop(@PathVariable Integer status, Long id) {
        log.info("启用禁用员工账号：{}，{}", status, id);
        employeeService.startOrStop(status, id);
        return Result.success();
    }

    /**
     * 根据id查询员工信息
     *
     * @param id id
     * @return 员工信息
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询员工信息")
    public Result<Employee> getById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        return Result.success(employee);
    }

    /**
     * 编辑员工信息
     *
     * @param employeeDTO 员工信息
     * @return 响应结果
     */
    @PutMapping
    @ApiOperation("编辑员工信息")
    public Result<String> update(@RequestBody EmployeeDTO employeeDTO){
        log.info("编辑员工信息：{}",employeeDTO);
        employeeService.update(employeeDTO);
        return Result.success();
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
