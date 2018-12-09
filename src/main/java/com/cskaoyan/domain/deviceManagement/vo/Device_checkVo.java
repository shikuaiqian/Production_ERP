package com.cskaoyan.domain.deviceManagement.vo;

import com.cskaoyan.domain.deviceManagement.Device_check;

public class Device_checkVo extends Device_check {
    private String deviceName;

    //例检人
    private String deviceCheckEmp;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDeviceCheckEmp() {
        return deviceCheckEmp;
    }

    public void setDeviceCheckEmp(String deviceCheckEmp) {
        this.deviceCheckEmp = deviceCheckEmp == null ? null : deviceCheckEmp.trim();
    }
}
