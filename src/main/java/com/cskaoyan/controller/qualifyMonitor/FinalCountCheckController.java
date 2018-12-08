package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.FinalCountCheck;
import com.cskaoyan.service.qualifyMonitor.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
@Controller
@RequestMapping({"/f_count_check","/fCountCheck"})
public class FinalCountCheckController {

    @Autowired
    FinalCountCheckService finalCountCheckService;
    @RequestMapping("find")
    public String find(HttpSession session){
        String[] sysPermissionList = new String[]{"fCountCheck:add","fCountCheck:edit","fCountCheck:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "qualifyMonitor/f_count_check_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows ){
        Map<Object, Object> page1 = finalCountCheckService.findPage(page, rows);
        return page1;

    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String add(){
        return null;
    }
    @RequestMapping("/add")
    public String addPage(){
        return "qualifyMonitor/f_count_check_add";
    }

    @ResponseBody
    @RequestMapping(value = "/insert")
    public Map insert(FinalCountCheck finalCountCheck){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            finalCountCheckService.add(finalCountCheck);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","成品计数增加失败");
        }

        return map;
    }

    @RequestMapping("/edit")
    public String editPage(){
        return "qualifyMonitor/f_count_check_edit";
    }
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String edit(){
        return null;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(FinalCountCheck finalCountCheck){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            finalCountCheckService.edit(finalCountCheck);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","成品计数修改失败");
        }
        return map;
    }
}
