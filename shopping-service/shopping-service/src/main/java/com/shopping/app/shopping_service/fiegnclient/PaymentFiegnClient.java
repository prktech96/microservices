package com.shopping.app.shopping_service.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentFiegnClient {
	
	@GetMapping("/payment-provider/payNow/{price}")
	String payNow(@PathVariable("price") int price);
}
