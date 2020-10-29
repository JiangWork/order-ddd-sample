package com.jiangwork.ecom.order.types;

/**
 * Created by jiangzhao on 2020-10-24 16:10.
 */
public class OrderCannotBeModifiedException extends RuntimeException {
    public OrderCannotBeModifiedException(long id) {
        super();
    }
}
