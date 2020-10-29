package com.jiangwork.ecom.order.ddd.repository.po.converter;

import com.jiangwork.ecom.order.ddd.domain.Goods;
import com.jiangwork.ecom.order.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;

/**
 * Created by jiangzhao on 2020-10-25 15:38.
 */
public class GoodsConverter implements AttributeConverter<Goods, String> {
    @Override
    public String convertToDatabaseColumn(Goods attribute) {
        if (attribute == null)  return StringUtils.EMPTY;
        return JsonUtils.to(attribute);
    }

    @Override
    public Goods convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return new Goods();
        }
        return JsonUtils.from(dbData, Goods.class);
    }
}