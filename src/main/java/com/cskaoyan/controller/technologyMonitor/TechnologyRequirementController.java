package com.cskaoyan.controller.technologyMonitor;

import com.cskaoyan.domain.technologyMonitor.TechnologyRequirement;
import com.cskaoyan.service.technologyMonitor.TechnologyRequirementService;
import com.cskaoyan.service.technologyMonitor.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementService technologyRequirementService;

    @RequestMapping("/find")
    public String findTechnologyRequirementJSP(HttpSession session){
        String [] s = new String[]{"technologyRequirement:add","technologyRequirement:edit","technologyRequirement:delete"};
        session.setAttribute("sysPermissionList",s);
        return "technologyMonitor/technologyRequirement_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map selectTechnologyRequirement (Integer page , Integer rows){
        Map map = technologyRequirementService.selectTechnologyRequirementByPage(page, rows);
        return map;
    }

    /**
     * 返回可修改数据页面
     * @return
     */
    @RequestMapping("/edit")
    public String formEditPage() {
        return "technologyMonitor/technologyRequirement_edit";
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
    public Map updateTechnologyByID(TechnologyRequirement technologyRequirement){
        HashMap map = new HashMap();
        boolean b = technologyRequirementService.updateTechnologyRequirementById(technologyRequirement);
        if (b){
            map.put("status","200");
        }else {
            map.put("msg","修改信息有误");
        }
        return map;
    }

    @RequestMapping("/add")
    public String formAddPage() {
        return "technologyMonitor/technologyRequirement_add";
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge() {
        Map map = new HashMap();
        return map;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insertTechnology(TechnologyRequirement technologyRequirement){
        Map hashMap = new HashMap<>();
        boolean addJudge = technologyRequirementService.insertTechnology(technologyRequirement);
        if (addJudge){
            hashMap.put("status","200");
        }else {
            hashMap.put("msg","增加错误");
        }
        return hashMap;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteTechnology(String[] ids) {
        Map hashMap = new HashMap<>();
        boolean b = technologyRequirementService.deleteTechnologyByID(ids);
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
    public Map searchTechnology (@PathVariable String param, String searchValue, Integer page, Integer rows){
        HashMap map = null;
        if (param.equals("search_technologyRequirement_by_technologyRequirementId"))
            map = technologyRequirementService.searchTechnologyRequirementById(searchValue,page,rows);
        if (param.equals("search_technologyRequirement_by_technologyName"))
            map = technologyRequirementService.searchTechnologyRequirementByName(searchValue,page,rows);
        return map;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List selectTechnologyAll(){
        List list = technologyRequirementService.selectTechnologyAll();
        return list;
    }

    @RequestMapping("/update_requirement")
    @ResponseBody
    public Map updateRequirement(String technologyRequirementId,String requirement) {
        Map hashMap = new HashMap<>();
        boolean b = technologyRequirementService.updateRequirement(technologyRequirementId,requirement);
        if (b){
            hashMap.put("status","200");
        }else {
            hashMap.put("msg","更新要求异常");
        }
        return hashMap;
    }
}
