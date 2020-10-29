package com.jiangwork.ecom.order.ddd.domain;

import com.jiangwork.ecom.order.ddd.AggreateRoot;
import com.jiangwork.ecom.order.types.OrderCannotBeModifiedException;
import com.jiangwork.ecom.order.types.OrderStatus;

import java.util.Collections;
import java.util.List;

import static com.jiangwork.ecom.order.types.OrderStatus.NEW;
import static com.jiangwork.ecom.order.types.OrderStatus.PAID;

/**
 * Created by jiangzhao on 2020-10-24 16:36.
 */
public class Order implements AggreateRoot {
    private Long id;
    private Long userId;
    private Long totalPrice;
    private OrderStatus orderStatus;
    private List<OrderLineItem> items;
    private Address address;

    public static Order create(Long id, Long userId, List<OrderLineItem> items, Address address) {
        return new Order(id, userId, items, address);
    }

    public Order() {

    }

    public Order(Long id, Long userId, List<OrderLineItem> items, Address address) {
        this.id = id;
        this.userId = userId;
        this.orderStatus = NEW;
        this.items = items;
        this.address = address;
        updateTotalPrice();
    }

    public void changeGoodsCount(long goodsId, int count) {
        if (orderStatus == PAID) {
            throw new OrderCannotBeModifiedException(id);
        }
        OrderLineItem item = items.stream().filter(x -> x.getGoodsId() == goodsId).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no such goods id " + goodsId));
        item.setCount(count);
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        this.totalPrice = items.stream().mapToLong(x -> x.getGoods().getPrice() * x.getCount()).sum();
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderLineItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Address getAddress() {
        return address;
    }
}
