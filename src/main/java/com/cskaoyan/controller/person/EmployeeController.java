package com.cskaoyan.controller.person;

import com.cskaoyan.dao.person.DepartmentMapper;
import com.cskaoyan.domain.person.Department;
import com.cskaoyan.domain.person.Employee;
import com.cskaoyan.domain.person.EmployeeVo;
import com.cskaoyan.service.person.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;
    @Autowired
    DepartmentMapper mapper;
    @RequestMapping("/find")
    public String find(HttpSession session){
        String[] strings = new String[]{"employee:add","employee:edit","employee:delete"};
       session.setAttribute("sysPermissionList",strings);
        return "/personalManagement/employee_list";
    }
    @ResponseBody
    @RequestMapping("/edit_judge")
    public String  edit_judge(){
        return "";
    }
    @RequestMapping("/edit")
    public String  edit(){
        return "/personalManagement/employee_edit";
    }
    @ResponseBody
    @RequestMapping("update_all")
    public Map updateAll(Employee employee){
        service.update(employee);
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "ok");
        map.put("data",null);
        return map;
    }

    @ResponseBody
    @RequestMapping("delete_batch")
    public Map delete(String[] ids){
        service.delete(ids);
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "ok");
        map.put("data",null);
        return map;
    }
    @ResponseBody
    @RequestMapping("/delete_judge")
    public String  delete_judge(){
        return "";
    }
    @ResponseBody
    @RequestMapping("/list")
    public Map list(String page,String rows){
        Map map = service.selectEmployeesByPage(page, rows);
       return map;
    }
    @ResponseBody
    @RequestMapping("/add_judge")
    public String  add_judge(){
        return "";
    }
    @RequestMapping("/add")
    public String  add(){
        return "/personalManagement/employee_add";
    }
    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(@Valid Employee employee, BindingResult bindingResult, Model model){
        HashMap<Object, Object> map = new HashMap<>();
        if(bindingResult.hasFieldErrors()){
            FieldError username = bindingResult.getFieldError();
            String field = username.getDefaultMessage();
            System.out.println(field);
           // model.addAttribute("usernameerror",field);
            map.put("status",100);
            //mag里面放的是错误信息.
            map.put("msg",field);
            return map;
        }else {
            try {
                service.insert(employee);
                map.put("status", 200);
                map.put("msg", "ok");
                //重复报异常
            }catch (Exception e)
            {
                e.printStackTrace();
                map.put("status",0);
                map.put("msg","该员工编号已经存在，请更换员工编号！");
            }

            return map;
        }
        }

    @ResponseBody
    @RequestMapping("/search_employee_by_employeeId")
    public Map search_department_by_employeeId(String searchValue,String page,String rows){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("employeeId",searchValue);
        Map map1 = service.selectBySearchValue(map, page, rows);
        return map1;
    }
    @ResponseBody
    @RequestMapping("/search_employee_by_employeeName")
    public Map search_department_by_employeeName(String searchValue,String page,String rows){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("employeeName",searchValue);
        Map map1 = service.selectBySearchValue(map, page, rows);
        return map1;
    }
    @ResponseBody
    @RequestMapping("/search_employee_by_departmentName")
    public Map search_department_by_departmentName(String searchValue,String page,String rows){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("departmentName",searchValue);
        Map map1 = service.selectBySearchValue(map, page, rows);
        return map1;
    }
    @ResponseBody
    @RequestMapping("/get_data")
    public List get_data(){
        List<EmployeeVo> select = service.select();
        return select;
    }



}



