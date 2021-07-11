package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.web.entities.Product;
import com.web.entities.ProductType;

public class ProductTypeDAO {
	private static ProductTypeDAO productTypeDAO;
	private static MyConnect myConnection = MyConnect.getInstance();

	private ProductTypeDAO() {
	}

	public static ProductTypeDAO getInstance() {
		if (productTypeDAO == null) {
			productTypeDAO = new ProductTypeDAO();
		}
		if (myConnection == null) {
			myConnection = MyConnect.getInstance();
		}
		return productTypeDAO;
	}

	public List<ProductType> getAllProductType() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductType> list = new ArrayList<ProductType>();

		String sql = "SELECT * FROM productType ";
		try {
			connection = myConnection.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductType productType = new ProductType();
				productType.setIdProductType(rs.getInt("idType"));
				productType.setNameProductType(rs.getString("nameType"));
				list.add(productType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close(ps);
			myConnection.close(rs);
		}
		return list;

	}

	public boolean create(String nameProductType) {
		Connection connection = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "insert into productType(nameType) values(?)";
		try {
			connection = myConnection.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, nameProductType);
			rs = ps.executeUpdate();
			if (rs == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close(ps);
		}
		return false;
	}
}