package com.cskaoyan.service;


import com.cskaoyan.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {
    User getByUsernamePassword(String username);

    String getRoleByusername(String username);


    List<String> getPerssionByrole(String role);

    Map<String,Object> selectByPage(String page, String rows);

    Map<String,Object> selectByIdandPage(HashMap<String, String> ret, String page, String rows);

    Map<String,Object> selectBySearchValueandPage(HashMap<String, String> ret, String page, String rows);

    void insert(User user);

    void delete(String[] ids);

    void update(User user);

    User getuserById(String userId);

}
