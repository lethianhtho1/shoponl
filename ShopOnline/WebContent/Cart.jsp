<%@page import="com.web.entities.Item"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shop Online</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1>View cart!</h1>
	<form action="cart" method="post">
		<table border="1" class="table">
			<tr>
				<td>Id Product</td>
				<td>Name Product</td>
				<td>Image Product</td>
				<td>Price</td>
				<td>Count</td>
				<td>Total</td>
				<td>Action</td>
			</tr>
			<c:forEach var="v" items="${list}">
				<tr>
					<td>${v.value.product.idProduct }</td>
					<td>${v.value.product.nameProduct}</td>
					<td><img src="images/${v.value.product.image}" height="50px"
						width="60px" /></td>
					<td>${v.value.product.price}</td>
					<td>${v.value.number}</td>
					<td>${v.value.number * v.value.product.price}</td>
					<td><a
						href="cart?action=delete&id=${v.value.product.idProduct }">Delete</a></td>
			</c:forEach>
		</table>
		<h2>Total: ${total}</h2>
		<a href="product">Buy More</a> <a href="cart?action=deleteAll">Remove
			All</a> <input type="submit" value="Buy Product">
	</form>
</body>
</html>
