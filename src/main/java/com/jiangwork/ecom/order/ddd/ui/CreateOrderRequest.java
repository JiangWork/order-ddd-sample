package com.jiangwork.ecom.order.ddd.ui;

import com.jiangwork.ecom.order.types.GoodsCountVo;

import java.util.List;

/**
 * Created by jiangzhao on 2020-10-25 20:24.
 */
public class CreateOrderRequest {
    private Long userId;
    private List<GoodsCountVo> goods;
    private String addressCountry;
    private String addressProvince;
    private String addressArea;
    private String addressDetail;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<GoodsCountVo> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsCountVo> goods) {
        this.goods = goods;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

}
