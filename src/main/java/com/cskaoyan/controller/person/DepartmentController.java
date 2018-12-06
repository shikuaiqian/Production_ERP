package com.cskaoyan.controller.person;

import com.cskaoyan.domain.person.Department;
import com.cskaoyan.service.person.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService service;
    @RequestMapping("/find")
    public String find(){
        return "/department_list";
    }
    @ResponseBody
    @RequestMapping("/list")
    public Map list( String page,  String rows){
        Map map = service.selectDepartmentByPage(page, rows);
        return map;
    }

}
