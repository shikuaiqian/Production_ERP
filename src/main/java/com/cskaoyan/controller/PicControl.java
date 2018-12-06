package com.cskaoyan.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;
@Controller
@RequestMapping("pic")
public class PicControl {
    /*为实现文本传输*/


    @ResponseBody
    @RequestMapping("upload")
        public Map upload( MultipartFile uploadFile, HttpServletRequest req,String filename)
    {
        HashMap<String ,Object> map=new HashMap<>();
        String filename1 = uploadFile.getOriginalFilename();
        filename1=  UUID.randomUUID().toString()+filename1;
        String realPath = req.getRealPath("image"+filename1);
        File file1=new File(realPath);
        map.put("error",0);
        map.put("url",realPath);
        try {
            uploadFile.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();

            map.put("error",200);
            map.put("url",null);
        }
        return map;
    }

}
