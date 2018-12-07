package com.cskaoyan.domain.designScheduleDomain;
import com.cskaoyan.domain.*;
public class ManufactureVo extends Manufacture {
    Order cOrder;

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    Technology technology;


    public Order getcOrder() {
        return cOrder;
    }

    public void setcOrder(Order cOrder) {
        this.cOrder = cOrder;
    }
}
