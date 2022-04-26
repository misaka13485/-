package com.zengxuan.core.dto;


/**
 * 捐赠表单
 *
 * @author zengxuan
 * @date 2022-4-23
 */
public class DonateForm {
    private int goodsId = -1;
    private int donater = -1;
    private int amount = -1;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getDonater() {
        return donater;
    }

    public void setDonater(int donater) {
        this.donater = donater;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isValid() {
        return goodsId > 0 && donater > 0 && amount > 0;
    }
}
