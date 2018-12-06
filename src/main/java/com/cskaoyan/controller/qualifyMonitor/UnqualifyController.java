package com.cskaoyan.controller.qualifyMonitor;


import com.cskaoyan.service.qualifyMonitor.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by LZH on 2018/12/5
 */
@Controller
@RequestMapping("/unqualify")
public class UnqualifyController {
   @Autowired
   UnqualifyService unqualifyService;

    @RequestMapping("find")
    public String find(){
        return "qualifyMonitor/unqualify_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows ){
        Map<Object, Object> page1 = unqualifyService.findPage(page, rows);
        return page1;

    }

}
