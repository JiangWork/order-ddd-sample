package com.jiangwork.ecom.order.ddd.repository;

import com.jiangwork.ecom.order.ddd.factory.OrderFactory;
import com.jiangwork.ecom.order.ddd.domain.Order;
import com.jiangwork.ecom.order.ddd.domain.OrderLineItem;
import com.jiangwork.ecom.order.ddd.repository.po.OrderLineItemPo;
import com.jiangwork.ecom.order.ddd.repository.po.OrderPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiangzhao on 2020-10-25 15:05.
 */
@Repository
public class OrderRepository {

    @Autowired
    private OrderLineItemPoDao orderLineItemPoDao;

    @Autowired
    private OrderPoDao orderPoDao;


    public Order findById(Long orderId) {
        OrderPo orderPo = orderPoDao.findByOrderId(orderId);
        if (orderPo == null) {
            throw new IllegalArgumentException("no such order: " + orderId);
        }
        List<OrderLineItemPo> itemPos = orderLineItemPoDao.findByOrderId(orderId);
        return OrderFactory.create(orderPo, itemPos);
    }


    @Transactional
    public Order save(Order order) {
        OrderPo orderPo = toPo(order);
        orderPo = orderPoDao.save(orderPo);
        OrderPo savedOrderPo = orderPo;
        List<OrderLineItemPo> itemPos = order.getItems().stream().map(x -> toPo(x, savedOrderPo)).collect(Collectors.toList());
        itemPos = orderLineItemPoDao.saveAll(itemPos);
        return OrderFactory.create(orderPo, itemPos);
    }

    private OrderPo toPo(Order order) {
        OrderPo po = new OrderPo();
        po.setOrderId(order.getId());
        po.setUserId(order.getUserId());
        po.setAddress(order.getAddress());
        po.setStatus(order.getOrderStatus());
        po.setTotalPrice(order.getTotalPrice());
        return po;
    }

    private OrderLineItemPo toPo(OrderLineItem item, OrderPo order) {
        OrderLineItemPo po = new OrderLineItemPo();
        po.setItemId(item.getId());
        po.setOrderId(order.getOrderId());
        po.setGoods(item.getGoods());
        po.setCount(item.getCount());
        return po;
    }


}
