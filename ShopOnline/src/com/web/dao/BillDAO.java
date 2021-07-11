package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.web.entities.Bill;


public class BillDAO {

	private static BillDAO billDAO;
	private static MyConnect myConnection = MyConnect.getInstance();

	private BillDAO() {
	}

	public static BillDAO getInstance() {
		if (billDAO == null) {
			billDAO = new BillDAO();
		}
		if (myConnection == null) {
			myConnection = MyConnect.getInstance();
		}
		return billDAO;
	}
	public boolean createBill(Bill bill) {
		Connection connection = null;
		PreparedStatement ps = null;
		int rs = 0;
		try {
			connection = myConnection.getConnection();
			String sql = "insert into bill(orderDate) values(?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, bill.getDateOrther());
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
	public int getNewestIdBill() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = myConnection.getConnection();
			String sql = "select MAX(idBill) from bill";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			myConnection.close(rs);
			myConnection.close(ps);
		}
		return 0;
	}
}
