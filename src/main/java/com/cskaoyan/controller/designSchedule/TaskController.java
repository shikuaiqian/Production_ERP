package com.cskaoyan.controller.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Task;
import com.cskaoyan.service.designSchedule.TaskService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("task")
public class TaskController {
    
    @Autowired
    TaskService taskService;
    @Autowired
    SecurityManager securityManager;
    @RequestMapping("find")
    public String  find(HttpSession session){
        String[]  taskop=new String[]{"task:add","task:edit","task:delete"};

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        ArrayList<String> perssions = new ArrayList<>();
        boolean[] permitted = subject.isPermitted(taskop);
        for (int i = 0; i <permitted.length ; i++) {
            if(permitted[i]==true)
            {
                perssions.add(taskop[i]);
            }
        }
        session.setAttribute("sysPermissionList",perssions);
        return   "/designSchedule/task/task_list";
    }

    @ResponseBody
    @RequestMapping("list")
    public Map list(String page , String rows)
    {
        Map<String ,Object> tasks=taskService.selectByPage(page,rows);
        return tasks;
    }
    @ResponseBody
    @RequestMapping("search_task_by_taskId")
    public Map searchTaskByTaskId(String searchValue,String page ,String rows)
    {
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("taskId",searchValue);
        Map<String ,Object> tasks=taskService.selectBySearchValue(ret,page,rows);
        return tasks;
    }
    @ResponseBody
    @RequestMapping("search_task_by_taskManufactureSn")
    public Map searchTaskByTaskManufactureSn(String searchValue,String page ,String rows)
    {
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("manufactureSn",searchValue);
        Map<String ,Object> tasks=taskService.selectBySearchValue(ret,page,rows);
        return tasks;
    }
    @ResponseBody
    @RequestMapping("search_task_by_taskWorkId")
    public Map searchTaskByTaskWorkId(String searchValue,String page ,String rows)
    {
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("workId",searchValue);
        Map<String ,Object> tasks=taskService.selectBySearchValue(ret,page,rows);
        return tasks;
    }
    @ResponseBody
    @RequestMapping("add_judge")
    @RequiresPermissions(value="task:add",logical = Logical.AND)
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "/designSchedule/task/task_add";
    }
    @ResponseBody
    @RequestMapping("insert")
    public Map insert(  Task task){
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try {
            taskService.insert(task);
        }catch (Exception e)
        {
            e.printStackTrace();
            map.put("msg","该客户编号已经存在，请更换客户编号！");
            map.put("status",0);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("delete_judge")
    @RequiresPermissions(value="task:delete",logical = Logical.AND)
    public  String deleteJudge (){
        return null;
    }
    @ResponseBody
    @RequestMapping("delete_batch")
    public Map delete(String[] ids)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try{
            taskService.delete(ids);
        }catch (Exception e)
        {
            e.printStackTrace();

            map.put("msg","删除失败请重试");
            map.put("status",0);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("edit_judge")
    @RequiresPermissions(value="task:edit",logical = Logical.AND)
    public  String editJudge (){
        return null;
    }
    @RequestMapping("edit")
    public String edit()
    {
        return "/designSchedule/task/task_edit";
    }
    @ResponseBody
    @RequestMapping("update_all")
    @RequiresPermissions(value="task:edit",logical = Logical.AND)
    public Map updateAll( Task task)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try{
            taskService.update(task);
        }catch (Exception e)
        {
            e.printStackTrace();

            map.put("msg","修改失败请重试");
            map.put("status",0);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/get/{taskId}")
    public Task getCustomById(@PathVariable String taskId){
        return  taskService.getTaskIdById(taskId);
    }
}
