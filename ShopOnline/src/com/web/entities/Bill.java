package com.web.entities;

public class Bill {
	private int idBill;
	private String dateOrther;

	public Bill() {
		super();
	}

	public Bill(int idBill, String dateOrther) {
		super();
		this.idBill = idBill;
		this.dateOrther = dateOrther;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public String getDateOrther() {
		return dateOrther;
	}

	public void setDateOrther(String dateOrther) {
		this.dateOrther = dateOrther;
	}

}
