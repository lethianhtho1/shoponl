package com.web.entities;

public class Item {
	private Product product;
	private int number;

	public Item() {
		super();
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", number=" + number + "]";
	}

	public Item(Product product, int number) {
		super();
		this.product = product;
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
