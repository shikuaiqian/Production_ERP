package com.cskaoyan.controller.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Product;
import com.cskaoyan.service.designSchedule.ProductService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    SecurityManager securityManager;
    @RequestMapping("find")
    public String  find(HttpSession session){
        String[]  producterop=new String[]{"product:add","product:edit","product:delete"};

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        ArrayList<String> perssions = new ArrayList<>();
        boolean[] permitted = subject.isPermitted(producterop);
        for (int i = 0; i <permitted.length ; i++) {
            if(permitted[i]==true)
            {
                perssions.add(producterop[i]);
            }
        }
        session.setAttribute("sysPermissionList",perssions);
        return   "/designSchedule/product/product_list";
    }

    @ResponseBody
    @RequestMapping("list")
    public Map list(String page , String rows)
    {
        Map<String ,Object> producters=productService.selectByPage(page,rows);
        return producters;
    }
    @ResponseBody
    @RequestMapping("search_product_by_productId")
    public Map search_product_by_productId(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("productId",searchValue);
        Map<String ,Object> producters=productService.selectBysearchValue(ret,page,rows);
        return producters;
    }

    @ResponseBody
    @RequestMapping("search_product_by_productName")
    public Map search_product_by_productName(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("productName",searchValue);
        Map<String ,Object> producters=productService.selectBysearchValue(ret,page,rows);
        return producters;
    }
    @ResponseBody
    @RequestMapping("search_product_by_productType")
    public Map search_product_by_productType(String searchValue,String page ,String rows)
    {
        HashMap<String,String> ret=new HashMap<>();
        ret.put("productType",searchValue);
        Map<String ,Object> producters=productService.selectBysearchValue(ret,page,rows);
        return producters;
    }
    @ResponseBody
    @RequestMapping("add_judge")
    @RequiresPermissions(value="product:add",logical = Logical.AND)
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "/designSchedule/product/product_add";
    }
    @ResponseBody
    @RequestMapping("insert")
    public Map insert( Product product,BindingResult bindingResult){

        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        if(bindingResult.hasFieldErrors()) {
            map.put("msg","必选项不允许空");
            map.put("status",0);
        }
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
    @RequiresPermissions(value="product:delete",logical = Logical.AND)
    public  String deleteJudge (){
        return null;
    }
    @ResponseBody
    @RequestMapping("delete_batch")
    public Map delete(String[] ids)
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
    @RequiresPermissions(value="product:edit",logical = Logical.AND)
    public  String editJudge (){
        return null;
    }
    @RequestMapping("edit")
    public String edit()
    {
        return "/designSchedule/product/product_edit";
    }
    @ResponseBody
    @RequestMapping("update_all")
    @RequiresPermissions(value="product:edit",logical = Logical.AND)
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

    @ResponseBody
    @RequestMapping("/get/{productId}")
    public Product getCustomById(@PathVariable String productId){
        return  productService.getProductById(productId);
    }

    @ResponseBody
    @RequestMapping("update_note")
    @RequiresPermissions(value="product:edit",logical = Logical.AND)
    public Map updateNote(String productId,String note)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try {
            productService.updateNote(productId,note);
        }catch (Exception e)
        {
            e.printStackTrace();

            map.put("msg","修改失败请重试");
            map.put("status",0);
        }
        return map;
    }

}
