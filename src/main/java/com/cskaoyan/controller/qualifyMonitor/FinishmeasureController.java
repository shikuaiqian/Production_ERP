package com.cskaoyan.controller.qualifyMonitor;


import com.cskaoyan.domain.qualifyMonitor.FinalMeasuretCheck;
import com.cskaoyan.service.qualifyMonitor.FinishmeasureService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LZH on 2018/12/6
 */
@Controller
@RequestMapping({"/measure","/fMeasureCheck"})
public class FinishmeasureController {
    @Autowired
    FinishmeasureService finishmeasureService;

    @RequestMapping("find")
    public String find(HttpSession session){
        String[] sysPermissionList = new String[]{"fMeasureCheck:add","fMeasureCheck:edit","fMeasureCheck:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "qualifyMonitor/measurement_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows ){
        HashMap<Object, Object> map = new HashMap<>();
        PageInfo<FinalMeasuretCheck> page1 = finishmeasureService.findPage(page, rows);
        map.put("total",page1.getTotal());
        map.put("rows",page1.getList());
        return map;

    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add(){
        return null;
    }
    @RequestMapping("add")
    public String addPage(){
        return "qualifyMonitor/measurement_add";
    }
    @ResponseBody
    @RequestMapping(value = "insert")
    public Map insert(FinalMeasuretCheck finalMeasuretCheck){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            finishmeasureService.add(finalMeasuretCheck);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","成品计量增加失败");
        }
        return map;
    }

    @RequestMapping("/edit")
    public String editPage(){
        return "qualifyMonitor/measurement_list";
    }
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String edit(){
        return null;
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(FinalMeasuretCheck finalMeasuretCheck){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            finishmeasureService.edit(finalMeasuretCheck);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","成品计量修改失败");
        }
        return map;
    }
    @RequestMapping("delete_judge")
    @ResponseBody
    public String delete() {
        return null;
    }
    @ResponseBody
    @RequestMapping("delete_batch")
    public Map deleteById(String[] ids){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            finishmeasureService.delete(ids);
            map.put("status",200);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("search_fMeasureCheck_by_fMeasureCheckId")
    public Map SearchByfCountCheckId(String searchValue, int page, int rows){
        Map<Object, Object> fid = finishmeasureService.Search("fid", searchValue, page, rows);
        return fid;
    }

    @ResponseBody
    @RequestMapping("search_fMeasureCheck_by_orderId")
    public Map SearchByorderId(String searchValue, int page, int rows){
        Map<Object, Object> fid = finishmeasureService.Search("oid", searchValue, page, rows);
        return fid;
    }
    @ResponseBody
    @RequestMapping("update_note")
    public Map updateNote(String fMeasureCheckId,String note){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            finishmeasureService.updateNote(fMeasureCheckId,note);
            map.put("status",200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","备注更新失败");
        }
        return map;
    }
}
