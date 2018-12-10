package com.cskaoyan.controller.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Manufacture;
import com.cskaoyan.service.designSchedule.ManufactureService;
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
@RequestMapping("manufacture")
public class ManufactureController {
  @Autowired
    ManufactureService manufactureService;
    @RequestMapping("find")
    public String  find(HttpSession session){
        String[]  manufactureop=new String[]{"manufacture:add","manufacture:edit","manufacture:delete"};
        session.setAttribute("sysPermissionList",manufactureop);
        return   "/designSchedule/product_plan/manufacture_list";
    }

    @ResponseBody
    @RequestMapping("list")
    public Map list(String page , String rows)
    {
        Map<String ,Object> manufactures=manufactureService.selectByPage(page,rows);
        return manufactures;
    }

    @ResponseBody
    @RequestMapping("search_manufacture_by_manufactureOrderId")
    public Map search_manufacture_by_manufactureOrderId(String searchValue,String page ,String rows)
    {
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("orderId",searchValue);
        Map<String ,Object> manufactures=manufactureService.selectBySearchValue(ret,page,rows);
        return manufactures;
    }
    @ResponseBody
    @RequestMapping("search_manufacture_by_manufactureSn")
    public Map search_manufacture_by_manufactureSn(String searchValue,String page ,String rows)
    {
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("manufactureSn",searchValue);
        Map<String ,Object> manufactures=manufactureService.selectBySearchValue(ret,page,rows);
        return manufactures;
    }
    @ResponseBody
    @RequestMapping("search_manufacture_by_manufactureTechnologyName")
    public Map searchmManufactureByManufactureOrderId(String searchValue,String page ,String rows)
    {
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("technologyName",searchValue);
        Map<String ,Object> manufactures=manufactureService.selectBySearchValue(ret,page,rows);
        return manufactures;
    }
    @ResponseBody
    @RequestMapping("add_judge")
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "/designSchedule/product_plan/manufacture_add";
    }
    @ResponseBody
    @RequestMapping("insert")
    public Map insert(  Manufacture manufacture){
        HashMap<String, Object> map = getStringObjectHashMap();
        try {
            manufactureService.insert(manufacture);
        }catch (Exception e)
        {
            e.printStackTrace();
            map.put("msg","该客户编号已经存在，请更换客户编号！");
            map.put("status",0);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("delete_judge")
    public  String deleteJudge (){
        return null;
    }
    @ResponseBody
    @RequestMapping("delete_batch")
    public Map delete(String[] ids)
    {
        HashMap<String, Object> map = getStringObjectHashMap();
        try{
            manufactureService.delete(ids);
        }catch (Exception e)
        {
            e.printStackTrace();

            map.put("msg","删除失败请重试");
            map.put("status",0);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("edit_judge")
    public  String editJudge (){
        return null;
    }
    @RequestMapping("edit")
    public String edit()
    {
        return "/designSchedule/product_plan/manufacture_edit";
    }
    @ResponseBody
    @RequestMapping("update_all")
    public Map updateAll( Manufacture manufacture)
    {
        HashMap<String, Object> map = getStringObjectHashMap();
        try{
            manufactureService.update(manufacture);
        }catch (Exception e)
        {
            e.printStackTrace();

            map.put("msg","修改失败请重试");
            map.put("status",0);
        }
        return map;
    }

    private HashMap<String, Object> getStringObjectHashMap() {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        return map;
    }
    @ResponseBody
    @RequestMapping("get_data")
    public List<Manufacture> getData()
    {
        List<Manufacture> manufactures= manufactureService.findAll();
        return manufactures;
    }
    @ResponseBody
    @RequestMapping("/get/{ManufactureId}")
    public Manufacture getCustomById(@PathVariable String ManufactureId){
        return  manufactureService.getManufactureById(ManufactureId);
    }
}
