package com.maoxian.service;

import com.maoxian.dto.EmployeeLoginDTO;
import com.maoxian.po.Employee;

/**
 * @author Lin
 * @date 2023/12/31 11:45
 */
public interface EmployeeService {
    /**
     * 员工登录
     * @param employeeLoginDTO 员工登录信息
     * @return 员工信息
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);
}
