package com.cskaoyan.controller.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device_type;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping("/insert")
    @ResponseBody
    public ChangeResult insert(Device_type deviceType, String deviceTypeParams) {
        ChangeResult changeResult = deviceTypeService.insert(deviceType);
        return changeResult;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ChangeResult update(Device_type deviceType, String deviceTypeParams) {
        ChangeResult changeResult = deviceTypeService.update(deviceType);
        return changeResult;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ChangeResult updateAll(Device_type deviceType) {
        ChangeResult changeResult = deviceTypeService.update(deviceType);
        return changeResult;
    }



    @RequestMapping("/delete_batch")
    @ResponseBody
    public ChangeResult deleteBatch(@RequestParam("ids") List<String> deleteList) {
        ChangeResult changeResult = deviceTypeService.deleteBatch(deleteList);
        return changeResult;
    }

    @RequestMapping("/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByDeviceTypeId(@RequestParam("page") String page
            , @RequestParam("rows") String rows , @RequestParam("searchValue") String searchValue) {
        List<Device_type> list=deviceTypeService.searchDeviceByDeviceTypeId(page,rows,searchValue);
        String tableSize =deviceTypeService.tableSizeByDeviceTypeId(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByDeviceTypeName(@RequestParam("page") String page
            , @RequestParam("rows") String rows , @RequestParam("searchValue") String searchValue) {
        List<Device_type> list=deviceTypeService.searchDeviceByDeviceTypeName(page,rows,searchValue);
        String tableSize =deviceTypeService.tableSizeByDeviceTypeName(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }
}
