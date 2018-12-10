package com.cskaoyan.controller.materialMonitor;


import com.cskaoyan.domain.materialMonitor.Material;
import com.cskaoyan.service.materiaMonitor.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("material")
@Controller
public class MaterialController {
    @Autowired
    MaterialService materialService;

    //首先是响应前端返回到materialList.jsp的页面  然后就是从list.jsp获取到另外的url请求
    @RequestMapping("find")
    public String productList(HttpSession session) {
        String[] materialop = new String[]{"material:add", "material:edit", "material:delete"};
        session.setAttribute("sysPermissionList", materialop);
        return "/materialMonitor/material_list";
    }

    @ResponseBody //表示返回Json类型
    @RequestMapping("list")
    public Map datagrid132(String page, String rows) {

        Map<String, Object> map = new HashMap<>();

        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(rows);

        PageHelper.startPage(pageNum, pageSize);

        //利用materialService获取到物料的list集合
        List<Material> sysPermissionList = materialService.selectMeterials();

        //对查询的数据进行分页
        PageInfo<Material> materialPageInfo = new PageInfo<>(sysPermissionList, pageNum);
        long total = materialPageInfo.getTotal();

        map.put("rows", sysPermissionList);
        map.put("total", total);

        return map;
    }

    @RequestMapping("{add_judge,add}")
    public String appearAdd() {

        return "material_add";
    }

    @ResponseBody
    @RequestMapping("insert")
    public Map addMaterial(Material material) {

        materialService.insertMaterial(material);

        Map<String, Object> map = new HashMap<>();
        //返回的是各种状态信息的Json数据
        map.put("status", 200);
        map.put("msg", "OK");
        return map;

    }


}
