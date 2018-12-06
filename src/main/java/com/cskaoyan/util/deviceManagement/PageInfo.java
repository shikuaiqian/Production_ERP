package com.cskaoyan.util.deviceManagement;

import java.util.List;

public class PageInfo<T> {
    List<T> rows;
    String total;

    public List<T> getList() {
        return rows;
    }

    public void setList(List<T> list) {
        this.rows = list;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
