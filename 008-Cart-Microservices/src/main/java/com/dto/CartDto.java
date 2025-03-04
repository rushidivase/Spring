package com.dto;

public class CartDto {

	private int cartId;
	private int productId;
	private String productName;
	private double productPrice;

	public CartDto()
	{
		
	}
	
	public CartDto(int cartId, int productId, String productName, double productPrice) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "CartDto [cartId=" + cartId + ", productId=" + productId + ", productName=" + productName
				+ ", productPrice=" + productPrice + "]";
	}

}
