package com.maoxian.service.impl;

import com.maoxian.constant.MessageConstant;
import com.maoxian.constant.StatusConstant;
import com.maoxian.dto.EmployeeLoginDTO;
import com.maoxian.exception.AccountLockedException;
import com.maoxian.exception.AccountNotFoundException;
import com.maoxian.exception.PasswordErrorException;
import com.maoxian.mapper.EmployeeMapper;
import com.maoxian.po.Employee;
import com.maoxian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author Lin
 * @date 2023/12/31 11:45
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        // 根据用户名查询数据
        Employee employee = employeeMapper.getByUsername(username);

        // 账号不存在
        if (employee == null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        // 密码错误
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(employee.getPassword())){
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        // 账号被锁定
        if (employee.getStatus().equals(StatusConstant.DISABLE)){
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        return employee;
    }
}
