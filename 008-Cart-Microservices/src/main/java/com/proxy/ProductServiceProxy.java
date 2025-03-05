package com.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dto.CartDto;

@FeignClient("product-service")
public interface ProductServiceProxy {

	@GetMapping("product-service/{productId}")
	public CartDto retrieveProductData(@PathVariable Integer productId);
}
