package com.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.web.entities.Product;
import com.web.entities.ProductType;
import com.web.service.ProductService;
import com.web.service.ProductTypeSevice;

@MultipartConfig
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductService productService = ProductService.getInstance();

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str = req.getParameter("id");
		if (str != null && !str.equals("")) {
			int id = Integer.parseInt(str);
			String img = productService.getProductById(id).getImage();
			if (productService.delete(id)) {
				File file = new File("E:\\ProjectsShop\\ShopOnline\\WebContent\\images\\" + img);
				if (file.delete()) {
				} else {
					System.out.println("khong the xoa anh");
				}
				req.setAttribute("message", "success");
			}
		}
		List<Product> list = productService.getAllProduct();

		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action == null || action.equals("")) {
			List<Product> list = productService.getAllProduct();
			req.setAttribute("list", list);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else if (action.equals("delete")) {
			doDelete(req, resp);
		} else if (action.equals("insert")) {
			List<ProductType> list = ProductTypeSevice.getInstance().getAllProductType();
			req.setAttribute("list", list);
			req.getRequestDispatcher("ProductAdd.jsp").forward(req, resp);
		} else if (action.equals("upload")) {
			String str = req.getParameter("id");
			int id = 0;
			if (str != null && !str.equals("")) {
				id = Integer.parseInt(str);
			}
			Product pd = ProductService.getInstance().getProductById(id);
			req.setAttribute("product", pd);
			List<ProductType> list = ProductTypeSevice.getInstance().getAllProductType();
			req.setAttribute("list", list);
			req.getRequestDispatcher("ProductUpload.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action == null || action.equals("")) {
			Part file = req.getPart("image");
			String str = req.getParameter("id");
			int id = 0;
			if (str != null && !str.equals("")) {
				id = Integer.parseInt(str);
			}
			String name = req.getParameter("name");
			String str1 = req.getParameter("price");
			int price = 0;
			if (str1 != null && !str1.equals("")) {
				price = Integer.parseInt(str1);
			}
			String str2 = req.getParameter("idType");
			int idType = 0;
			if (str2 != null && !str2.equals("")) {
				idType = Integer.parseInt(str2);
			}
			ProductService productService = new ProductService(file);
			String img = productService.getFileName(file);

			Product product = new Product(id, name, price, img, idType);
			if (ProductService.getInstance().create(product)) {
				String uploadRootPath = "E:\\ProjectsShop\\ShopOnline\\WebContent\\images\\" + img;
				productService.saveFile(uploadRootPath);
			}
			List<Product> list = productService.getAllProduct();
			req.setAttribute("list", list);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else if (action.equals("upload")) {
			doPut(req, resp);
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part file = req.getPart("image");
		String str = req.getParameter("id");
		int id = 0;
		if (str != null && !str.equals("")) {
			id = Integer.parseInt(str);
		}
		String name = req.getParameter("name");
		String str1 = req.getParameter("price");
		int price = 0;
		if (str1 != null && !str1.equals("")) {
			price = Integer.parseInt(str1);
		}
		String str2 = req.getParameter("idType");
		int idType = 0;
		if (str2 != null && !str2.equals("")) {
			idType = Integer.parseInt(str2);
		}
		ProductService productService = new ProductService(file);
		String img = productService.getFileName(file);

		Product product = new Product(id, name, price, img, idType);
		System.out.println(product);
		if (img != null && !img.equals("")) {
			if (ProductService.getInstance().uploadHasImage(product)) {
				String uploadRootPath = "E:\\ProjectsShop\\ShopOnline\\WebContent\\images\\" + img;
				productService.saveFile(uploadRootPath);
				List<Product> list = productService.getAllProduct();
				req.setAttribute("list", list);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} else
			{
				System.out.println("fail");
			}
		}
		else
		{
			if (ProductService.getInstance().uploadNoImage(product)) {
				List<Product> list = productService.getAllProduct();
				req.setAttribute("list", list);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} else
			{
				System.out.println("fail");
			}
		}

	}

}
