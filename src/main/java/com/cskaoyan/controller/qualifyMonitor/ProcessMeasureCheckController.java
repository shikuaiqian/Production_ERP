package com.cskaoyan.controller.qualifyMonitor;


import com.cskaoyan.domain.qualifyMonitor.ProcessMeasureCheck;
import com.cskaoyan.domain.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.service.qualifyMonitor.ProcessMeasureCheckService;
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
@RequestMapping("/p_measure_check")
public class ProcessMeasureCheckController {
    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;
    @RequestMapping("find")
    public String find(HttpSession session){
        String[] sysPermissionList = new String[]{"pMeasureCheck:add","pMeasureCheck:edit","pMeasureCheck:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "qualifyMonitor/p_measure_check_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows ){
        Map<Object, Object> page1 = processMeasureCheckService.findPage(page, rows);
        return page1;

    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add(){
        return null;
    }
    @RequestMapping("add")
    public String addPage(){
        return "qualifyMonitor/p_measure_check_add";
    }

    @ResponseBody
    @RequestMapping(value = "insert")
    public Map insert(ProcessMeasureCheck processMeasureCheck){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            processMeasureCheckService.add(processMeasureCheck);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","工序质量增加失败");
        }
            return map;

    }
}
