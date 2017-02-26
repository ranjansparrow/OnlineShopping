<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>My Cart</title>
	</head>
	<body>
		<h1>Welcome To My Cart Singham!!</h1>
		<h2>You have successfully added to the cart</h2>
		<a href = "/viewProduct">View Other Product</a>
		<c:forEach items="${listofProducts}" var="products">
			Id <c:out value="${products.id}" /> <br>
			Name <c:out value="${products.name}">></c:out> <br>
			Price <c:out value="${products.price}"></c:out> <br>
			Category <c:out value="${products.category}"></c:out> <br>
		</c:forEach>
		
		
		<a href="checkout">Checkout</a>
	</body>
</html>