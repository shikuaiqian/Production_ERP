package com.cskaoyan.controller.deviceManagement;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/device")
public class DeviceController {


    @RequestMapping("/{pageName}")
    public String transform(@PathVariable("pageName") String pageName, HttpServletRequest httpServletRequest){
        String[] sysPermissionList=null;
        switch (pageName){
            case "deviceList":
                sysPermissionList=new String[]{"deviceManagement111:add","deviceManagement111:edit","deviceManagement111:delete"};
                break;
            case "deviceType":
                sysPermissionList=new String[]{"deviceType:add","deviceType:edit","deviceType:delete"};
                break;
            case "deviceCheck":
                sysPermissionList=new String[]{"deviceCheck:add","deviceCheck:edit","deviceCheck:delete"};
                break;
            case "deviceFault":
                sysPermissionList=new String[]{"deviceFault:add","deviceFault:edit","deviceFault:delete"};
                break;
            case "deviceMaintain":
                sysPermissionList=new String[]{"deviceMaintain:add","deviceMaintain:edit","deviceMaintain:delete"};
                break;
        }

        httpServletRequest.getSession().setAttribute("sysPermissionList",sysPermissionList);
        pageName="deviceManagement/"+pageName;
        return pageName;
    }
}
