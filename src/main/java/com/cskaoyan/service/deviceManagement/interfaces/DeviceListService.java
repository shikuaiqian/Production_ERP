package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device;

import java.util.List;

public interface DeviceListService {

    List<Device> tableInfo(String page, String rows);
}
