package com.cskaoyan.dao.deviceManagement;

import com.cskaoyan.domain.deviceManagement.Device_maintain;
import com.cskaoyan.domain.deviceManagement.vo.Device_maintainVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Device_maintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(Device_maintain record);

    int insertSelective(Device_maintain record);

    Device_maintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(Device_maintain record);

    int updateByPrimaryKey(Device_maintain record);

    String selectTableAmount();

    List<Device_maintainVo> selectByLimitOffset(@Param("limit") int limit, @Param("offset") int offset);
}