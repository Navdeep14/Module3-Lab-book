<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<h2>Retrieve Trainee</h2>
<form method="get" action="processretrieve">
<label>please enter Trainee ID </label>
<div>
<input type="number" name="traineeid">
</div>

<input type="submit" value="Retrieve">

</form>
</body>
</html>
