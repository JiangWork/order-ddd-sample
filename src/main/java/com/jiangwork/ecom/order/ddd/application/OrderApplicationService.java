package com.jiangwork.ecom.order.ddd.application;

import com.jiangwork.ecom.order.ddd.domain.Address;
import com.jiangwork.ecom.order.ddd.domain.Goods;
import com.jiangwork.ecom.order.ddd.domain.Order;
import com.jiangwork.ecom.order.ddd.domain.OrderLineItem;
import com.jiangwork.ecom.order.ddd.factory.OrderFactory;
import com.jiangwork.ecom.order.ddd.repository.OrderRepository;
import com.jiangwork.ecom.order.types.GoodsCountVo;
import com.jiangwork.ecom.order.utils.JsonUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by jiangzhao on 2020-10-25 18:16.
 */
@Service
public class OrderApplicationService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderApplicationService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderFactory orderFactory;

    @Transactional
    public void changeGoodsCount(long id, long goodsId, int count) {
        Order order = orderRepository.findById(id);
        order.changeGoodsCount(goodsId, count);
        orderRepository.save(order);
        LOG.info("change order {} goodsId {} count {}", id, goodsId, count);
    }


    @Transactional
    public Order createOrder(Long userId, List<GoodsCountVo> goods, String addressCountry,
                            String addressProvince,
                            String addressArea,
                            String addressDetail) {
        // fake data
        Address address = new Address(addressCountry, addressProvince, addressArea, addressDetail);
        List<OrderLineItem> items = goods.stream().map(this::fakeOrderItem).collect(Collectors.toList());
        Order order = orderFactory.create(userId, items, address);
        order = orderRepository.save(order);
        LOG.info("saved order {}", JsonUtils.to(order));
        return order;
    }


    private OrderLineItem fakeOrderItem(GoodsCountVo vo) {
        OrderLineItem item = new OrderLineItem();
        Goods goods = new Goods(vo.getId(), RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(20), Math.abs(new Random().nextLong()) % 1000 + 10);
        item.setCount(vo.getCount());
        item.setGoods(goods);
        return item;

    }
}
