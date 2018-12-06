package com.cskaoyan.controller.deviceManagement;


import com.cskaoyan.domain.deviceManagement.*;
import com.cskaoyan.domain.deviceManagement.vo.DeviceVo;
import com.cskaoyan.domain.deviceManagement.vo.Device_checkVo;
import com.cskaoyan.domain.deviceManagement.vo.Device_faultVo;
import com.cskaoyan.domain.deviceManagement.vo.Device_maintainVo;
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
        List<DeviceVo> list=deviceListService.tableInfo(page,rows);
        String tableSize = deviceListService.tableSize();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/deviceType/list")
    @ResponseBody
    public HashMap<String, Object> deviceType(@RequestParam("page") String page, @RequestParam("rows") String rows){
        List<Device_type>  list=deviceTypeService.tableInfo(page,rows);
        String tableSize = deviceTypeService.tableSize();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/deviceCheck/list")
    @ResponseBody
    public HashMap<String, Object>  deviceCheck(@RequestParam("page") String page, @RequestParam("rows") String rows){
        List<Device_checkVo>  list=deviceCheckService.tableInfo(page,rows);
        String tableSize = deviceCheckService.tableSize();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/deviceFault/list")
    @ResponseBody
    public HashMap<String, Object>  deviceFault(@RequestParam("page") String page, @RequestParam("rows") String rows){
        List<Device_faultVo>  list=deviceFaultService.tableInfo(page,rows);
        String tableSize = deviceFaultService.tableSize();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/deviceMaintain/list")
    @ResponseBody
    public HashMap<String, Object>  deviceMaintain(@RequestParam("page") String page, @RequestParam("rows") String rows){
        List<Device_maintainVo>  list=deviceMaintainService.tableInfo(page,rows);
        String tableSize = deviceMaintainService.tableSize();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

}
