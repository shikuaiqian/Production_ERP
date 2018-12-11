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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceCheck")
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    @RequestMapping("/list")
    @ResponseBody
    public HashMap<String, Object> getList(@RequestParam("page") String page, @RequestParam("rows") String rows) {
        List list = deviceCheckService.tableInfo(page, rows);
        String tableSize = deviceCheckService.tableSize();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows", list);
        hashMap.put("total", tableSize);
        return hashMap;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public HashMap<String, Object> addJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String addJudgeMsg=deviceCheckService.addJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("addJudgeMsg",addJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public HashMap<String, Object> editJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String editJudgeMsg=deviceCheckService.editJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("editJudgeMsg",editJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public HashMap<String, Object> deleteJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String deleteJudgeMsg =deviceCheckService.deleteJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("deleteJudgeMsg",deleteJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/add")
    public String getAddPage(@RequestParam("_") String param) {
        String pagePath = "deviceManagement/deviceCheck_add";
        return pagePath;
    }

    @RequestMapping("/edit")
    public String getEditPage(@RequestParam("_") String param) {
        String pagePath = "deviceManagement/deviceCheck_edit";
        return pagePath;
    }

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

    @RequestMapping("/update_note")
    @ResponseBody
    public ChangeResult updateCheckResult(String deviceCheckId,String deviceCheckResult) {
        ChangeResult changeResult = deviceCheckService.updateCheckResult(deviceCheckId,deviceCheckResult);
        return changeResult;
    }




}
