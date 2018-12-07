package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.ProcessCountCheck;
import com.cskaoyan.service.qualifyMonitor.ProcessCountCheckService;
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
@RequestMapping("/p_count_check")
public class ProcessCountCheckController {
    @Autowired
    ProcessCountCheckService processCountCheckService;
    @RequestMapping("find")
    public String find(HttpSession session){
        String[] sysPermissionList = new String[]{"pCountCheck:add","pCountCheck:edit","pCountCheck:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "qualifyMonitor/p_count_check_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows ){
        Map<Object, Object> page1 = processCountCheckService.findPage(page, rows);
        return page1;

    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add(){
        return null;
    }
    @RequestMapping("add")
    public String addPage(){
        return "qualifyMonitor/p_count_check_add";
    }
    @ResponseBody
    @RequestMapping(value = "insert")
    public Map insert(ProcessCountCheck processCountCheck){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            processCountCheckService.add(processCountCheck);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","工序计数增加失败");
        }
        return map;
    }
}
