package com.yjxz.ssm.mapper;

import com.yjxz.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();
}
