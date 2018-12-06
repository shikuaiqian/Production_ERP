package com.cskaoyan.controller.designSchedule;

import com.cskaoyan.domain.Product;
import com.cskaoyan.service.designSchedule.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("find")
    public String  find(HttpSession session){
        String[]  producterop=new String[]{"product:add","product:edit","product:delete"};
        session.setAttribute("sysPermissionList",producterop);
        return   "/desginSchedule/product_list";
    }

    @ResponseBody
    @RequestMapping("list")
    public Map list(Integer page , Integer rows)
    {
        Map<String ,Object> producters=productService.selectByPage(page,rows);
        return producters;
    }
    @ResponseBody
    @RequestMapping("search_product_by_productId")
    public Map search_product_by_productId(Integer searchValue,Integer page ,Integer rows)
    {
        Map<String ,Object> producters=productService.selectByIdandPage(searchValue,page,rows);
        return producters;
    }
    @ResponseBody
    @RequestMapping("add_judge")
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "/desginSchedule/product_add";
    }
    @ResponseBody
    @RequestMapping("insert")
    public Map insert(Product product){
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try {
            productService.insert(product);
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
    public Map delete(Integer[] ids)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try{
            productService.delete(ids);
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
        return "/desginSchedule/product_edit";
    }
    @ResponseBody
    @RequestMapping("update_all")
    public Map updateAll(Product product)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try{
            productService.update(product);
        }catch (Exception e)
        {
            e.printStackTrace();

            map.put("msg","修改失败请重试");
            map.put("status",0);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("get_data")
    public List<Product> getData()
    {
        List<Product> products= productService.findAll();
        return products;
    }
}
