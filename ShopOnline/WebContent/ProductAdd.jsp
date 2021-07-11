<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 40%; margin: auto">
		<form action="product" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>Product</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<td>Image</td>
					<td><input type="file" name=image></td>
				</tr>
				<tr>
					<td>Type Product</td>
					<td><select name = "idType">
							<option value="0">--Chọn--</option>
							<c:forEach var="e" items="${list}">
								<option value="${e.idProductType}">${e.nameProductType}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><button>Add</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>