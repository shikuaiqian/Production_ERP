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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("/list")
    @ResponseBody
    public HashMap<String, Object> getList(@RequestParam("page") String page, @RequestParam("rows") String rows) {
        List list = deviceMaintainService.tableInfo(page, rows);
        String tableSize = deviceMaintainService.tableSize();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows", list);
        hashMap.put("total", tableSize);
        return hashMap;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public HashMap<String, Object> addJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String addJudgeMsg=deviceMaintainService.addJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("addJudgeMsg",addJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public HashMap<String, Object> editJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String editJudgeMsg=deviceMaintainService.editJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("editJudgeMsg",editJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public HashMap<String, Object> deleteJudge(HttpServletRequest httpServletRequest){
        String userId=null;
        String deleteJudgeMsg =deviceMaintainService.deleteJudge(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("deleteJudgeMsg",deleteJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/add")
    public String getAddPage(@RequestParam("_") String param) {
        String pagePath = "deviceManagement/deviceMaintain_add";
        return pagePath;
    }

    @RequestMapping("/edit")
    public String getEditPage(@RequestParam("_") String param) {
        String pagePath = "deviceManagement/deviceMaintain_edit";
        return pagePath;
    }

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
