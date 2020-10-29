package com.jiangwork.ecom.order.ddd.factory;

import com.jiangwork.ecom.order.ddd.domain.Order;
import com.jiangwork.ecom.order.ddd.domain.Address;
import com.jiangwork.ecom.order.ddd.domain.OrderLineItem;
import com.jiangwork.ecom.order.ddd.repository.po.OrderLineItemPo;
import com.jiangwork.ecom.order.ddd.repository.po.OrderPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiangzhao on 2020-10-25 12:02.
 */
@Service
public class OrderFactory {

    @Autowired
    private RedisOrderIdGenerator idGenerator;

    public Order create(Long userId, List<OrderLineItem> items, Address address) {
        long orderId = idGenerator.get();
        return Order.create(orderId, userId, items, address);
    }


    public static Order create(OrderPo orderPo, List<OrderLineItemPo> itemPos) {
        List<OrderLineItem> items = itemPos.stream().map(OrderFactory::fromPo).collect(Collectors.toList());
        return Order.create(orderPo.getOrderId(), orderPo.getUserId(), items, orderPo.getAddress());
    }


    private static OrderLineItem fromPo(OrderLineItemPo po) {
        return new OrderLineItem(po.getItemId(), po.getOrderId(), po.getGoods(), po.getCount());
    }

}
