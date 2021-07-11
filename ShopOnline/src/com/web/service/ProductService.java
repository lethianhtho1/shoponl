package com.web.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

import com.web.dao.ProductDAO;
import com.web.entities.Product;

public class ProductService {
	private static ProductService productService;
	Product pro;
	Part file;

	public ProductService(Part file) {
		this.file = file;
	}

	private ProductService() {
	}

	public static ProductService getInstance() {
		if (productService == null) {
			productService = new ProductService();
		}
		return productService;
	}

	public List<Product> getAllProduct() {
		return ProductDAO.getInstance().getAllProduct();
	}
	public Product getProductById(int id) {
		return ProductDAO.getInstance().getProductById(id);
	}

	public String getFileName(Part filepart) {
		String filename = "";
		String header = filepart.getHeader("Content-Disposition");
		// System.out.println("header:" + header);
		int beginIndex = header.lastIndexOf("=");
		filename = header.substring(beginIndex + 1);

		// remove "" quotes 2 dau chuoi
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = p.matcher(filename);
		while (m.find())
			filename = m.group(1);

		// danh cho IE
		beginIndex = filename.lastIndexOf("\\");
		filename = filename.substring(beginIndex + 1);
		// System.out.println("filename:" + filename);

		return filename;
	}

	public void saveFile(String uploadRootPath) {
		try {
			InputStream fis = file.getInputStream();
			byte[] data = new byte[fis.available()];
			fis.read(data);

			FileOutputStream out = new FileOutputStream(new File(uploadRootPath));
			out.write(data);

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("That bai");
		}
		System.out.println("Thanh cong");

	}
	public boolean create(Product product) {
		return ProductDAO.getInstance().create(product);
	}
	public boolean delete(int id) {
		return ProductDAO.getInstance().delete(id);
	}
	public boolean uploadHasImage(Product product) {
		return ProductDAO.getInstance().uploadHasImage(product);
	}
	public boolean uploadNoImage(Product product) {
		return ProductDAO.getInstance().uploadNoImage(product);
	}
}
