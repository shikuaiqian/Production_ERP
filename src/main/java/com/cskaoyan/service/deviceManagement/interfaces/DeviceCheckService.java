package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device_check;

import java.util.List;

public interface DeviceCheckService {
    List<Device_check> tableInfo(String page, String rows);
}
