package com.cskaoyan.controller.qualifyMonitor;


import com.cskaoyan.domain.qualifyMonitor.FinalMeasuretCheck;
import com.cskaoyan.service.qualifyMonitor.FinishmeasureService;
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
@RequestMapping("/measure")
public class FinishmeasureController {
    @Autowired
    FinishmeasureService finishmeasureService;

    @RequestMapping("find")
    public String find(HttpSession session){
        String[] sysPermissionList = new String[]{"fMeasureCheck:add","fMeasureCheck:edit","fMeasureCheck:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "qualifyMonitor/measurement_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows ){
        Map<Object, Object> page1 = finishmeasureService.findPage(page, rows);
        return page1;

    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add(){
        return null;
    }
    @RequestMapping("add")
    public String addPage(){
        return "qualifyMonitor/measurement_add";
    }
    @ResponseBody
    @RequestMapping(value = "insert")
    public Map insert(FinalMeasuretCheck finalMeasuretCheck){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            finishmeasureService.add(finalMeasuretCheck);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","成品计量增加失败");
        }
        return map;
    }


}
