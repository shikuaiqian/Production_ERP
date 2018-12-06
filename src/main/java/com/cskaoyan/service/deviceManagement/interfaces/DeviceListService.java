package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.vo.DeviceVo;

import java.util.List;

public interface DeviceListService {

    List<DeviceVo> tableInfo(String page, String rows);

    String tableSize();
}
