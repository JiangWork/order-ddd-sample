package com.jiangwork.ecom.order.ddd.domain;

import com.jiangwork.ecom.order.ddd.ValueObject;

/**
 * Created by jiangzhao on 2020-10-25 17:30.
 */
public class Address implements ValueObject {
    private String country;
    private String province;
    private String area;
    private String detail;

    public Address() {

    }

    public Address(String country, String province, String area, String detail) {
        this.country = country;
        this.province = province;
        this.area = area;
        this.detail = detail;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getArea() {
        return area;
    }

    public String getDetail() {
        return detail;
    }
}
