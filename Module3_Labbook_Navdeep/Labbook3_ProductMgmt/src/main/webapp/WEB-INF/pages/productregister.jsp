<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<form method="get" action="processregister">

<label>Product Id</label>
<div>
<input type="number" name="prodId">
</div>
<label>Product Name</label>
<div>
<input type="text" name="prodName">
</div>
<label>Product Price</label>
<div>
<input type="text" name="prodPrice">
</div>

<input type="submit" value="Register">

</form>
</body>
</html>
