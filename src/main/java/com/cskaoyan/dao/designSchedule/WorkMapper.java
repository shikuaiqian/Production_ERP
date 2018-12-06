package com.cskaoyan.dao.designSchedule;

import com.cskaoyan.domain.designScheduleDomain.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    int count(@Param("searchid") Object o);

    List<Work> selectByPage(int offset, Integer rows, Object o);
}