package com.cskaoyan.domain.deviceManagement.vo;

import com.cskaoyan.domain.deviceManagement.Device_maintain;

public class Device_maintainVo extends Device_maintain {
    //维修人
    private String deviceMaintainEmp;

    public String getDeviceMaintainEmp() {
        return deviceMaintainEmp;
    }

    public void setDeviceMaintainEmp(String deviceMaintainEmp) {
        this.deviceMaintainEmp = deviceMaintainEmp;
    }
}
