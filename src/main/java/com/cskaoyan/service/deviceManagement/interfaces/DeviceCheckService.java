package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device_check;
import com.cskaoyan.domain.deviceManagement.vo.Device_checkVo;

import java.util.List;

public interface DeviceCheckService {
    List<Device_checkVo> tableInfo(String page, String rows);

    String tableSize();
}
