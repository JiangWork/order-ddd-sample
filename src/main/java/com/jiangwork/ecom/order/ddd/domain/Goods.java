package com.jiangwork.ecom.order.ddd.domain;

import com.jiangwork.ecom.order.ddd.ValueObject;

/**
 * Created by jiangzhao on 2020-10-25 17:30.
 */
public class Goods implements ValueObject {
    private Long id;
    private String name;
    private String desc;
    private Long price;

    public Goods() {

    }

    public Goods(Long id, String name, String desc, Long price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Long getPrice() {
        return price;
    }
}
