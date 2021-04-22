package com.example.demo.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponWithGift extends Coupon {
    private Map<Good.GoodType, Good.GoodType> primaryGoodToGiftMap = new HashMap<>();
    private List<Good.GoodType> orderGoodTypes = new ArrayList<>();
    public CouponWithGift(Long id, Discount discount, Good.GoodType goodType, String code, Map<Good.GoodType, Good.GoodType> primaryGoodToGiftMap, List<Good.GoodType> orderGoodTypes) {
        super(id, discount, goodType, code);
        this.orderGoodTypes.addAll(orderGoodTypes);
        this.primaryGoodToGiftMap.putAll(primaryGoodToGiftMap);
    }

    public Map<Good.GoodType, Good.GoodType> getPrimaryGoodToGiftMap() {
        return primaryGoodToGiftMap;
    }

    public void setPrimaryGoodToGiftMap(Map<Good.GoodType, Good.GoodType> primaryGoodToGiftMap) {
        this.primaryGoodToGiftMap = primaryGoodToGiftMap;
    }

    @Override
    public BigDecimal calculateDiscountPrice(Good giftGood) {
        BigDecimal result = new BigDecimal(0);
        for (Map.Entry<Good.GoodType, Good.GoodType> entry : primaryGoodToGiftMap.entrySet()) {
            if (orderGoodTypes.contains(entry.getKey())
                    && giftGood.getType() == entry.getValue()) {
                result = result.add(super.calculateDiscountPrice(giftGood));
            }
        }
        return result;
    }
}
