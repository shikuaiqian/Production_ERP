package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device_maintain;

import java.util.List;

public interface DeviceMaintainService {
    List<Device_maintain> tableInfo(String page, String rows);

}
