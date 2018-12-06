package com.cskaoyan.service.designSchedule.imp;



import com.cskaoyan.dao.designSchedule.ProductMapper;
import com.cskaoyan.domain.designScheduleDomain.Product;

import com.cskaoyan.service.designSchedule.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceimp implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public Map<String, Object> selectByPage(Integer page, Integer rows) {
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<Product> products = productMapper.selectByPage(offset, rows,null);
        int count = productMapper.count(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",products);
        return map;
    }

    @Override
    public Map<String, Object> selectByIdandPage(Integer searchValue, Integer page, Integer rows) {
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<Product> products = productMapper.selectByPage(offset,rows,searchValue);
        int count = productMapper.count(searchValue);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",products);
        return map;
    }

    @Override
    public void insert(Product product) {
        productMapper.insertSelective(product);
    }

    @Override
    public void delete(Integer[] ids) {
        for (int i = 0; i <ids.length ; i++) {
            productMapper.deleteByPrimaryKey(ids[i]+"") ;
        }
    }

    @Override
    public void update(Product product) {
        productMapper.updateByPrimaryKey(product);
    }

    @Override
    public List<Product> findAll() {
        return productMapper.findall();
    }
}
