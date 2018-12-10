package com.cskaoyan.dao.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Custom;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface CustomMapper {
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    List<Custom>  findall();
    int count(@Param("search") Map searchvalue);
    List<Custom> selectByPage(@Param("param1") Integer page,@Param("param2") Integer rows,
                              @Param("param3") Map searchvalue);
}