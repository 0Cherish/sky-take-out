package com.maoxian.service;

import com.maoxian.dto.EmployeeDTO;
import com.maoxian.dto.EmployeeLoginDTO;
import com.maoxian.dto.EmployeePageQueryDTO;
import com.maoxian.po.Employee;
import com.maoxian.result.PageResult;

/**
 * @author Lin
 * @date 2023/12/31 11:45
 */
public interface EmployeeService {
    /**
     * 员工登录
     *
     * @param employeeLoginDTO 员工登录信息
     * @return 员工信息
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     *
     * @param employeeDTO 员工信息
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 分页查询
     *
     * @param employeePageQueryDTO 查询参数
     * @return 查询结果
     */
    PageResult<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用禁用员工账号
     *
     * @param status 状态
     * @param id     员工id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 根据id查询员工
     *
     * @param id id
     * @return 查询结果
     */
    Employee getById(Long id);

    /**
     * 编辑员工信息
     *
     * @param employeeDTO 员工信息
     */
    void update(EmployeeDTO employeeDTO);
}
