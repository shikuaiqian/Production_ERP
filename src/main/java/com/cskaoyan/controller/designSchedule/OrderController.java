package com.cskaoyan.controller.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Order;
import com.cskaoyan.service.designSchedule.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping("find")
    public String  find(HttpSession session){
        String[]  Orderop=new String[]{"order:add","order:edit","order:delete"};
        session.setAttribute("sysPermissionList",Orderop);
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
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "/designSchedule/order/order_add";
    }
    @ResponseBody
    @RequestMapping("insert")
    public Map insert( @Valid Order order){
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
    public Map updateAll(@Valid Order Order)
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
}