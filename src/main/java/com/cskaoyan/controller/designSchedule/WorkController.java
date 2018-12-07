package com.cskaoyan.controller.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Work;
import com.cskaoyan.service.designSchedule.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
        session.setAttribute("sysPermissionList",workerop);
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
}
