package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.FinalCountCheck;
import com.cskaoyan.service.qualifyMonitor.FinalCountCheckService;
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
@RequestMapping({"/f_count_check","/fCountCheck"})
public class FinalCountCheckController {

    @Autowired
    FinalCountCheckService finalCountCheckService;

    @RequestMapping("find")
    public String find(HttpSession session) {
        String[] sysPermissionList = new String[]{"fCountCheck:add", "fCountCheck:edit", "fCountCheck:delete"};
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "qualifyMonitor/f_count_check_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows) {
        HashMap<Object, Object> map = new HashMap<>();
        PageInfo<FinalCountCheck> page1 = finalCountCheckService.findPage(page, rows);
        map.put("total",page1.getTotal());
        map.put("rows",page1.getList());
        return map;

    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String add() {
        return null;
    }

    @RequestMapping("/add")
    public String addPage() {
        return "qualifyMonitor/f_count_check_add";
    }

    @ResponseBody
    @RequestMapping(value = "/insert")
    public Map insert(FinalCountCheck finalCountCheck) {
        HashMap<Object, Object> map = new HashMap<>();
        try {
            finalCountCheckService.add(finalCountCheck);
            map.put("status", 200);
            map.put("msg", "success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 500);
            map.put("msg", "成品计数增加失败");
        }

        return map;
    }

    @RequestMapping("/edit")
    public String editPage() {
        return "qualifyMonitor/f_count_check_edit";
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public String edit() {
        return null;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(FinalCountCheck finalCountCheck) {
        HashMap<Object, Object> map = new HashMap<>();
        try {
            finalCountCheckService.edit(finalCountCheck);
            map.put("status", 200);
            map.put("msg", "success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 500);
            map.put("msg", "成品计数修改失败");
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
            finalCountCheckService.delete(ids);
            map.put("status",200);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("search_fCountCheck_by_fCountCheckId")
    public Map SearchByfCountCheckId(String searchValue, int page, int rows){
        Map<Object, Object> fid = finalCountCheckService.Search("fid", searchValue, page, rows);
        return fid;
    }

    @ResponseBody
    @RequestMapping("search_fCountCheck_by_orderId")
    public Map SearchByorderId(String searchValue, int page, int rows){
        Map<Object, Object> fid = finalCountCheckService.Search("oid", searchValue, page, rows);
        return fid;
    }
    @ResponseBody
    @RequestMapping("update_note")
    public Map updateNote(String fCountCheckId,String note){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            finalCountCheckService.updateNote(fCountCheckId,note);
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