package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.web.entities.Product;

public class ProductDAO {
	private static ProductDAO productDAO;
	private static MyConnect myConnection = MyConnect.getInstance();

	private ProductDAO() {
	}

	public static ProductDAO getInstance() {
		if (productDAO == null) {
			productDAO = new ProductDAO();
		}
		if (myConnection == null) {
			myConnection = MyConnect.getInstance();
		}
		return productDAO;
	}

	public List<Product> getAllProduct() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM product ";
		try {
			connection = myConnection.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setIdProduct(rs.getInt("idProduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setPrice(rs.getInt("priceProduct"));
				product.setImage(rs.getString("image"));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close(ps);
			myConnection.close(rs);
		}
		return list;
	}

	public Product getProductById(int id) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = new Product();
		String sql = "SELECT * FROM product WHERE idProduct=" + id;
		try {
			connection = myConnection.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				product.setIdProduct(rs.getInt("idProduct"));
				product.setNameProduct(rs.getString("nameProduct"));
				product.setPrice(rs.getInt("priceProduct"));
				product.setImage(rs.getString("image"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close(ps);
			myConnection.close(rs);
		}
		return product;
	}

	public boolean create(Product product) {
		Connection connection = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "insert into product(nameProduct,priceProduct,image,idType) values (?,?,?,?)";
		try {
			connection = myConnection.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, product.getNameProduct());
			ps.setInt(2, product.getPrice());
			ps.setString(3, product.getImage());
			ps.setInt(4, product.getIdType());
			rs = ps.executeUpdate();
			if (rs == 1) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close(ps);
		}
		return false;
	}

	public boolean delete(int id) {
		Connection connection = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "delete from product where idProduct=?";
		try {
			connection = myConnection.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeUpdate();
			if (rs == 1) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close(ps);
		}
		return false;
	}
	public boolean uploadHasImage(Product product) {
		Connection connection = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "Update product set nameProduct=? , priceProduct=?, image=?, idType=? where idProduct=?";
		try {
			connection = myConnection.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, product.getNameProduct());
			ps.setInt(2,product.getPrice());
			ps.setString(3, product.getImage());
			ps.setInt(4, product.getIdType());
			ps.setInt(5, product.getIdProduct());
			rs = ps.executeUpdate();
			if (rs == 1) {
				System.out.println("daook");
				return true;
			} else
				System.out.println("daono");
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close(ps);
		}
		return false;
	}
	public boolean uploadNoImage(Product product) {
		Connection connection = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "Update product set nameProduct=? , priceProduct=?, idType=? where idProduct=?";
		try {
			connection = myConnection.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, product.getNameProduct());
			ps.setInt(2,product.getPrice());
			ps.setInt(3, product.getIdType());
			ps.setInt(4, product.getIdProduct());
			rs = ps.executeUpdate();
			if (rs == 1) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myConnection.close(ps);
		}
		return false;
	}
}
