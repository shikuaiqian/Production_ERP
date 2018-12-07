package com.cskaoyan.service.person.imp;

import com.cskaoyan.dao.person.DepartmentMapper;
import com.cskaoyan.dao.person.EmployeeMapper;
import com.cskaoyan.domain.person.Department;
import com.cskaoyan.domain.person.Employee;
import com.cskaoyan.service.person.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceimp implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public Map selectEmployeesByPage(String page, String rows) {
        System.out.println(page);
        System.out.println(rows);
        int i = Integer.parseInt(page);
        int j = Integer.parseInt(rows);
        int limit = j;
        int offset =(i-1)*j;
        List<Employee> employees = employeeMapper.selectEmployeeList(limit, offset);
        String count = employeeMapper.count();
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("total",count);
        ret.put("rows",employees);
        return ret;
    }
}
