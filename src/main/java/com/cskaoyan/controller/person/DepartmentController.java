package com.cskaoyan.controller.person;

import com.cskaoyan.domain.Custom;
import com.cskaoyan.domain.person.Department;
import com.cskaoyan.service.person.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService service;
    @RequestMapping("/find")
    public String find(HttpSession session){
        //看jsp
        String[] strings = new String[]{"department:add","department:edit","department:delete"};
        session.setAttribute("sysPermissionList",strings);
        return "/personalManagement/department_list";
    }
    @ResponseBody
    @RequestMapping("/list")
    public Map list( String page, String rows){
        Map map = service.selectDepartmentByPage(page, rows);
        return map;
    }
    @ResponseBody
    @RequestMapping("/edit_judge")
    public String  edit_judge(){
        return "";
    }
    @ResponseBody
    @RequestMapping("/add_judge")
    public String  add_judge(){
        return "";
    }
    @ResponseBody
    @RequestMapping("/delete_judge")
    public String  delete_judge(){
        return "";
    }
    @RequestMapping("/add")
    public String  add(){
        return "/personalManagement/department_add";
    }
    @RequestMapping("/edit")
    public String  edit(){
        return "/personalManagement/department_edit";
    }
    @ResponseBody
   @RequestMapping("/insert")
    public Map insert(@Valid Department department, BindingResult bindingResult, Model model){
        HashMap<String, Object> map = new HashMap<>();
        if (bindingResult.hasFieldErrors()){
           //验证失败了

           FieldError username = bindingResult.getFieldError();

           String field = username.getDefaultMessage();
            System.out.println(field);
           model.addAttribute("usernameerror",field);
           map.put("status",0);
            map.put("msg","该输入项为必填项");
            return map;
       }else {
        try {
            service.insert(department);
            map.put("status", 200);
            map.put("msg", "ok");
            //重复报异常
        }catch (Exception e)
        {
            e.printStackTrace();
            map.put("status",0);
            map.put("msg","该部门编号已经存在，请更换部门编号！");
        }

            return map;
        }
   }
    @ResponseBody
    @RequestMapping("update_all")
    public Map updateAll(Department department){
        service.update(department);
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
    @RequestMapping("search_department_by_departmentId")
    public Map search_department_by_departmentId(String searchValue,String page,String rows){
        List<Department> departments = service.searchById(searchValue);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("rows",departments);
        map.put("total",1);
        return map;
    }

    @ResponseBody
    @RequestMapping("search_department_by_departmentName")
    public Map search_department_by_departmentName(String searchValue,String page,String rows){
        List<Department> departments = service.searchByName(searchValue);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("rows",departments);
        map.put("total",1);
        return map;
    }
}

