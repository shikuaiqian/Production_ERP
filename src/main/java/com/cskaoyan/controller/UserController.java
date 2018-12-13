package com.cskaoyan.controller;

import com.cskaoyan.domain.User;
import com.cskaoyan.domain.UserSeesion;
import com.cskaoyan.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
   @Autowired
    UserService userService;


   @RequestMapping("find")
    public String  find(HttpSession session){
       SimplePrincipalCollection attribute = (SimplePrincipalCollection) session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY");
        String[]  usererop=new String[]{"user:add","user:edit","user:delete"};
        session.setAttribute("sysPermissionList",usererop);
        return   "user_list";
    }

    @ResponseBody
    @RequestMapping("list")
    public Map list(String page , String rows)
    {
        Map<String ,Object> userers=userService.selectByPage(page,rows);
        return userers;
    }
    @ResponseBody
    @RequestMapping("search_user_by_userId")
    public Map search_user_by_userId(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("userId",searchValue);
        Map<String ,Object> userers=userService.selectByIdandPage(ret,page,rows);
        return userers;
    }
    @ResponseBody
    @RequestMapping("search_user_by_userName")
    public Map search_user_by_userName(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("userName",searchValue);
        Map<String ,Object> userers=userService.selectBySearchValueandPage(ret,page,rows);

        return userers;
    }
    @ResponseBody
    @RequestMapping("search_user_by_rolename")
    public Map search_user_by_roleName(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("roleName",searchValue);
        Map<String ,Object> userers=userService.selectBySearchValueandPage(ret,page,rows);

        return userers;
    }

    @ResponseBody
    @RequestMapping("add_judge")
    @RequiresPermissions(value="user:add",logical = Logical.AND)
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "user_add";
    }
    @ResponseBody
    @RequestMapping("insert")
    public Map insert(UserSeesion user){
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try {
            userService.insert(user);
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
    @RequiresPermissions(value="user:delete",logical = Logical.AND)
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
            userService.delete(ids);
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
    @RequiresPermissions(value="user:edit",logical = Logical.AND)
    public  String editJudge (){
        return null;
    }
    @RequestMapping("edit")
    public String edit()
    {
        return "user_edit";
    }
    @ResponseBody
    @RequestMapping("update_all")
    public Map updateAll(User user)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try{
            userService.update(user);
        }catch (Exception e)
        {
            e.printStackTrace();

            map.put("msg","修改失败请重试");
            map.put("status",0);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("/get/{userId}")
    public User getuserById(@PathVariable String userId){
        return  userService.getuserById(userId);
    }


    
}
