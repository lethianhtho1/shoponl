<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<form action="productType" method="post">
		<h3>Add Product Type</h3>
		<input type="text" name="nameProduct">
		<button>Add</button>
	</form>
	<table table class="table table-hover">
		<tr>
			<td>Name</td>
		</tr>
		<c:forEach var="e" items="${list}">
			<tr>
				<td>${e.nameProductType}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>