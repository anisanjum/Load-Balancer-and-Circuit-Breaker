package com.learn.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="http://ORDER-SERVICE/order/orders")
public interface OrderClient {

	@GetMapping("/port")
	public String getInfo();
}
