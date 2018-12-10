package com.cskaoyan.controller.deviceManagement;


import com.cskaoyan.domain.deviceManagement.Device;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
import com.cskaoyan.domain.deviceManagement.vo.DeviceVo;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceListService;
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
@RequestMapping("/deviceList")
public class DeviceListController {

    @Autowired
    DeviceListService deviceListService;

    @RequestMapping("/list")
    @ResponseBody
    public HashMap<String, Object> getList(@RequestParam("page") String page, @RequestParam("rows") String rows) {
        List list = deviceListService.tableInfo(page, rows);
        String tableSize = deviceListService.tableSize();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows", list);
        hashMap.put("total", tableSize);
        return hashMap;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public HashMap<String, Object> addJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String addJudgeMsg=deviceListService.addJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("addJudgeMsg",addJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public HashMap<String, Object> editJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String editJudgeMsg=deviceListService.editJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("editJudgeMsg",editJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public HashMap<String, Object> deleteJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String deleteJudgeMsg =deviceListService.deleteJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("deleteJudgeMsg",deleteJudgeMsg);
        return hashMap;
    }

    @RequestMapping("get/{primaryKey}")
    @ResponseBody
    public Object getData(@PathVariable("primaryKey") String primaryKey) {
        Device objectByPrimaryKey = deviceListService.getObjectByPrimaryKey(primaryKey);
        return objectByPrimaryKey;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List getMappingData() {
        List list = deviceListService.getIdMappingName();
        return list;
    }

    @RequestMapping("/add")
    public String getAddPage(@RequestParam("_") String param) {
        String pagePath = "deviceManagement/deviceList_add";
        return pagePath;
    }

    @RequestMapping("/edit")
    public String getEditPage(@RequestParam("_") String param) {
        String pagePath = "deviceManagement/deviceList_edit";
        return pagePath;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ChangeResult insert(Device device, String deviceParams) {
        ChangeResult changeResult = deviceListService.insert(device);
        return changeResult;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ChangeResult update(Device device, String deviceParams) {
        ChangeResult changeResult = deviceListService.update(device);
        return changeResult;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ChangeResult updateAll(Device device) {
        ChangeResult changeResult = deviceListService.update(device);
        return changeResult;
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public ChangeResult updateNote(String deviceId,String note) {
        ChangeResult changeResult = deviceListService.updateNote(deviceId,note);
        return changeResult;
    }


    @RequestMapping("/delete_batch")
    @ResponseBody
    public ChangeResult deleteBatch(@RequestParam("ids") List<String> deleteList) {
        ChangeResult changeResult = deviceListService.deleteBatch(deleteList);
        return changeResult;
    }

    @RequestMapping("/search_device_by_deviceId")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByDeviceId(@RequestParam("page") String page
            ,@RequestParam("rows") String rows ,@RequestParam("searchValue") String searchValue) {
        List<DeviceVo> list=deviceListService.searchDeviceByDeviceId(page,rows,searchValue);
        String tableSize =deviceListService.tableSizeByDeviceId(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/search_device_by_deviceName")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByDeviceName(@RequestParam("page") String page
            ,@RequestParam("rows") String rows ,@RequestParam("searchValue") String searchValue) {
        List<DeviceVo> list=deviceListService.searchDeviceByDeviceName(page,rows,searchValue);
        String tableSize =deviceListService.tableSizeByDeviceName(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/search_device_by_deviceTypeName")
    @ResponseBody
    public HashMap<String, Object> searchDeviceByDeviceTypeName(@RequestParam("page") String page
            ,@RequestParam("rows") String rows ,@RequestParam("searchValue") String searchValue) {
        List<DeviceVo> list=deviceListService.searchDeviceByDeviceTypeName(page,rows,searchValue);
        String tableSize =deviceListService.tableSizeByDeviceTypeName(searchValue);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }
}
