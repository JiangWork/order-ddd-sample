package com.jiangwork.ecom.order.types;

import java.util.stream.Stream;

/**
 * Created by jiangzhao on 2020-10-25 15:50.
 */ // the order orderStatus
public enum OrderStatus {
    NEW(1),
    PAID(2),
    SHIPPED(3),
    DONE(4);

    private int id;

    OrderStatus(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static OrderStatus of(int id) {
        return Stream.of(OrderStatus.values()).filter(x -> x.id == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no such id " + id));
    }

}
