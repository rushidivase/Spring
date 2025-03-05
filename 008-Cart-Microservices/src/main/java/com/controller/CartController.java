package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CartDto;
import com.model.Cart;
import com.service.CartService;

@RestController
@RequestMapping("cart-service")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/{cartId}")
	public Cart getCartInfo(@PathVariable int cartId)
	{
		return cartService.getCartInfo(cartId);
	}
	
	@GetMapping("/dto/{cartId}")
	public CartDto getAllCartInfo(@PathVariable int cartId)
	{
		return  cartService.getAllCartInfo(cartId);
	}
	
	@GetMapping("/dto-proxy/{cartId}")
	public CartDto getAllCartInfoWithProxy(@PathVariable int cartId)
	{
		return  cartService.getAllCartInfoWithProxy(cartId);
	}
	
	
}
