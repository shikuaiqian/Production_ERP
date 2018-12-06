package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device_maintain;
import com.cskaoyan.domain.deviceManagement.vo.Device_maintainVo;

import java.util.List;

public interface DeviceMaintainService {
    List<Device_maintainVo> tableInfo(String page, String rows);

    String tableSize();
}
