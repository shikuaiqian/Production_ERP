package com.cskaoyan.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
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
        int length = filename1.length();
        String substring = filename1.substring(length - 4, length);
        String s = UUID.randomUUID().toString()+substring;
        String realPath = req.getRealPath("/WEB-INF/pic/"+s);
        File file1=new File(realPath);
        map.put("error",0);
        map.put("url","pic/"+s);
        try {
            uploadFile.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();

            map.put("error",200);
            map.put("url",null);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("delete")
    public  Map delete(String picName,HttpServletRequest request)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("data","success");
        picName=request.getRealPath("/WEB-INF/"+picName);
        try {
            File file = new File(picName);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            map.put("data","failed");
        }
        return map;
    }

}
