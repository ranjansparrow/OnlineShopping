<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>My Cart</title>
</head>
<body>
	<h1>Welcome To My Cart Singham!!</h1>
	<h2>You have successfully added to the cart</h2>
	<a href="/viewProduct">View Other Product</a>

	<c:out value="${userId}" />

	<a href="checkout/${userId}">Checkout</a>


	<div class="table-responsive">
		<table class="table table-condensed table-bordered table-hover">
			<thead class="">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th>Category</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listofProducts}" var="products">
					<td><c:out value="${products.id}" /> </td>
					<td><c:out value="${products.name}">></c:out></td>
					<td><c:out value="${products.price}"></c:out></td>
					<td><c:out value="${products.category}"></c:out></td>
					<td><a class="btn btn-danger btn-xs"
							href="<c:url value='/cartRemove/${products.id}' />">Remove From Cart<span
								class="glyphicon glyphicon-trash"></span></a></td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>