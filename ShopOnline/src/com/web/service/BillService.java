package com.web.service;

import com.web.dao.BillDAO;
import com.web.entities.Bill;

public class BillService {
	private static BillService billService;

	private BillService() {
	}

	public static BillService getInstance() {
		if (billService == null) {
			billService = new BillService();
		}
		return billService;
	}
	public boolean createBill(Bill bill) {
		return BillDAO.getInstance().createBill(bill);
	}
	
	public int getNewestIdBill()
	{
		return BillDAO.getInstance().getNewestIdBill();
	}
}
