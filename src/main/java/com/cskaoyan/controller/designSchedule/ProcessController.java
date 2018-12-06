package com.cskaoyan.controller.designSchedule;

import com.cskaoyan.service.designSchedule.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("process")
public class ProcessController {
    @Autowired
    ProcessService processService;
    @ResponseBody
    @RequestMapping("get_data")
    public List<Process> getData()
    {
        List<Process> processes= processService.findAll();
        return processes;
    }
}
