package com.cskaoyan.service.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<String,Object> selectByPage(String page, String rows);

    Map<String,Object> selectBySearchValue(Map searchValue, String page, String rows);

    void insert(Order order);

    void delete(String[] ids);

    void update(Order order);

    List<Order> findAll();
}
