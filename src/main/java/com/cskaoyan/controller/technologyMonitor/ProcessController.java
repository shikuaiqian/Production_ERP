package com.cskaoyan.controller.technologyMonitor;

import com.cskaoyan.domain.technologyMonitor.Process;
import com.cskaoyan.domain.technologyMonitor.Technology;
import com.cskaoyan.service.technologyMonitor.ProcessService;
import com.cskaoyan.service.technologyMonitor.TechnologyService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @Autowired
    SecurityManager securityManager;
    @RequestMapping("/find")
    public String findTechnologyJSP(HttpSession session){
        String [] s = new String[]{"process:add","process:edit","process:delete"};
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        ArrayList<String> perssions = new ArrayList<>();
        boolean[] permitted = subject.isPermitted(s);
        for (int i = 0; i <permitted.length ; i++) {
            if(permitted[i]==true)
            {
                perssions.add(s[i]);
            }
        }
        session.setAttribute("sysPermissionList",perssions);
        return "technologyMonitor/process_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map selectProcess (Integer page , Integer rows){
        Map map = processService.selectProcessByPage(page, rows);
        return map;
    }

    /**
     * 返回可修改数据页面
     * @return
     */
    @RequestMapping("/edit")
    public String formEditPage() {
        return "technologyMonitor/process_edit";
    }

    /**
     * 返回修改权限，如果禁止修改，map.put("msg","错误提示信息")
     * @return
     */
    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editJudge() {
        Map map = new HashMap();
        return map;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public Map updateProcessByID(Process process){
        HashMap map = new HashMap();
        boolean b = processService.updateProcessById(process);
        if (b){
            map.put("status","200");
        }else {
            map.put("msg","修改信息有误");
        }
        return map;
    }

    @RequestMapping("/add")
    public String formAddPage() {
        return "technologyMonitor/process_add";
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge() {
        Map map = new HashMap();
        return map;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insertTechnology(Process process){
        Map hashMap = new HashMap<>();
        boolean addJudge = processService.insertProcess(process);
        if (addJudge){
            hashMap.put("status","200");
        }else {
            hashMap.put("msg","增加错误");
        }
        return hashMap;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteProcess(String[] ids) {
        Map hashMap = new HashMap<>();
        boolean b = processService.deleteProcessByIds(ids);
        if (b){
            hashMap.put("status","200");
        }else {
            hashMap.put("msg","删除失败");
        }
        return hashMap;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map deleteJudge() {
        Map map = new HashMap();
        return map;
    }

    @RequestMapping("/{param}")
    @ResponseBody
    public Map searchProcess (@PathVariable String param, String searchValue, Integer page, Integer rows){
        HashMap map = null;
        if (param.equals("search_process_by_processId"))
            map = processService.searchProcessByProcessId(searchValue,page,rows);
        if (param.equals("search_process_by_technologyPlanId"))
            map = processService.searchProcessByTechnologyPlanId(searchValue,page,rows);
        return map;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List selectProcessAll(){
        List list = processService.selectProcessAll();
        return list;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Process getProcessById(@PathVariable String id){
        Process process = processService.selectProcessByProcessId(id);
        return process;
    }
}
