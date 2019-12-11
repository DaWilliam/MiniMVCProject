<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<title>Products</title>
</head>
<body class="text-center">
	<h1>Product List</h1>
	<c:forEach var="product" items="${productlist}">
		<div class="row">
			<div class="col">

			Name: ${product.name} Description: ${product.description} Price: <fmt:formatNumber type="currency" value="${product.price}" />
			<button onclick="window.location = 'add_product/ + ${product.id}/${product.quantity}'" type="button" class="btn btn-default">Add</button>

			</div>
		</div>
	</c:forEach>
	

</body>
</html>