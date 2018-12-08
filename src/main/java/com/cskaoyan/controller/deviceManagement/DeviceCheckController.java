package com.cskaoyan.controller.deviceManagement;


import com.cskaoyan.domain.deviceManagement.Device_check;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
import com.cskaoyan.domain.deviceManagement.vo.Device_checkVo;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceCheck")
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    @RequestMapping("/insert")
    @ResponseBody
    public ChangeResult insert(Device_check deviceCheck, String deviceCheckParams) {
        ChangeResult changeResult = deviceCheckService.insert(deviceCheck);
        return changeResult;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ChangeResult update(Device_check deviceCheck, String deviceCheckParams) {
        ChangeResult changeResult = deviceCheckService.update(deviceCheck);
        return changeResult;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ChangeResult deleteBatch(@RequestParam("ids") List<String> deleteList) {
        ChangeResult changeResult = deviceCheckService.deleteBatch(deleteList);
        return changeResult;
    }

    @RequestMapping("/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByDeviceCheckId(@RequestParam("page") String page
            , @RequestParam("rows") String rows , @RequestParam("searchValue") String searchValue) {
        List<Device_checkVo> list=deviceCheckService.searchDeviceByDeviceCheckId(page,rows,searchValue);
        String tableSize =deviceCheckService.tableSizeByDeviceCheckId(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/search_deviceCheck_by_deviceName")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByDeviceName(@RequestParam("page") String page
            , @RequestParam("rows") String rows , @RequestParam("searchValue") String searchValue) {
        List<Device_checkVo> list=deviceCheckService.searchDeviceByDeviceName(page,rows,searchValue);
        String tableSize =deviceCheckService.tableSizeByDeviceName(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }




}
