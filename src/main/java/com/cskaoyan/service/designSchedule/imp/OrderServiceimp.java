package com.cskaoyan.service.designSchedule.imp;

import com.cskaoyan.domain.designScheduleDomain.Order;
import com.cskaoyan.dao.designSchedule.OrderMapper;
import com.cskaoyan.domain.designScheduleDomain.OrderVo;
import com.cskaoyan.service.designSchedule.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceimp  implements OrderService{
    @Autowired
    OrderMapper orderMapper;
    @Override
    public Map<String, Object> selectByPage(String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<OrderVo> orders = orderMapper.selectByPage(offset, rows, null);
        int count = orderMapper.count(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",orders);
        return map;
    }

    @Override
    public Map<String, Object> selectBySearchValue(Map searchValue, String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<OrderVo> orders = orderMapper.selectByPage(offset, rows, searchValue);
        int count = orderMapper.count(searchValue);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",orders);
        return map;
    }

    @Override
    public void insert(Order Order) {
        orderMapper.insertSelective(Order);
    }

    @Override
    public void delete(String[] ids) {
        for (int i = 0; i <ids.length ; i++) {
            orderMapper.deleteByPrimaryKey(ids[i]+"") ;
        }
    }

    @Override
    public void update(Order Order) {
        orderMapper.updateByPrimaryKey(Order);
    }

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
