package com.cskaoyan.controller.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Custom;
import com.cskaoyan.domain.designScheduleDomain.Order;
import com.cskaoyan.service.designSchedule.OrderService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
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
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    SecurityManager securityManager;
    @RequestMapping("find")
    public String  find(HttpSession session){
        String[]  orderop=new String[]{"order:add","order:edit","order:delete"};
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        ArrayList<String> perssions = new ArrayList<>();
        boolean[] permitted = subject.isPermitted(orderop);
        for (int i = 0; i <permitted.length ; i++) {
            if(permitted[i]==true)
            {
                perssions.add(orderop[i]);
            }
        }
        session.setAttribute("sysPermissionList",perssions);
        return   "/designSchedule/order/order_list";
    }

    @ResponseBody
    @RequestMapping("list")
    public Map  list(String page ,String rows)
    {
        Map<String ,Object> orders=orderService.selectByPage(page,rows);
        return orders;
    }
    @ResponseBody
    @RequestMapping("search_order_by_orderId")
    public Map search_Order_by_OrderId(String searchValue,String page ,String rows)
    {
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("orderId",searchValue);
        Map<String ,Object> Orders=orderService.selectBySearchValue(ret,page,rows);
        return Orders;
    }
    @ResponseBody
    @RequestMapping("search_order_by_orderCustom")
    public Map search_Order_by_CustomName(String searchValue,String page ,String rows)
    {
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("customName",searchValue);
        Map<String ,Object> Orders=orderService.selectBySearchValue(ret,page,rows);
        return Orders;
    }
    @ResponseBody
    @RequestMapping("search_order_by_orderProduct")
    public Map search_Order_by_OrderProduct(String searchValue,String page ,String rows)
    {
        HashMap<String,Object> ret=new HashMap<>();
        ret.put("productName",searchValue);
        Map<String ,Object> Orders=orderService.selectBySearchValue(ret,page,rows);
        return Orders;
    }
    @ResponseBody
    @RequestMapping("add_judge")
    @RequiresPermissions(value="order:add",logical = Logical.AND)
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    @RequiresPermissions(value="order:add",logical = Logical.AND)
    public String add(){
        return "/designSchedule/order/order_add";
    }
    @ResponseBody
    @RequestMapping("insert")
    public Map insert(  Order order){
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try {
            orderService.insert(order);
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
    @RequiresPermissions(value="order:delete",logical = Logical.AND)
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
            orderService.delete(ids);
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
    @RequiresPermissions(value="order:edit",logical = Logical.AND)
    public  String editJudge (){
        return null;
    }
    @RequestMapping("edit")
    public String edit()
    {
        return "/designSchedule/order/order_edit";
    }
    @ResponseBody
    @RequestMapping("update_all")
    @RequiresPermissions(value="order:edit",logical = Logical.AND)
    public Map updateAll( Order Order)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try{
            orderService.update(Order);
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
    public List<Order> getData()
    {
        List<Order> orders= orderService.findAll();
        return orders;
    }
    @ResponseBody
    @RequestMapping("/get/{orderId}")
    public Order getCustomById(@PathVariable String orderId){
        return  orderService.getOrderById(orderId);
    }
    @ResponseBody
    @RequestMapping("update_note")

    public Map updateNote(String orderId,String note)
    {
        HashMap<String ,Object> map=new HashMap<>();
        map.put("msg","ok");
        map.put("status",200);
        try {
            orderService.updateNote(orderId,note);
        }catch (Exception e)
        {
            e.printStackTrace();

            map.put("msg","修改失败请重试");
            map.put("status",0);
        }
        return map;
    }


}