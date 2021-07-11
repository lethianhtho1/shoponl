package com.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MyConnect {
	private static final String user = "root";
	private static final String password = "mysql";
	private static MyConnect myConnection = null;

	private MyConnect() {

	}

	public static MyConnect getInstance() {
		if (myConnection == null) {
			myConnection = new MyConnect();
		}
		return myConnection;
	}

	public Connection getConnection() {
		Connection connection = null;
		String databaseUrl = "jdbc:mysql://localhost:3306/demo";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(databaseUrl, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}

		return connection;
	}

	public void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
