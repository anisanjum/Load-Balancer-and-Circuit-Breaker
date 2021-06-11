package com.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.learn.feignclient.OrderClient;

@Service
public class UserService {


	@Autowired
	OrderClient orderClient;
	
	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;

	//@GetMapping("/port") 
	public String getInfo() { 
		CircuitBreaker circuitBreaker=circuitBreakerFactory.create("orderservice");
		return circuitBreaker.run(() ->orderClient.getInfo(), throwable -> getDefaultInfor());
		//return orderClient.getInfo();
	}

	private String getDefaultInfor() {
		// TODO Auto-generated method stub
		return "Order Service is down. Please try later";
	}


}
