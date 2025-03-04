package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.service.ProductServiceIMPL;

@RestController
@RequestMapping("product-service")
public class ProductController {

	@Autowired
	private ProductServiceIMPL productService;
	
	@GetMapping("/")
	public List<Product> getAllProducts()
	{
		return productService.getAllRecords();
	}
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable int productId)
	{
		return productService.getProductById(productId);
	}
	
	@GetMapping("product-name/{productName}")
	public List<Product> getProductByName(@PathVariable String productName)
	{
		return productService.getProductByName(productName);
	}
	
}
