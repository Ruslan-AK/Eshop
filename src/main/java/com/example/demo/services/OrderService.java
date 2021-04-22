package com.example.demo.services;

import com.example.demo.entities.Coupon;
import com.example.demo.entities.Good;
import com.example.demo.entities.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    public BigDecimal getOrderOverallPrice(Order order, List<Coupon> coupons) {
        BigDecimal orderPrice = new BigDecimal(0);
        for (Good good : order.getGoods()) {
            BigDecimal goodPrice = new BigDecimal(good.getPrice().doubleValue());
            for (Coupon coupon : coupons) {
                if (good.getType() == coupon.getGoodType()) {
                    goodPrice = goodPrice.subtract(coupon.calculateDiscountPrice(good));//0.3 - 30%
                    coupon.getDiscount().setUsed(true);
                }
            }
            orderPrice = orderPrice.add(goodPrice);
        }
        return orderPrice;
    }
}
