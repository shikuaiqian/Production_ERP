package com.cskaoyan.controller.technologyMonitor;

import com.cskaoyan.domain.technologyMonitor.TechnologyPlan;
import com.cskaoyan.service.technologyMonitor.TechnologyPlanService;
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
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {

    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("/find")
    public String findTechnologyJSP(HttpSession session){
        String [] s = new String[]{"technologyPlan:add","technologyPlan:edit","technologyPlan:delete"};
        session.setAttribute("sysPermissionList",s);
        return "technologyMonitor/technologyPlan_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map selectTechnology (Integer page , Integer rows){
        Map map = technologyPlanService.selectTechnologyPlanByPage(page, rows);
        return map;
    }

    /**
     * 返回可修改数据页面
     * @return
     */
    @RequestMapping("/edit")
    public String formEditPage() {
        return "technologyMonitor/technologyPlan_edit";
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
    public Map updateTechnologyPlanByID(TechnologyPlan technology){
        HashMap map = new HashMap();
        boolean b = technologyPlanService.updateTechnologyPlanById(technology);
        if (b){
            map.put("status","200");
        }else {
            map.put("msg","修改信息有误");
        }
        return map;
    }

    @RequestMapping("/add")
    public String formAddPage() {
        return "technologyMonitor/technologyPlan_add";
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge() {
        Map map = new HashMap();
        return map;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insertTechnologyPlan(TechnologyPlan technologyPlan){
        Map hashMap = new HashMap<>();
        boolean addJudge = technologyPlanService.insertTechnologyPlan(technologyPlan);
        if (addJudge){
            hashMap.put("status","200");
        }else {
            hashMap.put("msg","增加错误");
        }
        return hashMap;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map deleteTechnologyPlan(String[] ids) {
        Map hashMap = new HashMap<>();
        boolean b = technologyPlanService.deleteTechnologyPlanByID(ids);
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
    public Map searchTechnologyPlan (@PathVariable String param, String searchValue, Integer page, Integer rows){
        HashMap map = null;
        if (param.equals("search_technologyPlan_by_technologyPlanId"))
            map = technologyPlanService.searchTechnologPlanyByTechnologyPlanId(searchValue,page,rows);
        if (param.equals("search_technologyPlan_by_technologyName"))
            map = technologyPlanService.searchTechnologyPlanByTechnologyName(searchValue,page,rows);
        return map;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List selectTechnologyPlanAll(){
        List list = technologyPlanService.selectTechnologyPlanAll();
        return list;
    }
}
