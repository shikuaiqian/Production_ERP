package com.cskaoyan.controller.deviceManagement;

import com.cskaoyan.service.deviceManagement.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping("/{page}")
    public String transform(@PathVariable("page") String page){
        switch (page){
            case "deviceList":
                return "deviceList";
            case "deviceType":
                return "deviceType";
            case "deviceCheck":
                return "deviceCheck";
            case "deviceFault":
                return "deviceCheck";
            case "deviceMaintain":
                return "deviceCheck";
        }
        return "/404";
    }
}
