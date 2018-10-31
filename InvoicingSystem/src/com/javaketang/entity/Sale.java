package com.javaketang.entity;

public class Sale {
	
	private int id;//��¼id
	private double price;//���۵���
	private int quantity;//����
	private double totalPrice;//�ܼ�
	private String saleDate;//��������
	private int userId;//����Աid
	private int productId;//��Ʒid
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
