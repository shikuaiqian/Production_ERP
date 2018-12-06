package com.cskaoyan.service.person.imp;

import com.cskaoyan.dao.person.DepartmentMapper;
import com.cskaoyan.domain.person.Department;
import com.cskaoyan.service.person.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceimp implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAllDepartment(int limit, int offset) {
        return departmentMapper.selectDepartmentList(limit,offset);
    }

    @Override
    public String count() {
        return departmentMapper.count();
    }

    @Override
    public Map selectDepartmentByPage(String page, String rows) {
        System.out.println(page);
        System.out.println(rows);
        int i = Integer.parseInt(page);
        int j = Integer.parseInt(rows);
        int limit = j;
        int offset =(i-1)*j;
        List<Department> allDepartment = departmentMapper.selectDepartmentList(limit, offset);
        String count = departmentMapper.count();

        HashMap<String,Object> ret=new HashMap<>();
        ret.put("total",count);
        ret.put("rows",allDepartment);
        return ret;
    }

}
