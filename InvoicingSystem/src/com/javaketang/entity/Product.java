package com.javaketang.entity;

public class Product {
	
	private int id ;//商品id
	private String productName ;//商品名称
	private int quantity;//库存量
	
	public Product(int id, String productName, int quantity) {
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
	}
	
	public Product() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
