<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Employee Management System</h1>
	<h1>Welcome ${name}</h1><br><br>
	<form action="add" method="post">
		<input type="submit" value="Add Employee">
	</form>
	<br>
	<form action="getAll">
		<input type="submit" value="View All Employee">
	</form>
	<br>
	<form action="selectById">
		<input type="submit" value="View Employee By Id">
	</form>
	<br>
	<form action="update">
		<input type="submit" value="Update Employee">
	</form>
	<br>
	<form action="delete">
		<input type="submit" value="Delete Employee">
	</form>
</body>
</html>
