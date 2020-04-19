<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<h1>Record of all Customer</h1>
<table border="1">
    <tr>
      <th>
        ProductId
        
      </th>
      <th > 
        Product Name
        </th>
       <th > 
        Product Price
        </th> 
           
 </tr>
 <c:forEach items="${fetch}" var="product">
<tr >
    <td><c:out value="${product.prodId}"/></td> 
    <td><c:out value="${product.prodName}"/></td> 
      <td><c:out value="${product.prodPrice}"/></td> 
    
  </tr>
</c:forEach>
 </table>
 
</body>
</html>