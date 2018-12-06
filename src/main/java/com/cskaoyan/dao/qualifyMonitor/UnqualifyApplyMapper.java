package com.cskaoyan.dao.qualifyMonitor;

import com.cskaoyan.domain.qualifyMonitor.UnqualifyApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UnqualifyApplyMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);
    List<UnqualifyApply> selectByPage(@Param("params") Map<Object,Object> map);
    int count();
}