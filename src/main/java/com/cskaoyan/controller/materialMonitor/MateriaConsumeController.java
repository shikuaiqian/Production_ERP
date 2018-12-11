package com.cskaoyan.controller.materialMonitor;

import com.cskaoyan.domain.materialMonitor.MaterialConsume;
import com.cskaoyan.service.materiaMonitor.MateriaConsumeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/materialConsume")
@Controller
public class MateriaConsumeController {

    @Autowired
    MateriaConsumeService materiaConsumeService;
    @RequestMapping("/find")
    public String find(HttpSession session) {
        ArrayList<String> func = new ArrayList();
        func.add("materialConsume:add");
        func.add("materialConsume:edit");
        func.add("materialConsume:delete");

        session.setAttribute("sysPermissionList", func);
        return "materialMonitor/materialConsume_list";
    }


    //显示所有MaterialConsume
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(Integer page,Integer rows) {
        //连表查询得到work表和material表的信息
        PageInfo<MaterialConsume> pageInfo = materiaConsumeService.findAllMaterialConsume(page,rows);

        Map<String, Object> info = new HashMap<>();
        info.put("total", pageInfo.getTotal());
        info.put("rows", pageInfo.getList());

        return info;

    }

    @ResponseBody
    @RequestMapping("/add_judge")
    public HashMap<String,Object> add() {
        HashMap<String,Object> ret = new HashMap<>();
        ret.put("msg",null);
        return null;
    }

    @RequestMapping("/add")
    public String addWindow() {
        return "materialMonitor/materialConsume_add";
    }

    //新增
    @ResponseBody
    @RequestMapping("/insert")
    public Map<String, Object> insert(@Valid MaterialConsume materialConsume, BindingResult result) {

        Map<String, Object> info = new HashMap<>();
        if (result.hasFieldErrors()) {
            //验证错误
            List<ObjectError> allErrors = result.getAllErrors();
            info.put("status", 101);

            for (ObjectError error : allErrors) {
                String defaultMessage = error.getDefaultMessage();
                info.put("msg", defaultMessage);
            }
            return info;
        } else {
            boolean ret = materiaConsumeService.insert(materialConsume);
            if (ret) {
                info.put("status", 200);
            }
            return info;
        }
    }

    @ResponseBody
    @RequestMapping("/edit_judge")
    public HashMap<String,Object> edit() {
        HashMap<String,Object> ret = new HashMap<>();
        ret.put("msg",null);
        return null;
    }

    @RequestMapping("/edit")
    public String editWindow() {
        return "materialMonitor/materialConsume_edit";
    }

    //修改备注
    @ResponseBody
    @RequestMapping("/update_note")
    public Map<String, Object> update(String consumeId, String note) {

        Map<String, Object> info = new HashMap<>();

        boolean ret = materiaConsumeService.updateNote(consumeId, note);

        if (ret) {
            info.put("status", 200);
            info.put("msg", "OK");
        }
        return info;

    }

    //修改
    @ResponseBody
    @RequestMapping("/update_all")
    public Map<String, Object> update(@Valid MaterialConsume materialConsume, BindingResult result) {

        Map<String, Object> info = new HashMap<>();
        if (result.hasFieldErrors()) {
            //验证错误
            List<ObjectError> allErrors = result.getAllErrors();
            info.put("status", 101);

            for (ObjectError error : allErrors) {
                String defaultMessage = error.getDefaultMessage();
                info.put("msg", defaultMessage);
            }
            return info;
        } else {
            boolean ret = materiaConsumeService.update(materialConsume);
            if (ret) {
                info.put("status", 200);
            }
            return info;
        }
    }

    //删除
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map<String, Object> delete() {
        Map<String, Object> info = new HashMap<>();

        info.put("msg", null);
        return info;
    }

    @ResponseBody
    @RequestMapping("/delete_batch")
    public Map<String, Object> deleteMulti(String[] ids) {
        int length = ids.length;
        int times = 0;

        for (String id : ids) {
            boolean b = materiaConsumeService.delectById(id);
            if (b) {
                times++;
            }
        }
        if (length == times) {
            Map<String, Object> info = new HashMap<>();
            info.put("status", 200);
            info.put("msg","OK");
            return info;
        }
        return null;
    }

    //搜索
    @ResponseBody
    @RequestMapping(value="/{formName}")
    public Map<String, Object> search(@PathVariable String formName, String searchValue, Integer page, Integer rows) {
        Map<String, Object> info = new HashMap<>();

        //物料消耗编号
        if (formName.contains("consumeId")){
            PageInfo<MaterialConsume> pageInfo= materiaConsumeService.searchConsumeId(searchValue, page, rows);

            info.put("total", pageInfo.getTotal());
            info.put("rows", pageInfo.getList());
            return info;

        }

        //作业编号
        if (formName.contains("workId")){
            PageInfo<MaterialConsume> pageInfo = materiaConsumeService.serachByWorkId(searchValue, page, rows);

            info.put("total", pageInfo.getTotal());
            info.put("rows", pageInfo.getList());
            return info;
        }

        //物料编号
        if (formName.contains("materialId")){
            PageInfo<MaterialConsume> pageInfo = materiaConsumeService.serachByMaterialId(searchValue, page, rows);

            info.put("total", pageInfo.getTotal());
            info.put("rows", pageInfo.getList());
            return info;
        }
        return null;
    }









}
