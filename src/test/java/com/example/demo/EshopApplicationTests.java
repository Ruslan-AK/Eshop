package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class EshopApplicationTests {
	@Autowired
	OrderService service;
	@Test
	void testGetOrderOverallPrice() {
		Order order = getOrder();
		List<Coupon> coupons = getCoupons(order);
		BigDecimal orderOverallPrice = service.getOrderOverallPrice(order, coupons);
		System.out.println("Result price: " + orderOverallPrice);
		Assert.isTrue(orderOverallPrice.round(new MathContext(4)).equals(new BigDecimal(407.5d)), "Calculation is wrong");
	}

	private Order getOrder() {
		Good laptop = new Good(1l,Good.GoodType.ELECTRONIC,"Laptop",new BigDecimal(450));
		Good laptopCase = new Good(1l,Good.GoodType.ACCESSORIES,"laptopCase",new BigDecimal(20));
		Good burger = new Good(1l,Good.GoodType.FOOD,"burger",new BigDecimal(5));
		return new Order(1l, Arrays.asList(laptop, laptopCase, burger), new Customer(1l, "Test", "Test"));
	}

	private List<Coupon> getCoupons(Order order) {
		return Arrays.asList(
				new Coupon(1l, new Discount(1l, new BigDecimal(0.1), new Date(System.currentTimeMillis() + 86400000), false), Good.GoodType.ELECTRONIC, "TestCode")
				,
				new CouponWithGift(2l, new Discount(2l, new BigDecimal(1), new Date(System.currentTimeMillis() + 86400000), false), Good.GoodType.ACCESSORIES, "TestCode2",
					new HashMap<Good.GoodType, Good.GoodType>() {{
						put(Good.GoodType.ELECTRONIC, Good.GoodType.ACCESSORIES);
					}}, order.getGoods().stream().map(g -> g.getType()).collect(Collectors.toList()))
				,
				new MultiDiscountCoupon(3l, new Discount(3l, new BigDecimal(0.5), new Date(System.currentTimeMillis() + 86400000), false), Good.GoodType.FOOD, "TestCode3",
						order.getGoods())
		);
	}
}
