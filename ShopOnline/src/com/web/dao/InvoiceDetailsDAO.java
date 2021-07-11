package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.web.entities.InvoiceDetail;

public class InvoiceDetailsDAO {
	private static InvoiceDetailsDAO invoiceDetails;
	private static MyConnect myConnection = MyConnect.getInstance();

	private InvoiceDetailsDAO() {
	}

	public static InvoiceDetailsDAO getInstance() {
		if (invoiceDetails == null) {
			invoiceDetails = new InvoiceDetailsDAO();
		}
		if (myConnection == null) {
			myConnection = MyConnect.getInstance();
		}
		return invoiceDetails;
	}
	public boolean create(InvoiceDetail invoiceDetail) {
		Connection connection = null;
		PreparedStatement ps = null;
		int rs = 0;
		try {
			connection = myConnection.getConnection();
			String sql = "insert into invoiceDetails values(?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, invoiceDetail.getIdBill());
			ps.setInt(2, invoiceDetail.getIdProduct());
			ps.setInt(3, invoiceDetail.getNumberProduct());
			rs = ps.executeUpdate();
			if(rs==1)
			{
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			myConnection.close(ps);
		}
		return false;
	}
}
