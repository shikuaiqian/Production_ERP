package com.cskaoyan.controller.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Custom;

import com.cskaoyan.service.designSchedule.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/custom")
@Controller
public class CustomController {
    @Autowired
    CustomService   customService;
    @RequestMapping("find")
    public String  find(HttpSession session){
        String[]  customerop=new String[]{"custom:add","custom:edit","custom:delete"};
        session.setAttribute("sysPermissionList",customerop);
        return   "/designSchedule/custom/custom_list";
    }

    @ResponseBody
    @RequestMapping("list")
    public Map  list(String page ,String rows)
    {
      Map<String ,Object> customers=customService.selectByPage(page,rows);
      return customers;
    }
    @ResponseBody
    @RequestMapping("search_custom_by_customId")
    public Map search_custom_by_customId(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("customId",searchValue);
        Map<String ,Object> customers=customService.selectByIdandPage(ret,page,rows);
        return customers;
    }
    @ResponseBody
    @RequestMapping("search_custom_by_customName")
    public Map search_custom_by_customName(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("customName",searchValue);
        Map<String ,Object> customers=customService.selectBySearchValueandPage(ret,page,rows);

        return customers;
    }

    @ResponseBody
    @RequestMapping("add_judge")
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "/designSchedule/custom/custom_add";
    }
    @ResponseBody
    @RequestMapping("insert")
    public Map insert(Custom custom){
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try {
           customService.insert(custom);
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
           customService.delete(ids);
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
        return "/designSchedule/custom/custom_edit";
    }
    @ResponseBody
    @RequestMapping("update_all ")
    public Map updateAll(Custom custom)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try{
            customService.update(custom);
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
    public List<Custom> getData()
    {
     List<Custom> customs= customService.findAll();
    return customs;
    }
}
