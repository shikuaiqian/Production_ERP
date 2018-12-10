package com.cskaoyan.controller.qualifyMonitor;


import com.cskaoyan.domain.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.service.qualifyMonitor.UnqualifyService;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LZH on 2018/12/5
 */
@Controller
@RequestMapping("unqualify")
public class UnqualifyController {
   @Autowired
   UnqualifyService unqualifyService;

    @RequestMapping("find")
    public String find(HttpSession session) {
        String[] sysPermissionList = new String[]{"unqualify:add","unqualify:edit","unqualify:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "qualifyMonitor/unqualify_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map SelectByPage(int page, int rows ){
        HashMap<Object, Object> map = new HashMap<>();
        PageInfo<UnqualifyApply> page1 = unqualifyService.findPage(page, rows);
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
        return "qualifyMonitor/unqualify_add";
    }


    @ResponseBody
    @RequestMapping(value = "insert")
    public Map insert(@Valid UnqualifyApply unqualifyApply, BindingResult bindingResult)  {

        HashMap<Object, Object> map = new HashMap<>();
        if (bindingResult.hasFieldErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            map.put("status",500);
            map.put("msg",defaultMessage);
        }else {
            try {
                unqualifyService.add(unqualifyApply);
                map.put("status", 200);
                map.put("msg", "success");
            } catch (Exception e) {
                e.printStackTrace();
                map.put("status", 500);
                map.put("msg", "不合格产品增加失败");
            }
        }
        return map;
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit(){
        return null;
    }

    @RequestMapping("edit")
    public String editPage(){
        return "qualifyMonitor/unqualify_edit";
    }
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(UnqualifyApply unqualifyApply){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            unqualifyService.edit(unqualifyApply);
            map.put("status", 200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","不合格产品修改失败");
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
            unqualifyService.delete(ids);
            map.put("status",200);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("search_unqualify_by_unqualifyId")
    public Map SearchByfCountCheckId(String searchValue, int page, int rows){
        Map<Object, Object> fid = unqualifyService.Search("fid", searchValue, page, rows);
        return fid;
    }

    @ResponseBody
    @RequestMapping("search_unqualify_by_productName")
    public Map SearchByorderId(String searchValue, int page, int rows){
        Map<Object, Object> fid = unqualifyService.Search("oid", searchValue, page, rows);
        return fid;
    }

    @ResponseBody
    @RequestMapping("update_note")
    public Map updateNote(String unqualifyApplyId,String note){
        HashMap<Object, Object> map = new HashMap<>();
        try {
            unqualifyService.updateNote(unqualifyApplyId,note);
            map.put("status",200);
            map.put("msg","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",500);
            map.put("msg","备注更新失败");
        }
        return map;
    }

   /* @RequestMapping("get_data")
    @ResponseBody
    public List hshsh(){
        GG gg = new GG();
        gg.setProductId("00001");
        gg.setProductName("投影机");
        GG gg1 = new GG();
        gg1.setProductId("00002");
        gg1.setProductName("壁挂音箱");
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(gg);
        objects.add(gg1);
        return objects;
    }*/
}
