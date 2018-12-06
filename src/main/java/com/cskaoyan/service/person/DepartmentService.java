package com.cskaoyan.service.person;

import com.cskaoyan.domain.person.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Department> findAllDepartment(int limit,int offset);
    String count();

    Map selectDepartmentByPage(String page, String rows);


}
