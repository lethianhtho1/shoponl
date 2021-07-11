package com.web.service;

import com.web.dao.InvoiceDetailsDAO;
import com.web.entities.InvoiceDetail;

public class InvoiceDetailService {
	private static InvoiceDetailService detailService;

	private InvoiceDetailService() {
	}

	public static InvoiceDetailService getInstance() {
		if (detailService == null) {
			detailService = new InvoiceDetailService();
		}
		return detailService;
	}
	public boolean create(InvoiceDetail invoiceDetail) {
		return InvoiceDetailsDAO.getInstance().create(invoiceDetail);
	}
}
