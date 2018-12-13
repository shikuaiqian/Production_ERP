package com.cskaoyan.controller.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Work;
import com.cskaoyan.service.designSchedule.WorkService;
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
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("work")
public class WorkController {
    @Autowired
    WorkService workService;
    @RequestMapping("find")
    public String  find(HttpSession session){
        String[]  workerop=new String[]{"work:add","work:edit","work:delete"};
        Factory<SecurityManager> factory =new IniSecurityManagerFactory("classpath:spring/shiro-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        ArrayList<String> perssions = new ArrayList<>();
        boolean[] permitted = subject.isPermitted(workerop);
        for (int i = 0; i <permitted.length ; i++) {
            if(permitted[i]==true)
            {
                perssions.add(workerop[i]);
            }
        }
        session.setAttribute("sysPermissionList",perssions);
        return   "/designSchedule/work/work_list";
    }

    @ResponseBody
    @RequestMapping("list")
    public Map list(String page , String rows)
    {
        Map<String ,Object> workers=workService.selectByPage(page,rows);
        return workers;
    }
    @ResponseBody
    @RequestMapping("search_work_by_workId")
    public Map search_work_by_workId(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("workId",searchValue);
        Map<String ,Object> workers=workService.selectBysearchValue(ret,page,rows);
        return workers;
    }
    @ResponseBody
    @RequestMapping("search_work_by_workProduct")
    public Map search_work_by_workProduct(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("productName",searchValue);
        Map<String ,Object> workers=workService.selectBysearchValue(ret,page,rows);
        return workers;
    }
    @ResponseBody
    @RequestMapping("search_work_by_workDevice")
    public Map search_work_by_workDevice(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("deviceName",searchValue);
        Map<String ,Object> workers=workService.selectBysearchValue(ret,page,rows);
        return workers;
    }
    @ResponseBody
    @RequestMapping("search_work_by_workProcess")
    public Map search_work_by_workProcess(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("sequence",searchValue);
        Map<String ,Object> workers=workService.selectBysearchValue(ret,page,rows);
        return workers;
    }

    @ResponseBody
    @RequestMapping("add_judge")
    @RequiresPermissions(value="work:add",logical = Logical.AND)
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "/designSchedule/work/work_add";
    }
    @ResponseBody
    @RequestMapping("insert")
    public Map insert(Work work){
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try {
            workService.insert(work);
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
    @RequiresPermissions(value = "work;delete",logical = Logical.AND)
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
            workService.delete(ids);
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
    @RequiresPermissions(value="work:edit",logical = Logical.AND)
    public  String editJudge (){
        return null;
    }
    @RequestMapping("edit")
    public String edit()
    {
        return "/designSchedule/work/work_edit";
    }
    @ResponseBody
    @RequestMapping("update_all ")
    public Map updateAll(Work work)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try{
            workService.update(work);
        }catch (Exception e)
        {
            e.printStackTrace();

            map.put("msg","修改失败请重试");
            map.put("status",0);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("get_data")
    public List<Work> getData()
    {
        List<Work> works= workService.findAll();
        return works;
    }

    @ResponseBody
    @RequestMapping("/get/{workId}")
    public Work getCustomById(@PathVariable String workId){
        return  workService.getWorkIdById(workId);
    }
}
