package com.cskaoyan.controller.designSchedule;

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
        filename=  UUID.randomUUID().toString()+filename;
        String realPath = req.getRealPath("files"+filename);
        File file1=new File(realPath);
        map.put("error",0);
        map.put("url",realPath);
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
    public void download(String fileName, HttpServletResponse response) throws FileNotFoundException {

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
}
