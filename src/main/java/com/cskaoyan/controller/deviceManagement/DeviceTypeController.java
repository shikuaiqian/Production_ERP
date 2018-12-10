package com.cskaoyan.controller.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device;
import com.cskaoyan.domain.deviceManagement.Device_type;
import com.cskaoyan.domain.deviceManagement.vo.ChangeResult;
import com.cskaoyan.service.deviceManagement.interfaces.DeviceTypeService;
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
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping("/list")
    @ResponseBody
    public HashMap<String, Object> getList(@RequestParam("page") String page, @RequestParam("rows") String rows) {
        List list = deviceTypeService.tableInfo(page, rows);
        String tableSize = deviceTypeService.tableSize();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows", list);
        hashMap.put("total", tableSize);
        return hashMap;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public HashMap<String, Object> addJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String addJudgeMsg=deviceTypeService.addJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("addJudgeMsg",addJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public HashMap<String, Object> editJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String editJudgeMsg=deviceTypeService.editJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("editJudgeMsg",editJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public HashMap<String, Object> deleteJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String deleteJudgeMsg =deviceTypeService.deleteJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("deleteJudgeMsg",deleteJudgeMsg);
        return hashMap;
    }

    @RequestMapping("get/{primaryKey}")
    @ResponseBody
    public Object getData(@PathVariable("primaryKey") String primaryKey) {
        Device_type objectByPrimaryKey = deviceTypeService.getObjectByPrimaryKey(primaryKey);
        return objectByPrimaryKey;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List getMappingData() {
        List list = deviceTypeService.getIdMappingName();
        return list;
    }

    @RequestMapping("/add")
    public String getAddPage(@RequestParam("_") String param) {
        String pagePath = "deviceManagement/deviceType_add";
        return pagePath;
    }

    @RequestMapping("/edit")
    public String getEditPage(@RequestParam("_") String param) {
        String pagePath = "deviceManagement/deviceType_edit";
        return pagePath;
    }

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
