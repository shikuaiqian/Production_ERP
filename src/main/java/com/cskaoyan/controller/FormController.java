package com.cskaoyan.controller;

import com.cskaoyan.domain.User;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class FormController {
    @RequestMapping(value="/{formName}")
    public String loginForm(@PathVariable String formName,  HttpSession session) throws IOException {
        // 动态跳转页面


        return formName;
    }

}
