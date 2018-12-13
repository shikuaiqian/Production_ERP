package com.cskaoyan.dao;

import com.cskaoyan.domain.User;
import com.cskaoyan.domain.UserSeesion;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getByUsername(String username);

    String getRoleByusername(String username);

    String getPerssionByrole(String role);

    String getPerssionByid(String s);

    List<User> selectByPage(int offset, int rows, Map o);

    int count(@Param("param3") Map o);

    int insertSUR(@Param("uuid") String uuid,@Param("user") UserSeesion user);

    int deleteSURByUserId(String id);
}