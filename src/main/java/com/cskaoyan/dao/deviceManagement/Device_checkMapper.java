package com.cskaoyan.dao.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device_check;
import com.cskaoyan.domain.deviceManagement.vo.Device_checkVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Device_checkMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(Device_check record);

    int insertSelective(Device_check record);

    Device_check selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(Device_check record);

    int updateByPrimaryKey(Device_check record);

    String selectTableAmount();

    List<Device_checkVo> selectByLimitOffset(@Param("limit") int limit, @Param("offset") int offset);
}