package com.cskaoyan.service.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Map<String,Object> selectByPage(String page, String rows);

    Map<String,Object> selectBysearchValue(Map searchValue, String page, String rows);

    void insert(Product product);

    void delete(String[] ids);

    void update(Product product);

    List<Product> findAll();
}
