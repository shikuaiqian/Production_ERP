package com.cskaoyan.controller.technologyMonitor;

import com.cskaoyan.domain.technologyMonitor.PageVO;
import com.cskaoyan.domain.technologyMonitor.Technology;
import com.cskaoyan.service.technologyMonitor.TechnologyService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;

    @Autowired
    SecurityManager securityManager;
    @RequestMapping("/find")
    public String findTechnologyJSP(HttpSession session){
        String [] s = new String[]{"technology:add","technology:edit","technology:delete"};
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
        return "technologyMonitor/technology_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map selectTechnology (PageVO pageVo ){

        Map map = technologyService.selectTechnologyByPage(pageVo.getPage(),pageVo.getRows());
        return map;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List selectTechnologyAll(){
        List list = technologyService.selectTechnologyAll();
        return list;
    }

    /**
     * 返回可修改数据页面
     * @return
     */
    @RequestMapping("/edit")
    public String formEditPage() {
        return "technologyMonitor/technology_edit";
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
    public Map updateTechnologyByID(Technology technology){
        HashMap map = new HashMap();
        boolean b = technologyService.updateTechnologyById(technology);
        if (b){
            map.put("status","200");
        }else {
            map.put("msg","修改信息有误");
        }
        return map;
    }

    @RequestMapping("/add")
    public String formAddPage() {
        return "technologyMonitor/technology_add";
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addJudge() {
        Map map = new HashMap();
        return map;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insertTechnology(Technology technology){
        Map hashMap = new HashMap<>();
        boolean addJudge = technologyService.insertTechnology(technology);
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
        boolean b = technologyService.deleteTechnologyByID(ids);
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
    public Map searchTechnology (@PathVariable String param,String searchValue,Integer page,Integer rows){
        HashMap map = null;
        if (param.equals("search_technology_by_technologyId"))
            map = technologyService.searchTechnologyByTechnologyId(searchValue,page,rows);
        if (param.equals("search_technology_by_technologyName"))
            map = technologyService.searchTechnologyByTechnologyName(searchValue,page,rows);
        return map;
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Technology getTechnologyById(@PathVariable String id){
        Technology technology = technologyService.selectTechnologyByTechnologyId(id);
        return technology;
    }
}
