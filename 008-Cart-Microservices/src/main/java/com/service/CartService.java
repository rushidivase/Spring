package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dto.CartDto;
import com.model.Cart;
import com.proxy.ProductServiceProxy;
import com.repo.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repo;

	@Autowired
	private ProductServiceProxy proxy;
	
	public Cart getCartInfo(int cartId) {
		
		return repo.findById(cartId).get();
	}

	public CartDto getAllCartInfo(int cartId) {
		//get productId
		Cart cart = repo.findById(cartId).get();
		
		Map<String, Integer> uriVariable = new HashMap<String, Integer>();
		uriVariable.put("productId", cart.getProductId());
		
		//get ProductData
		ResponseEntity<CartDto> response = new RestTemplate().getForEntity("http://localhost:8091/product-service/{productId}"
				, CartDto.class,  uriVariable);
		
		//return productData
		CartDto cartDto = response.getBody();	
		return new CartDto(cart.getCartId(), cart.getProductId(), cartDto.getProductName(), cartDto.getProductPrice());
		
		
		//Diff bet URI and URL
	}

	public CartDto getAllCartInfoWithProxy(int cartId) {
		Cart cart = repo.findById(cartId).get();
		
		CartDto cartDto = proxy.retrieveProductData(cart.getProductId());
		
		return new CartDto(cart.getCartId(), cart.getProductId(), cartDto.getProductName(), cartDto.getProductPrice());
	}
}






























