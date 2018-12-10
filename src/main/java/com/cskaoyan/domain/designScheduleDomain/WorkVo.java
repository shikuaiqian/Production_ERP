package com.cskaoyan.domain.designScheduleDomain;

import com.cskaoyan.domain.deviceManagement.Device;
import com.cskaoyan.domain.technologyMonitor.Process;

public class WorkVo  extends Work {
    Product product;
    Device device;
        Process  process;
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
}
