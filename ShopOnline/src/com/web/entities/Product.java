package com.web.entities;

public class Product {
	private int idProduct;
	private String nameProduct;
	private int price;
	private String image;
	private int idType;

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", price=" + price + ", image="
				+ image + ", idType=" + idType + "]";
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product() {
	}

	public Product(int idProduct, String nameProduct, int price, String image, int idType) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.price = price;
		this.image = image;
		this.idType = idType;
	}

}
