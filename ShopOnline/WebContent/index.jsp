<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<h1>SHOP</h1>
<a href="product?action=insert">Add Product</a>
	<table class="table" >
		<tr>
			<th>Id Product</th>
			<th>Name Product</th>
			<th>Price Product</th>
			<th>Image Product</th>
			<th>Action</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
		<c:forEach var="e" items="${list}">
		<tr>
		 	<td> ${e.idProduct}</td>
		 	<td>${e.nameProduct}</td>
		 	<td>${e.price}</td>
		 	<td><img src="images/${e.image}" style="height: 50px"></td>
		 	<td><a href="cart?action=add&id=${e.idProduct}">
		 	Add Cart</a></td>
		 	<td><a href="product?action=delete&id=${e.idProduct}">Delete Product</a></td>
		 	<td><a href="product?action=upload&id=${e.idProduct}">Edit Product</a></td>
		 	</tr>
		</c:forEach>
	</table>
</body>
<a href="productType">Add Product Type</a>
</html>