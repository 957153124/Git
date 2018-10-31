package com.javaketang.entity;

public class Sale {
	
	private int id;//记录id
	private double price;//销售单价
	private int quantity;//数量
	private double totalPrice;//总价
	private String saleDate;//销售日期
	private int userId;//销售员id
	private int productId;//商品id
	public Sale(int id, double price, int quantity, double totalPrice, String saleDate, int userId, int productId) {
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.saleDate = saleDate;
		this.userId = userId;
		this.productId = productId;
	}
	
	public Sale() {
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
}
