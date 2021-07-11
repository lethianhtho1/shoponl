package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.entities.Bill;
import com.web.entities.InvoiceDetail;
import com.web.entities.Item;
import com.web.service.BillService;
import com.web.service.CartService;
import com.web.service.InvoiceDetailService;

@WebServlet("/cart")
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CartService cartService = CartService.getInstance();

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s = (String) req.getParameter("id");
		int id = 0;
		if (s != null && !s.equals("")) {
			id = Integer.parseInt(s);
		}

		String action = req.getParameter("action");
		if (action.equals("delete")) {
			cartService.removeProduct(id);
			HashMap<Integer, Item> cart = CartService.getInstance().getList();
			req.setAttribute("list", cart);

		} else if (action.equals("deleteAll")) {
			cartService.removeAll();
			HashMap<Integer, Item> cart = CartService.getInstance().getList();
			req.setAttribute("list", cart);
		}

		int total = cartService.totalList();
		req.setAttribute("total", total);
		req.getRequestDispatcher("Cart.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals("add")) {
				doPost(req, resp);
			} else if (action.equals("delete") || action.equals("deleteAll")) {
				doDelete(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String action = req.getParameter("action");
		if (action == null || action.equals("")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Calendar cal = Calendar.getInstance();
			String dateOrder = dateFormat.format(cal.getTime());

			Bill bill = new Bill(0, dateOrder);

			if (BillService.getInstance().createBill(bill)) {
				int newestIdBill = BillService.getInstance().getNewestIdBill();
				ArrayList<Item> cart = cartService.getListItems();
				for (Item i : cart) {
					InvoiceDetail invoiceDetail = new InvoiceDetail(newestIdBill, i.getProduct().getIdProduct(),
							i.getNumber());
					InvoiceDetailService.getInstance().create(invoiceDetail);
				}
				System.out.println("success");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Order Success!');");
				out.println("location='product';");
				out.println("</script>");
				out.close();
			}
			cartService.removeAll();

		} else {

			int id = Integer.parseInt(req.getParameter("id").toString());
			cartService.addList(id);
			HashMap<Integer, Item> cart = CartService.getInstance().getList();
			int total = CartService.getInstance().totalList();
			req.setAttribute("total", total);
			req.setAttribute("list", cart);
			req.getRequestDispatcher("Cart.jsp").forward(req, resp);

		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPut(req, resp);
	}

}
