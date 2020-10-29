package com.jiangwork.ecom.order.ddd.domain;

import com.jiangwork.ecom.order.ddd.Entity;

/**
 * Created by jiangzhao on 2020-10-25 17:29.
 */
public class OrderLineItem implements Entity {
    private Long id;
    private Long orderId;
    private Goods goods;
    private Integer count;

    public OrderLineItem() {

    }

    public OrderLineItem(Long id, Long orderId, Goods goods, Integer count) {
        this.id = id;
        this.orderId = orderId;
        this.goods = goods;
        this.count = count;
    }

    public Long getGoodsId() {
        return goods.getId();
    }


    // getter and setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
