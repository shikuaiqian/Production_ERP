package com.cskaoyan.dao.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Custom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper {
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    List<Custom>  findall();
    int count(@Param("searchid") Integer searchid);
    List<Custom> selectByPage(Integer page, Integer rows, Integer i);
}