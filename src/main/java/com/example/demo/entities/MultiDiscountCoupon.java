package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MultiDiscountCoupon extends Coupon {
    private List<Good> orderGoods = new ArrayList<>();

    public MultiDiscountCoupon(Long id, Discount discount, Good.GoodType goodType, String code, List<Good> orderGoods) {
        super(id, discount, goodType, code);
        this.orderGoods.addAll(orderGoods);
    }

    @Override
    public BigDecimal calculateDiscountPrice(Good good) {
        BigDecimal result = new BigDecimal(0);
        if ((orderGoods.indexOf(good) + 1) % 4 == 0
            || (orderGoods.indexOf(good) + 1) % 4 == 3) {
            result = result.add(super.calculateDiscountPrice(good));
        }
        return result;
    }
}
