package com.cskaoyan.domain.deviceManagement.vo;

public class ChangeResult {
    private String status;
    private String msg;
    private String data;

    public ChangeResult() {
    }

    public ChangeResult(String status, String msg, String data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
