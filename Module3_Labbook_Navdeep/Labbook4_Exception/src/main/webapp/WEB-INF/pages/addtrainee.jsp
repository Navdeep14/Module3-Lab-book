<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<h2>Add Trainee</h2>
<form method="get" action="processadd">
<label> ID </label>
<div>
<input type="number" name="traineeid">
</div>

<label>Name</label>
<div>
<input type="text" name="traineename">
</div>

<label>Domain</label>
<div>
<input type="text" name="traineedomain">
</div>

<label>Location</label>
<div>
<input type="text" name="traineelocation">
</div>


<input type="submit" value="Add-Trainee">

</form>
</body>
</html>
