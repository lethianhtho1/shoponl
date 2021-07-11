package com.web.entities;

public class InvoiceDetail {
	private int idProduct;
	private int idBill;
	private int numberProduct;

	public InvoiceDetail() {
		super();
	}

	public InvoiceDetail(int idBill, int idProduct, int numberProduct) {
		super();
		this.idProduct = idProduct;
		this.idBill = idBill;
		this.numberProduct = numberProduct;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public int getNumberProduct() {
		return numberProduct;
	}

	public void setNumberProduct(int numberProduct) {
		this.numberProduct = numberProduct;
	}

}
