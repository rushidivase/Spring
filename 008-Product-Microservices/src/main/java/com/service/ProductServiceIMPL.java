package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.repository.ProductRepository;

@Service
public class ProductServiceIMPL {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> getAllRecords() {
		
		return repo.findAll();
	}

	public Product getProductById(int productId) {
		
		return repo.findById(productId).get();
	}

	public List<Product> getProductByName(String productName) {
		
		return repo.findByProductName(productName);
	}
	
	

}
