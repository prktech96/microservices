package com.shopping.app.shopping_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shopping.app.shopping_service.fiegnclient.PaymentFiegnClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class ShoppingController {

//	@Autowired
//	RestTemplate restTemplate;

	@Autowired
	PaymentFiegnClient paymentFiegnClient;
	int retry =1;
	@GetMapping("/amazon-payment/{price}")
//	@CircuitBreaker(name = "paymentServiceBreaker",fallbackMethod = "payNowFallback")
//	@Retry(name = "paymentService",fallbackMethod = "payNowFallback")
	@RateLimiter(name = "userRateLimiter",fallbackMethod = "payNowFallback")
	public ResponseEntity<String> amezonePayment(@PathVariable int price) {
		System.out.println("Retry count ----"+retry++);
//		String serviceUrl = "http://PAYMENT-SERVICE/payment-provider/payNow/6";
//	return	restTemplate.getForObject("http://localhost:8084/payment-provider/payNow/"+price, String.class	);
//	return  restTemplate.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		String paymentServiceResult = paymentFiegnClient.payNow(price);
		return new ResponseEntity<>(paymentServiceResult, HttpStatus.OK);
	}
	
	public ResponseEntity<String> payNowFallback(int price,Exception exception){
		
		return new ResponseEntity<>("Payment service is temparey down, please use cash or debit card", HttpStatus.OK);
	}
}
