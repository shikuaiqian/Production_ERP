package com.cskaoyan.service.person.imp;

import com.cskaoyan.dao.person.DepartmentMapper;
import com.cskaoyan.dao.person.EmployeeMapper;
import com.cskaoyan.domain.designScheduleDomain.OrderVo;
import com.cskaoyan.domain.person.Department;
import com.cskaoyan.domain.person.Employee;
import com.cskaoyan.domain.person.EmployeeVo;
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
        List<EmployeeVo> employees = employeeMapper.selectEmployeeList(limit, offset);
        String count = employeeMapper.count();
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("total",count);
        ret.put("rows",employees);
        return ret;
    }

    @Override
    public void insert(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void delete(String[] ids) {
        for (int i = 0; i <ids.length; i++) {
            employeeMapper.deleteByPrimaryKey(ids[i]+"");
        }

    }

    @Override
    public  Map<String, Object> selectBySearchValue(HashMap<Object, Object> map, String page, String rows) {
        int i = Integer.parseInt(page);
        int j = Integer.parseInt(rows);
        int limit = j;
        int offset =(i-1)*j;
        List<EmployeeVo> employeeVos = employeeMapper.selectEmployeeList2(map, limit, offset);
        String s = employeeMapper.count2(map);
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("rows",employeeVos);
        map1.put("total",s);
        return map1;
    }

    @Override
    public List<EmployeeVo> select() {
        return employeeMapper.select();
    }

    @Override
    public EmployeeVo show(String id) {
        return employeeMapper.selectByPrimaryKey(id);
    }
}
