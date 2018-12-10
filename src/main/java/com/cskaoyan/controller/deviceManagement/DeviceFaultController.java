package com.cskaoyan.controller.deviceManagement;


import com.cskaoyan.domain.deviceManagement.Device_fault;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
import com.cskaoyan.domain.deviceManagement.vo.Device_faultVo;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceFault")
public class DeviceFaultController {


    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("/list")
    @ResponseBody
    public HashMap<String, Object> getList(@RequestParam("page") String page, @RequestParam("rows") String rows) {
        List list = deviceFaultService.tableInfo(page, rows);
        String tableSize = deviceFaultService.tableSize();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows", list);
        hashMap.put("total", tableSize);
        return hashMap;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public HashMap<String, Object> addJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String addJudgeMsg=deviceFaultService.addJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("addJudgeMsg",addJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public HashMap<String, Object> editJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String editJudgeMsg=deviceFaultService.editJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("editJudgeMsg",editJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public HashMap<String, Object> deleteJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String deleteJudgeMsg =deviceFaultService.deleteJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("deleteJudgeMsg",deleteJudgeMsg);
        return hashMap;
    }

    @RequestMapping("get/{primaryKey}")
    @ResponseBody
    public Object getData(@PathVariable("primaryKey") String primaryKey) {
        Device_fault objectByPrimaryKey = deviceFaultService.getObjectByPrimaryKey(primaryKey);
        return objectByPrimaryKey;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List getMappingData() {
        List list = deviceFaultService.getIdMappingName();
        return list;
    }

    @RequestMapping("/add")
    public String getAddPage(@RequestParam("_") String param) {
        String pagePath = "deviceManagement/deviceFault_add";
        return pagePath;
    }

    @RequestMapping("/edit")
    public String getEditPage(@RequestParam("_") String param) {
        String pagePath = "deviceManagement/deviceFault_edit";
        return pagePath;
    }

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

    @RequestMapping("/update_all")
    @ResponseBody
    public ChangeResult updateAll(Device_fault deviceFault) {
        ChangeResult changeResult = deviceFaultService.update(deviceFault);
        return changeResult;
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public ChangeResult updateFaultDetail(String deviceFaultId,String deviceFaultDetail) {
        ChangeResult changeResult = deviceFaultService.updateFaultDetail(deviceFaultId,deviceFaultDetail);
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
    public HashMap<String, Object> searchDeviceByDeviceFaultId(@RequestParam("page") String page
            , @RequestParam("rows") String rows , @RequestParam("searchValue") String searchValue) {
        List<Device_faultVo> list=deviceFaultService.searchDeviceByDeviceFaultId(page,rows,searchValue);
        String tableSize =deviceFaultService.tableSizeByDeviceFaultId(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/search_deviceFault_by_deviceName")
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
