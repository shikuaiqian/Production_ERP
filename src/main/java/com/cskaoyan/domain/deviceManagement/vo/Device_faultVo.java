package com.cskaoyan.domain.deviceManagement.vo;

import com.cskaoyan.domain.deviceManagement.Device_fault;

public class Device_faultVo extends Device_fault {

    private String deviceName;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }
}
