package com.cskaoyan.controller.designSchedule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
@Controller
public class FormController {


    @RequestMapping(value={"{formName}"})
    public String loginForm(@PathVariable String formName    ){
        // 动态跳转页面
        return formName;
    }

=======
/**
 * Created by LZH on 2018/12/5
 */
@Controller
public class FormController {

    @RequestMapping(value="/{formName}")
    public String loginForm(@PathVariable String formName){
        // 动态跳转页面
        return formName;
    }
>>>>>>> 00806c42565337faab4874c83cdcd2200002105c
}
