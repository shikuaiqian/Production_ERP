package com.cskaoyan.controller.materiaMonitor;


import com.cskaoyan.domain.materialMonitor.Material;
import com.cskaoyan.service.materiaMonitor.MaterialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MaterialController {

    @Autowired
    MaterialService materialService;

    //首先是响应前端返回到materialList.jsp的页面  然后就是从list.jsp获取到另外的url请求
    @RequestMapping("/material/find")
    public ModelAndView productList() {
        ModelAndView modelAndView = new ModelAndView();
        //在最后的检验url的时候可以根据 视图解析器 去做改变
        modelAndView.setViewName("material_list");
        return modelAndView;
    }




}
