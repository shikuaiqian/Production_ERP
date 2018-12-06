package com.cskaoyan.service.deviceManagement.interfaces;

import com.cskaoyan.domain.deviceManagement.Device_fault;


import java.util.List;

public interface DeviceFaultService {
    List<Device_fault> tableInfo(String page, String rows);

}
