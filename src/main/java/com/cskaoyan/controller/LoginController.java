package com.cskaoyan.controller;

import com.cskaoyan.domain.User;
import com.cskaoyan.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import  java.util.*;
@Controller
public class LoginController {

    @Autowired
    UserService userService;
@Autowired
SecurityManager securityManager;
    @ResponseBody
    @RequestMapping("ajaxLogin")
    public Map login(User user, HttpSession session,String randomcode){
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        HashMap<String ,String > ret=new HashMap<>();
       if(randomcode!=null) {
           String validateCode = (String) session.getAttribute("validateCode");
           if (validateCode.equals(randomcode)) {
               ret.put("msg", "randomcode_error");
               return ret;
           }
       }try {
            subject.login(token);
            SimplePrincipalCollection attribute = (SimplePrincipalCollection) session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY");
            User primaryPrincipal = (User) attribute.getPrimaryPrincipal();
            System.out.println("user = " + primaryPrincipal);
            session.setAttribute("activeUser",primaryPrincipal);

        } catch (AuthenticationException e) {
            e.printStackTrace();
            ret.put("msg","authentication_error");

        }
        return ret;
    }
}
