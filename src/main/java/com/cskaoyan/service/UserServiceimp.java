package com.cskaoyan.service;

import com.cskaoyan.dao.UserMapper;
import com.cskaoyan.domain.User;
import com.cskaoyan.domain.UserSeesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service

public class UserServiceimp implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getByUsernamePassword(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public String getRoleByusername(String username) {
        return  userMapper.getRoleByusername(username);
    }

    @Override
    public List<String> getPerssionByrole(String role) {
       String perssionids= userMapper.getPerssionByrole(role);
        if(perssionids==null)
        {
            return null;
        }
        String[] split = perssionids.split(",");
        ArrayList<String> permissions = new ArrayList<>();
        for (String s: split) {
            String permission=userMapper.getPerssionByid(s);
            permissions.add(permission);
        }
        return permissions;
    }


    @Override
    public Map<String, Object> selectByPage(String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<User> users = userMapper.selectByPage(offset, rows,null);
        int count = userMapper.count(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",users);
        return map;
    }

    @Override
    public Map<String, Object> selectByIdandPage(HashMap<String, String>  searchValue, String page1, String rows1) {
        Map<String, Object> stringObjectMap = selectBySearchValueandPage(searchValue, page1, rows1);
        return stringObjectMap;
    }

    @Override
    @Transactional
    public void insert(User user) {
        userMapper.insertSelective(user);
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        userMapper.insertSUR(s,(UserSeesion)user);
    }

    @Override
    public void delete(String[] ids) {
        for (int i = 0; i <ids.length ; i++) {
            userMapper.deleteByPrimaryKey(ids[i]+"") ;
            userMapper.deleteSURByUserId(ids[i]);
        }
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }


    @Override
    public Map<String, Object> selectBySearchValueandPage(HashMap<String, String> ret, String page1, String rows1) {
        int page = Integer.parseInt(page1);
        int rows = Integer.parseInt(rows1);
        int i = (page - 1) * rows;
        int offset=i>0?i:0;
        List<User> users = userMapper.selectByPage(offset,rows,ret);
        int count = userMapper.count(ret);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total" ,count);
        map.put("rows",users);
        return map;
    }

    @Override
    public User getuserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }


}
