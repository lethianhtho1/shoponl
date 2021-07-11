package com.web.entities;

public class ProductType {
	private int idProductType;
	private String nameProductType;

	public ProductType(int idProductType, String nameProductType) {
		super();
		this.idProductType = idProductType;
		this.nameProductType = nameProductType;
	}

	public ProductType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdProductType() {
		return idProductType;
	}

	public void setIdProductType(int idProductType) {
		this.idProductType = idProductType;
	}

	public String getNameProductType() {
		return nameProductType;
	}

	public void setNameProductType(String nameProductType) {
		this.nameProductType = nameProductType;
	}

}
