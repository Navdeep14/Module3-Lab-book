<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<h1>Trainee is Retrieved Successfully</h1>
<table border="1">
    <tr>
      <th>
        Id
        
      </th>
      <th > 
        Name
        </th>
        <th > 
          Domain
          </th>
          <th > 
            Location
            </th>
           
 </tr>
<tr >
    <td>${trainee.traineeId}</td> 
    <td>${trainee.traineeName}</td> 
    <td>${trainee.traineeDomain}</td>
    <td>${trainee.traineeLocation}</td>
  </tr>

 </table>
 <a href="logout">Log-out</a>
<a href="operations">Operations</a>
</body>
</html>