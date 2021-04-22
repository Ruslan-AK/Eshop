package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Coupon {
    private Long id;
    private Discount discount;
    private Good.GoodType goodType;
    private String code;

    public Coupon(Long id, Discount discount, Good.GoodType goodType, String code) {
        this.id = id;
        this.discount = discount;
        this.goodType = goodType;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Good.GoodType getGoodType() {
        return goodType;
    }

    public void setGoodType(Good.GoodType goodType) {
        this.goodType = goodType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal calculateDiscountPrice(Good good) {
        BigDecimal result = new BigDecimal(0);
        if (discount != null
            && !discount.getUsed()
            && discount.getExpDate() != null
            && discount.getExpDate().after(new Date(System.currentTimeMillis()))) {
            result = good.getPrice().multiply(discount.getValue());
        }
        return result;
    }
}
