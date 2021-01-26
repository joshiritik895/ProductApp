<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file = "./base.jsp" %>
</head>
<body>
<div class ="container mt-3">
<h1 class = "text-center">change product detail</h1>
<form action  = "${pageContext.request.contextPath}/handle-product" method  = "post">
	<div class="form-group">
    <label for="formGroupExampleInput">Product ID</label>
    <input type="text" class="form-control" name = "id" id="id" value = "${product.id}" placeholder="Enter product id">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">Product Name</label>
    <input type="text" class="form-control" name = "name" id="name" value = "${product.name}" placeholder="Enter product name">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Product Description</label>
    <textarea type="text" class="form-control"  name = "description"  id="description" placeholder="Enter the Product Description">${product.description}</textarea>
  </div>
  
  <div class="form-group">
    <label for="formGroupExampleInput2">Product Price</label>
    <input type="text" class="form-control"  name = "price" value = "${product.price}" id="price" placeholder="Enter Product price">
  </div>
  
  <div class="form-group">
  <a href = "${pageContext.request.contextPath}/" class = "btn btn-primary" >Back</a>
  <button type="submit" class="btn btn-primary">update</button>
  </div>
</form>

</div>

</body>
</html>