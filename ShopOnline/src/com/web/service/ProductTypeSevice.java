package com.web.service;

import java.util.List;

import com.web.dao.ProductTypeDAO;
import com.web.entities.ProductType;

public class ProductTypeSevice {
	private static ProductTypeSevice productTypeSevice;

	private ProductTypeSevice() {
	}

	public static ProductTypeSevice getInstance() {
		if (productTypeSevice == null) {
			productTypeSevice = new ProductTypeSevice();
		}
		return productTypeSevice;
	}
	public List<ProductType> getAllProductType() {
		return ProductTypeDAO.getInstance().getAllProductType();
	}
	public boolean create(String nameProductType) {
		return ProductTypeDAO.getInstance().create(nameProductType);		
	}
}
