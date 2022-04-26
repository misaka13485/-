package com.zengxuan.core.dto;

public class NeedForm {
    private int goodsId = 0;
    private String neederId;
    private int amount = 0;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getNeederId() {
        return neederId;
    }

    public void setNeederId(String neederId) {
        this.neederId = neederId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public boolean isValid() {
        return goodsId != 0 && neederId != null && amount != 0;
    }

}
