<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Add Product</title>
</head>
<body>
	<form:form name="addProduct" method="POST" action="saveProduct" modelAttribute="product" enctype="multipart/form-data">
		<label>Name</label>
		<form:input path="name" /> <br>
		<label>Price</label>
		<form:input path="price" /><br>
		<label>Category</label>
		<div class="col-lg-8">
			<form:select path="category" class="form-control">
				<form:option value="" label="Select Blood Type" />
				<form:options path="${availableOptions}" />
			</form:select>
			<span class="help-block"></span>
		</div>
		<span>File To Upload:</span>	<input type="file" name="file" />
		<input type = "submit" value = "Add Product" />
	</form:form>
</body>
</html>