package com.cskaoyan.dao.person;

import com.cskaoyan.domain.person.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);



    List<Employee> selectEmployeeList(int limit, int offset);
    String count();
}