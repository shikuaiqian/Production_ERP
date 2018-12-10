package com.cskaoyan.domain.designScheduleDomain;

public class OrderVo extends Order {
        Custom custom;
        Product product;

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
