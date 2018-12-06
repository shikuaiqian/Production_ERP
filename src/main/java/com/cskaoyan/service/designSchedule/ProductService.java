package com.cskaoyan.service;

import com.cskaoyan.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Map<String,Object> selectByPage(Integer page, Integer rows);

    Map<String,Object> selectByIdandPage(Integer searchValue, Integer page, Integer rows);

    void insert(Product product);

    void delete(Integer[] ids);

    void update(Product product);

    List<Product> findAll();
}