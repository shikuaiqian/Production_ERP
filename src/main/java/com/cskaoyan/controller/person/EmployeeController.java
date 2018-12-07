package com.cskaoyan.controller.person;

import com.cskaoyan.service.person.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @RequestMapping("/find")
    public String find(){
        return "/personalManagement/employee_list";
    }
    @ResponseBody
    @RequestMapping("/list")
    public Map list(String page,String rows){
        Map map = service.selectEmployeesByPage(page, rows);
       return map;
    }
}
