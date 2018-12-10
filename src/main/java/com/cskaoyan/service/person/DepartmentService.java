package com.cskaoyan.service.person;


import com.cskaoyan.domain.person.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Department> findAllDepartment(int limit,int offset);
    String count();

    Map selectDepartmentByPage(String page, String rows);

    public void insert(Department department);
    public void update(Department department);
    public void delete(String[] ids);
    public List<Department> searchById(String id);
    public List<Department> searchByName(String name);
    List<Department>  select();
    Department select2(String departmentId);
}
