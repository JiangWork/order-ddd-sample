package com.jiangwork.ecom.order.ddd.repository;

import com.jiangwork.ecom.order.ddd.repository.po.OrderLineItemPo;
import com.jiangwork.ecom.order.ddd.repository.po.OrderPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jiangzhao on 2020-10-25 17:02.
 */
@Transactional(propagation = Propagation.SUPPORTS)
public interface OrderLineItemPoDao extends JpaRepository<OrderLineItemPo, Long>, JpaSpecificationExecutor<OrderLineItemPo> {
    OrderLineItemPo findByItemId(Long itemId);
    
    List<OrderLineItemPo> findByOrderId(Long orderId);
}
