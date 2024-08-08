
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
	<h1>Employee Details</h1>
	<c:choose>
    	<c:when test="${test == 'getAll'}">
         	<table>
         		<tr>
	          		<th>Id</th>
    	      		<th>Name</th>
        	  		<th>Salary</th>
         		</tr>
        		<c:forEach var="emp" items="${emplist}">
					<tr>
						<td>${emp.empId}</td>
						<td>${emp.empName}</td>
						<td>${emp.empSal}</td>
					</tr>    
	        	</c:forEach>
        	</table>
		</c:when>
    	<c:otherwise>
        	<td>Id: ${emp.empId}</td>
			<td>Name: ${emp.empName}</td>
			<td>Salary: ${emp.empSal}</td>
    	</c:otherwise>
	</c:choose>
	
	<br><br>
	<form action="<c:url value='/home'/>" method="get">
		<input type="submit" value="Back to Home">
	</form>
</body>
</html>
