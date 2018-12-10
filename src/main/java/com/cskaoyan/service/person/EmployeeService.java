package com.cskaoyan.service.person;

import com.cskaoyan.domain.person.Employee;
import com.cskaoyan.domain.person.EmployeeVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public Map selectEmployeesByPage(String page, String rows);

    void insert(Employee employee);

    void update(Employee employee);

    void delete(String[] ids);


    Map selectBySearchValue(HashMap<Object, Object> map, String page, String rows);

    List<EmployeeVo> select();
}
