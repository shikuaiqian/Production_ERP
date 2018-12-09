package com.cskaoyan.controller.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device_maintain;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
import com.cskaoyan.domain.deviceManagement.vo.Device_maintainVo;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("/insert")
    @ResponseBody
    public ChangeResult insert(Device_maintain deviceMaintain, String deviceMaintainParams) {
        ChangeResult changeResult = deviceMaintainService.insert(deviceMaintain);
        return changeResult;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ChangeResult update(Device_maintain deviceMaintain, String deviceMaintainParams) {
        ChangeResult changeResult = deviceMaintainService.update(deviceMaintain);
        return changeResult;
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public ChangeResult updateNote(String deviceMaintainId,String note) {
        ChangeResult changeResult = deviceMaintainService.updateNote(deviceMaintainId,note);
        return changeResult;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ChangeResult deleteBatch(@RequestParam("ids") List<String> deleteList) {
        ChangeResult changeResult = deviceMaintainService.deleteBatch(deleteList);
        return changeResult;
    }

    @RequestMapping("/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByDeviceMaintainId(@RequestParam("page") String page
            , @RequestParam("rows") String rows , @RequestParam("searchValue") String searchValue) {
        List<Device_maintainVo> list=deviceMaintainService.searchDeviceByDeviceMaintainId(page,rows,searchValue);
        String tableSize =deviceMaintainService.tableSizeByDeviceMaintainId(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByDeviceFaultId(@RequestParam("page") String page
            , @RequestParam("rows") String rows , @RequestParam("searchValue") String searchValue) {
        List<Device_maintainVo> list=deviceMaintainService.searchDeviceByDeviceFaultId(page,rows,searchValue);
        String tableSize =deviceMaintainService.tableSizeByDeviceFaultId(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }
}
