package com.jiangwork.ecom.order.ddd.ui;

import com.jiangwork.ecom.order.ddd.application.OrderApplicationService;
import com.jiangwork.ecom.order.ddd.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jiangzhao on 2020-10-25 18:37.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderApplicationService orderService;

    @RequestMapping(value = {"/{orderId}/goods"}, method = RequestMethod.POST)
    public String changeGoodsCount(@PathVariable("id") Long orderId, @RequestBody @Valid ChangeGoodsCountRequest request) {
        try {
            // do some parameter check
            orderService.changeGoodsCount(orderId, request.getGoodsId(), request.getCount());
            return "SUCCESS";
        } catch (Exception e) {
            LOG.error("error occur", e);
        }
        return "FAIL";
    }


    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public Order createOrder(@RequestBody @Valid CreateOrderRequest request) {
        try {
            // do some parameter check
            return orderService.createOrder(request.getUserId(), request.getGoods(),
                    request.getAddressCountry(),
                    request.getAddressProvince(),
                    request.getAddressArea(),
                    request.getAddressDetail());
        } catch (Exception e) {
            LOG.error("error occur", e);
        }
        return null;
    }

}
