package com.cskaoyan.controller.deviceManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device")
public class DeviceController {


    @RequestMapping("/{pageName}")
    public String transform(@PathVariable("pageName") String pageName){
        pageName="deviceManagement/"+pageName;
        return pageName;
    }
}
