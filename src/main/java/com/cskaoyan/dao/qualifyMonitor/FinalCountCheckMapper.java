package com.cskaoyan.dao.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.FinalCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface FinalCountCheckMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);
    List<FinalCountCheck> selectByPage(@Param("params") Map<Object,Object> map);
    int count(@Param("params") Map<Object,Object> map);
    int updateNote(@Param("id") String fCountCheckId,@Param("note") String note);

    List<FinalCountCheck> selectByPageAndSelections();
}