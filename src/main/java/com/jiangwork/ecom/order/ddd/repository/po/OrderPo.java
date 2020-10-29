package com.jiangwork.ecom.order.ddd.repository.po;

import com.jiangwork.ecom.order.ddd.domain.Address;
import com.jiangwork.ecom.order.ddd.repository.po.converter.AddressConverter;
import com.jiangwork.ecom.order.ddd.repository.po.converter.OrderStatusConverter;
import com.jiangwork.ecom.order.types.OrderStatus;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Created by jiangzhao on 2020-10-25 15:13.
 */
@Entity
@Table(name = "t_order")
@Where(clause = "deleted=0")
public class OrderPo extends BasePo {
    /**
     * 订单id
     */
    @Id
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    /**
     * 用户id
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * 总金额
     *
     */
    @Column(name = "total_price", nullable = false)
    private Long totalPrice;

    /**
     * 收货地址
     */
    @Column(name = "address", nullable = false)
    @Convert(converter = AddressConverter.class)
    private Address address;

    /**
     * 订单状态
     */
    @Column(name = "status", nullable = false, columnDefinition = "tinyint")
    @Convert(converter = OrderStatusConverter.class)
    private OrderStatus status;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
