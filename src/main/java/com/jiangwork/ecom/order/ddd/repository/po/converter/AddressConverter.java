package com.jiangwork.ecom.order.ddd.repository.po.converter;

import com.jiangwork.ecom.order.ddd.domain.Address;
import com.jiangwork.ecom.order.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;

/**
 * Created by jiangzhao on 2020-10-25 15:38.
 */
public class AddressConverter implements AttributeConverter<Address, String> {
    @Override
    public String convertToDatabaseColumn(Address attribute) {
        if (attribute == null)  return StringUtils.EMPTY;
        return JsonUtils.to(attribute);
    }

    @Override
    public Address convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return new Address();
        }
        return JsonUtils.from(dbData, Address.class);
    }
}