<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update title here</title>
</head>
<body>
<div align="center">
<form action="Updateservlete" method="post">
<table>
<tr>
<td><h1>UPDATE EMPLOYEE DETAILS</h1></td>
</tr>
<tr>
<td>empid</td>
<td><input type="text"name=id></td>
</tr>
<tr>
<td>empname</td>
<td><input type="text" name=name></td>
</tr>
<tr>
<td>empsalary</td>
<td><input type="text" name=sal></td>
</tr>
<tr>
<td>emploc</td>
<td><input type="text" name=loc></td>
</tr>
<tr>
<td>empexp</td>
<td><input type="text" name=exp></td>
</tr>
</table>
<input type="submit" value="submit">
</form>
</div>
</body>
</html>