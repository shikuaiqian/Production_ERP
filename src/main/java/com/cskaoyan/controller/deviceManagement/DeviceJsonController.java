package com.cskaoyan.controller.deviceManagement;


import com.cskaoyan.domain.deviceManagement.*;
import com.cskaoyan.service.deviceManagement.interfaces.*;
import com.cskaoyan.util.deviceManagement.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeviceJsonController {

    @Autowired
    DeviceListService  deviceListService;

    @Autowired
    DeviceTypeService deviceTypeService;

    @Autowired
    DeviceCheckService deviceCheckService;

    @Autowired
    DeviceFaultService deviceFaultService;

    @Autowired
    DeviceMaintainService deviceMaintainService;


    @RequestMapping("/deviceList/list")
    @ResponseBody
    public HashMap<String, Object> list(@RequestParam("page") String page, @RequestParam("rows") String rows){
        List<Device> list=deviceListService.tableInfo(page,rows);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",list.size());
        return hashMap;
    }

    @RequestMapping("/deviceType/list")
    @ResponseBody
    public HashMap<String, Object> deviceType(@RequestParam("page") String page, @RequestParam("rows") String rows){
        List<Device_type>  list=deviceTypeService.tableInfo(page,rows);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",list.size());
        return hashMap;
    }

    @RequestMapping("/deviceCheck/list")
    @ResponseBody
    public HashMap<String, Object>  deviceCheck(@RequestParam("page") String page, @RequestParam("rows") String rows){
        List<Device_check>  list=deviceCheckService.tableInfo(page,rows);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",list.size());
        return hashMap;
    }

    @RequestMapping("/deviceFault/list")
    @ResponseBody
    public HashMap<String, Object>  deviceFault(@RequestParam("page") String page, @RequestParam("rows") String rows){
        List<Device_fault>  list=deviceFaultService.tableInfo(page,rows);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",list.size());
        return hashMap;
    }

    @RequestMapping("/deviceMaintain/list")
    @ResponseBody
    public HashMap<String, Object>  deviceMaintain(@RequestParam("page") String page, @RequestParam("rows") String rows){
        List<Device_maintain>  list=deviceMaintainService.tableInfo(page,rows);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",list.size());
        return hashMap;
    }

}
