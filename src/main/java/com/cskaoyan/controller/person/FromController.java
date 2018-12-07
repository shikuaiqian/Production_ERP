package com.cskaoyan.controller.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class FromController {
    @RequestMapping(value="/{formName}")//先跳转到这
    public String loginForm(@PathVariable String formName, HttpSession session){
        // 动态跳转页面
        return formName;
    }
}
