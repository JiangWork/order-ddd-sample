package com.jiangwork.ecom.order.ddd.repository.po.converter;

import com.jiangwork.ecom.order.types.OrderStatus;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;

/**
 * Created by jiangzhao on 2020-10-25 15:38.
 */
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderStatus attribute) {
        if (attribute == null)  return 0;
        return attribute.ordinal();
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return OrderStatus.NEW;
        }
        return OrderStatus.of(dbData);
    }
}