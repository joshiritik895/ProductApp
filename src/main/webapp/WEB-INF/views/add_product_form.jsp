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
<h1 class = "text-center">Fill the product detail</h1>
<form action  = "handle-product" method  = "post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="formGroupExampleInput">Product Name</label>
    <input type="text" class="form-control" name = "name" id="name" placeholder="Enter product name">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Product Description</label>
    <textarea type="text" class="form-control"  name = "description"  id="description" placeholder="Enter the Product Description"></textarea>
  </div>
  
  <div class="form-group">
    <label for="formGroupExampleInput2">Product Price</label>
    <input type="text" class="form-control"  name = "price"  id="price" placeholder="Enter Product price">
  </div>
  
  <div class="form-group">
    <label for="formGroupExampleInput2">Product file </label>
    <input type="file" class="form-control-file" name = "file" id="exampleFormControlFile1">
  </div>
  
  <div class="form-group">
  <a href = "${pageContext.request.contextPath}/" class = "btn btn-primary" >Back</a>
  <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>

</div>

</body>
</html>