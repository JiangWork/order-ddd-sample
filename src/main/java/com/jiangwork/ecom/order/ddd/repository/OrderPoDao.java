package com.jiangwork.ecom.order.ddd.repository;

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
public interface OrderPoDao extends JpaRepository<OrderPo, Long>, JpaSpecificationExecutor<OrderPo> {
    OrderPo findByOrderId(Long orderId);

    List<OrderPo> findByUserId(Long userId);
}
