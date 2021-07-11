package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.ProductTypeSevice;

@WebServlet("/productType")
public class ProductTypeController extends HttpServlet {
	ProductTypeSevice productTypeSevice = ProductTypeSevice.getInstance();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doDelete(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", productTypeSevice .getAllProductType());
		req.getRequestDispatcher("ProductType.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("nameProduct");
		if(productTypeSevice.create(name))
		{
			req.setAttribute("message", "Success");
		}
		else
		{
			req.setAttribute("message", "Fail");
		}
		req.setAttribute("list", productTypeSevice .getAllProductType());
		req.getRequestDispatcher("ProductType.jsp").forward(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

}
