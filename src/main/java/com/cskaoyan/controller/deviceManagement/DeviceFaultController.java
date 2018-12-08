package com.cskaoyan.controller.deviceManagement;


import com.cskaoyan.domain.deviceManagement.Device_fault;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
import com.cskaoyan.domain.deviceManagement.vo.Device_faultVo;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceFault")
public class DeviceFaultController {


    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("/insert")
    @ResponseBody
    public ChangeResult insert(Device_fault deviceFault, String deviceFaultParams) {
        ChangeResult changeResult = deviceFaultService.insert(deviceFault);
        return changeResult;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ChangeResult update(Device_fault deviceFault, String deviceFaultParams) {
        ChangeResult changeResult = deviceFaultService.update(deviceFault);
        return changeResult;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ChangeResult deleteBatch(@RequestParam("ids") List<String> deleteList) {
        ChangeResult changeResult = deviceFaultService.deleteBatch(deleteList);
        return changeResult;
    }

    @RequestMapping("/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByFaultId(@RequestParam("page") String page
            , @RequestParam("rows") String rows , @RequestParam("searchValue") String searchValue) {
        List<Device_faultVo> list=deviceFaultService.searchDeviceByFaultId(page,rows,searchValue);
        String tableSize =deviceFaultService.tableSizeByFaultId(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/search_deviceCheck_by_deviceName")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByDeviceName(@RequestParam("page") String page
            , @RequestParam("rows") String rows , @RequestParam("searchValue") String searchValue) {
        List<Device_faultVo> list=deviceFaultService.searchDeviceByDeviceName(page,rows,searchValue);
        String tableSize =deviceFaultService.tableSizeByDeviceName(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }
}
