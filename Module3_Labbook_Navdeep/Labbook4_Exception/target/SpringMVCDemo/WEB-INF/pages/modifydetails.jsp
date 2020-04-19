<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<form method="get" action="processmodify">
<h3>Enter Existing Id and New Information here..</h3>
<label>Id</label>
<div>
<input type="text" name="tid">
</div>
<label>Name</label>
<div>
<input type="text" name="tname">
</div>

<label>Domain</label>
<div>
<input type="text" name="tdomain">
</div>
<label>Location</label>
<div>
<input type="text" name="tlocation">
</div>
<input type="submit" value="Register">

</form>
</body>
</html>
