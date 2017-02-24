<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>View Product</title>
</head>
<body>
	<div class="table-responsive">
		<table class="table table-condensed table-bordered table-hover">
			<thead class="">
				<tr>
					<th> Id </th>
					<th>Name</th>
					<th>Price</th>
					<th>Category</th>
					<th>Image </th>
					<th>Action </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${product}" var="products">
					<tr>
						<td><c:out value="${products.id}" /></td>
						<td><c:out value="${products.name}" /></td>
						<td><c:out value="${products.price}" /></td>
						<td><c:out value="${products.category}" /></td>
						<td><img src = "/images/${products.imageUpload}" height="100px" /> </td>
						<td><a class="btn btn-danger btn-xs"
							href="<c:url value='/viewDetails/${products.id}' />">View Details<span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>