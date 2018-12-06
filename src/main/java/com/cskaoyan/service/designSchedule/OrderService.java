package com.cskaoyan.service.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Order;

import java.util.Map;

public interface OrderService {
    Map<String,Object> selectByPage(Integer page, Integer rows);

    Map<String,Object> selectByIdandPage(Integer searchValue, Integer page, Integer rows);

    void insert(Order order);

    void delete(Integer[] ids);

    void update(Order order);
}
