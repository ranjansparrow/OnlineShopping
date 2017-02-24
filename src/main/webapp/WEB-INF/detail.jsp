<html>
	<head>
		<title>Detail</title>
	</head>
	<body>
		<p> Welcome to Detail page Singham </p>
		<span>Name of the product</span>  ${product.name} <br>
		<span>Price Of the Product</span> ${product.price} <br>
		<span> Category</span> ${product.category} <br>
		<span>Image</span> <img src = "/images/${product.imageUpload}" height="100px" >
		<br>
		<a href = "/addToCart"> Add to Cart</a>
		
	</body>
</html>