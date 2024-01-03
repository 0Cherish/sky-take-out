package com.maoxian.mapper;

import com.github.pagehelper.Page;
import com.maoxian.annotation.AutoFill;
import com.maoxian.dto.EmployeePageQueryDTO;
import com.maoxian.enumeration.OperationType;
import com.maoxian.po.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Lin
 * @date 2023/12/31 11:45
 */
@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     *
     * @param username 用户名
     * @return 员工信息
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入员工数据
     *
     * @param employee 员工信息
     */
    @Insert("insert into employee (name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user) " +
            "values" +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    @AutoFill(OperationType.INSERT)
    void insert(Employee employee);

    /**
     * 分页查询
     *
     * @param employeePageQueryDTO 查询条件
     * @return 查询结果
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 修改员工信息
     *
     * @param employee 员工信息
     */
    @AutoFill(OperationType.UPDATE)
    void update(Employee employee);

    /**
     * 根据id查询员工信息
     * @param id id
     * @return 员工信息
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
