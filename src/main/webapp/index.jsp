
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<style>
	.top-buffer { margin-top:20px; }
</style>
</head>
<body class="text-center">
	<h1>Welcome to the One and Only Online Retail</h1>
	<div class="row top-buffer">
		<div class="btn-group btn-group-lg" role="group" aria-label="...">
			<button type="button" class="btn btn-default" onclick="to_all_products()">All Products</button>
		</div>

	</div>
	<div class="row top-buffer">
		<div class="btn-group btn-group-lg" role="group" aria-label="...">
			<button type="button" class="btn btn-default" onclick="to_search_products()">Search Product</button>
		</div>
	</div>
	<div class="row top-buffer">
		<div class="btn-group btn-group-lg" role="group" aria-label="...">
			<button type="button" class="btn btn-default" onclick="to_cart()">View Cart</button>
		</div>
	</div>
	
   <!--  <a href="view">Search Product</a> -->
    
    <script>
		function to_all_products()
		{
			//print("Going to products");
			location.href = "products";
		}

		function to_search_products()
		{
			location.href = "add";
		}
		
		function to_cart()
		{
			location.href = "add";
		}
    </script>
</body>
</html>
