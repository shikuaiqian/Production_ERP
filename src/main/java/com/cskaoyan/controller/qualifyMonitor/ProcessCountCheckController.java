package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.ProcessCountCheck;
import com.cskaoyan.service.qualifyMonitor.ProcessCountCheckService;
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
@RequestMapping({"/p_count_check","/pCountCheck"})
public class ProcessCountCheckController {
    @Autowired
    ProcessCountCheckService processCountCheckService;
    @RequestMapping("find")
    public String find(HttpSession session){
        String[] sysPermissionList = new String[]{"pCountCheck:add","pCountCheck:edit","pCountCheck:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "qualifyMonitor/p_count_check_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows ){
        HashMap<Object, Object> map = new HashMap<>();
        PageInfo<ProcessCountCheck> page1 = processCountCheckService.findPage(page, rows);
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
        return "qualifyMonitor/p_count_check_add";
    }
    @ResponseBody
    @RequestMapping(value = "insert")
    public Map insert(ProcessCountCheck processCountCheck){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            processCountCheckService.add(processCountCheck);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","工序计数增加失败");
        }
        return map;
    }
    @RequestMapping("/edit")
    public String editPage(){
        return "qualifyMonitor/p_count_check_edit";
    }
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String edit(){
        return null;
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(ProcessCountCheck processCountCheck){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            processCountCheckService.edit(processCountCheck);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","工序计数修改失败");
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
            processCountCheckService.delete(ids);
            map.put("status",200);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("search_pCountCheck_by_pCountCheckId")
    public Map SearchByfCountCheckId(String searchValue, int page, int rows){
        Map<Object, Object> fid = processCountCheckService.Search("fid", searchValue, page, rows);
        return fid;
    }
    @ResponseBody
    @RequestMapping("update_note")
    public Map updateNote(String pCountCheckId,String note){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            processCountCheckService.updateNote(pCountCheckId,note);
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
