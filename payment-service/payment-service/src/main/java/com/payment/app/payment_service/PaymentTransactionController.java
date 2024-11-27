package com.payment.app.payment_service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class PaymentTransactionController {

	@GetMapping
	public List<String> getTransaction(){
		return List.of("1000 rupees :: Laptop repair charges","550 rupees :: Mobile repair charges","2000 rupees :: DVD writer repair charges","5000 rupees :: iWatch repair charges");
	}
}
