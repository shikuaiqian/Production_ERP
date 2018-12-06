package com.cskaoyan.controller.technologyMonitor;

import com.cskaoyan.service.technologyMonitor.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;

    @RequestMapping("/find")
    public String findTechnologyJSP(HttpSession session){
        String [] s = new String[]{"technology_add","technology_edit","technology_delete"};
        session.setAttribute("sysPermissionList",s);
        return "technologyMonitor/technology_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map selectTechnology (Integer page , Integer rows){
        Map map = technologyService.selectTechnology(page, rows);
        return map;
    }
}
