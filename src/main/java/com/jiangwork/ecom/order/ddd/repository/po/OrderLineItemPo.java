package com.jiangwork.ecom.order.ddd.repository.po;

import com.jiangwork.ecom.order.ddd.domain.Goods;
import com.jiangwork.ecom.order.ddd.repository.po.converter.GoodsConverter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Created by jiangzhao on 2020-10-25 15:13.
 */
@Entity
@Table(name = "t_order_item")
@Where(clause = "deleted=0")
public class OrderLineItemPo extends BasePo {
    /**
     * 订单项目id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    /**
     * 订单id, 外键
     */
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    /**
     * 商品信息
     */
    @Column(name = "goods", nullable = false)
    @Convert(converter = GoodsConverter.class)
    private Goods goods;

    /**
     *
     * 个数
     */
    @Column(name = "count", nullable = false)
    private Integer count;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
