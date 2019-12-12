<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Cart</title>
</head>
<body class="text-center">
	<h1>Cart List</h1>
	<c:forEach var="cart" items="${cartList}">
		<div class="row">
			<div class="col">
			Name: ${cart.name} Description: ${cart.description} Price: <fmt:formatNumber type="currency" value="${cart.price}" />
			
			</div>
		</div>
	</c:forEach>
	<div class="container">
		<div class="row">
			<div class="col">
				<button onclick="window.location = 'index.jsp'" type="button" class="btn btn-default">Back</button>
				<button onclick="window.location = 'confirmation'" type="button" class="btn btn-default">Confirm</button>
			</div>
		</div>
	</div>
	
	<script>
	function saveItem(var id)
	{
		print();
		getProduct(id);
	}
	
	</script>
</body>
</html>