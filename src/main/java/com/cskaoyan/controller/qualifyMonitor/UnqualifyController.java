package com.cskaoyan.controller.qualifyMonitor;


import com.cskaoyan.domain.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.service.qualifyMonitor.UnqualifyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LZH on 2018/12/5
 */
@Controller
@RequestMapping("unqualify")
public class UnqualifyController {
   @Autowired
   UnqualifyService unqualifyService;

    @RequestMapping("find")
    public String find(HttpSession session) {
        String[] sysPermissionList = new String[]{"unqualify:add","unqualify:edit","unqualify:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "qualifyMonitor/unqualify_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows ){
        Map<Object, Object> page1 = unqualifyService.findPage(page, rows);


        return page1;

    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add(){
        return null;
    }
    @RequestMapping("add")
    public String addPage(){
        return "qualifyMonitor/unqualify_add";
    }


    @ResponseBody
    @RequestMapping(value = "insert")
    public Map insert( UnqualifyApply unqualifyApply,String unqualifyParams)  {
        HashMap<Object, Object> map = new HashMap<>();
        try {
            unqualifyService.add(unqualifyApply);
            map.put("status",200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","不合格产品增加失败");
        }

        return map;
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit(){
        return null;
    }

    @RequestMapping("edit")
    public String editPage(){
        return "qualifyMonitor/unqualify_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(UnqualifyApply unqualifyApply){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            unqualifyService.edit(unqualifyApply);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","不合格产品修改失败");
        }
        return map;
    }

}
