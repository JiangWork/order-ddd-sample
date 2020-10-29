package com.jiangwork.ecom.order.ddd.ui;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Created by jiangzhao on 2020-10-25 18:42.
 */
public class ChangeGoodsCountRequest {
    @Positive
    @NotNull
    private Long goodsId;

    @Positive
    @NotNull
    private Integer count;


    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
