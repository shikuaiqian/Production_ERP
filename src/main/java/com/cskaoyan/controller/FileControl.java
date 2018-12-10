package com.cskaoyan.controller;

import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("file")
public class FileControl {
    @ResponseBody
    @RequestMapping("upload")
    public Map upload(MultipartFile file, HttpServletRequest req)
    {
        HashMap<String ,Object> map=new HashMap<>();

        String filename = file.getOriginalFilename();

        String realPath = req.getRealPath("/WEB-INF/files/"+filename);
        File file1=new File(realPath);
        map.put("error",0);
        map.put("url","files/"+filename);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();

            map.put("error",200);
            map.put("url",null);
        }

        return map;
    }
    @RequestMapping("download")
    public void download(String fileName, HttpServletResponse response,HttpServletRequest request) throws FileNotFoundException {
        fileName=request.getRealPath("/WEB-INF/"+fileName);
        InputStream inStream = new FileInputStream(fileName);
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @ResponseBody
    @RequestMapping("delete")
    public  Map delete(String fileName,HttpServletRequest request)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("data","success");

       String s=fileName.replace("file/download?fileName=","");
        fileName=request.getRealPath("/WEB-INF/"+s);
        try {
            File file = new File(fileName);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            map.put("data","failed");
        }
        return map;
    }
}
