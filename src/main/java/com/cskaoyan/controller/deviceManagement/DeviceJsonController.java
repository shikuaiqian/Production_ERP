package com.cskaoyan.controller.deviceManagement;

import com.cskaoyan.service.deviceManagement.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

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

    @RequestMapping("/{oneList}/list")
    @ResponseBody
    public HashMap<String, Object> getList(@PathVariable("oneList") String oneList
            ,@RequestParam("page") String page, @RequestParam("rows") String rows){
        List list=null;
        String tableSize=null;
        switch (oneList){
            case "deviceList":
                list=deviceListService.tableInfo(page,rows);
                tableSize = deviceListService.tableSize();
                break;
            case "deviceType":
                list=deviceTypeService.tableInfo(page,rows);
                tableSize = deviceTypeService.tableSize();
                break;
            case "deviceCheck":
                list=deviceCheckService.tableInfo(page,rows);
                tableSize = deviceCheckService.tableSize();
                break;
            case "deviceFault":
                list=deviceFaultService.tableInfo(page,rows);
                tableSize = deviceFaultService.tableSize();
                break;
            case "deviceMaintain":
                list=deviceMaintainService.tableInfo(page,rows);
                tableSize = deviceMaintainService.tableSize();
                break;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",list);
        hashMap.put("total",tableSize);
        return hashMap;
    }

    @RequestMapping("/{oneList}/add_judge")
    @ResponseBody
    public HashMap<String, Object> addJudge(@PathVariable("oneList") String oneList
            ,HttpServletRequest httpServletRequest){
        String userId=null;
        String addJudgeMsg=null;
        switch (oneList){
            case "deviceList":
                addJudgeMsg=deviceListService.addJudge(userId);
                break;
            case "deviceType":
                addJudgeMsg=deviceTypeService.addJudge(userId);
                break;
            case "deviceCheck":
                addJudgeMsg=deviceCheckService.addJudge(userId);
                break;
            case "deviceFault":
                addJudgeMsg=deviceFaultService.addJudge(userId);
                break;
            case "deviceMaintain":
                addJudgeMsg=deviceMaintainService.addJudge(userId);
                break;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("addJudgeMsg",addJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/{oneList}/edit_judge")
    @ResponseBody
    public HashMap<String, Object> editJudge(@PathVariable("oneList") String oneList
            ,HttpServletRequest httpServletRequest){
        String userId=null;
        String editJudgeMsg=null;
        switch (oneList){
            case "deviceList":
                editJudgeMsg=deviceListService.editJudge(userId);
                break;
            case "deviceType":
                editJudgeMsg=deviceTypeService.editJudge(userId);
                break;
            case "deviceCheck":
                editJudgeMsg=deviceCheckService.editJudge(userId);
                break;
            case "deviceFault":
                editJudgeMsg=deviceFaultService.editJudge(userId);
                break;
            case "deviceMaintain":
                editJudgeMsg=deviceMaintainService.editJudge(userId);
                break;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("editJudgeMsg",editJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/{oneList}/delete_judge")
    @ResponseBody
    public HashMap<String, Object> deleteJudge(@PathVariable("oneList") String oneList
            ,HttpServletRequest httpServletRequest){
        String userId=null;
        String deleteJudgeMsg=null;
        switch (oneList){
            case "deviceList":
                deleteJudgeMsg=deviceListService.deleteJudge(userId);
                break;
            case "deviceType":
                deleteJudgeMsg=deviceTypeService.deleteJudge(userId);
                break;
            case "deviceCheck":
                deleteJudgeMsg=deviceCheckService.deleteJudge(userId);
                break;
            case "deviceFault":
                deleteJudgeMsg=deviceFaultService.deleteJudge(userId);
                break;
            case "deviceMaintain":
                deleteJudgeMsg=deviceMaintainService.deleteJudge(userId);
                break;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("deleteJudgeMsg",deleteJudgeMsg);
        return hashMap;
    }

    @RequestMapping("/{pageName}/add")
    public String getAddPage(@PathVariable("pageName") String pageName
            ,@RequestParam("_") String param){
        pageName="deviceManagement/"+pageName+"_add";
        return pageName;
    }

    @RequestMapping("/{pageName}/edit")
    public String getEditPage(@PathVariable("pageName") String pageName
            ,@RequestParam("_") String param){
        pageName="deviceManagement/"+pageName+"_edit";
        return pageName;
    }

    @RequestMapping("/{tableName}/get_data")
    @ResponseBody
    public List getData(@PathVariable("tableName") String tableName){
        List list=null;
        switch (tableName){
            case "department":

                break;
            case "deviceType":
                list=deviceTypeService.getIdMappingName();
                break;
            case "employee":

                break;
            case "deviceFault":
                list=deviceFaultService.getIdMappingName();
                break;
            case "deviceList":
                list=deviceListService.getIdMappingName();
                break;
        }
        return list;
    }





    /*五合一getList
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
    public HashMap<String, Object> deviceType(@RequestParam("page") String page,@RequestParam("rows") String rows){
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
    }*/



}
