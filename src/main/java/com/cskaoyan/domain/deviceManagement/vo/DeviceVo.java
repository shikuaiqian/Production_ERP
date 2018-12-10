package com.cskaoyan.domain.deviceManagement.vo;


import com.cskaoyan.domain.deviceManagement.Device;

public class DeviceVo extends Device {
    private String deviceTypeName;

    private String deviceKeeper;

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName == null ? null : deviceTypeName.trim();
    }
    public String getDeviceKeeper() {
        return deviceKeeper;
    }

    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeper = deviceKeeper == null ? null : deviceKeeper.trim();
    }

    @Override
    public String toString() {
        return "DeviceVo{" +
                "deviceTypeName='" + deviceTypeName + '\'' +
                ", deviceKeeper='" + deviceKeeper + '\'' +
                '}';
    }
}
