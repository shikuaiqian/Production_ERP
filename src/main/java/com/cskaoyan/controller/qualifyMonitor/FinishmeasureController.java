package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.service.qualifyMonitor.FinishmeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String find(){
        return "qualifyMonitor/measurement_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows ){
        Map<Object, Object> page1 = finishmeasureService.findPage(page, rows);
        return page1;

    }


}
