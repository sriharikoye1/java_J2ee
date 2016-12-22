<%@page import="java.util.Iterator"%>
<%@page import="connections.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search title here</title>
</head>
<body>
<div align="center">
<form action="Searchservlet" method="post">
<table>
<tr>
<td><h1>SEARCHID EMPLOYEE DETAILS</h1></td>
</tr>
<tr>
<td>empid</td>
<td><input type="text"name="id">
     <input type="submit" value="View Details By EmpId"><br>
</td>
</tr>
</form>

<form action="Searchsalservlet" method="post">
<tr>
<td><h1>SEARCHSAL EMPLOYEE DETAILS</h1></td>
</tr>
<tr>
<td>empsal</td>
<td><input type="text"name="sal">
      <input type="submit" value="View Details By Empsal"><br>
</td>
</tr>
</form>


<form action="Searchnameservlet" method="post">
<tr>
<td><h1>SEARCHNAME EMPLOYEE DETAILS</h1></td>
</tr>
<tr>
<td>empsname</td>
<td><input type="text"name="name">
      <input type="submit" value="View Details By Empname"><br>
</td>
</tr>
</form>


<%
Object obj=session.getAttribute("employeeList");

if(obj!=null)
{
	%>
	<table ><br>
<tr>
<th>EmployeeId |</th>
<th>EmployeeName |</th>
<th>EmployeeSalary |</th>
<th>EmployeeExp |</th>
<th>EmployeeLocation |</th>
<th>EmployeeLoan |</th>
<th>EmployeeEmi</th>
</tr>
	<%
	ArrayList<Employee> employeeList=(ArrayList)obj;
	Iterator iterator=employeeList.iterator();
	Employee employeebean=null;
	while(iterator.hasNext())
	{
		employeebean=(Employee)iterator.next();
		%>
		<tr>
<td> <%=employeebean.getEmpid() %></td>	
<td> <%=employeebean.getEmpname() %></td>
<td> <%=employeebean.getEmpsal() %></td>
<td><%=employeebean.getEmploc() %></td>
<td><%=employeebean.getEmpexp() %></td>
<td><%=employeebean.getEmploan() %></td>
<td><%=employeebean.getEmpemi() %></td>		
		</tr>
		
	<%	
	}
	session.removeAttribute("employeeList");
	
}
else
	
{
	
	out.print("No Data");
}

%>
</table>

</div>
</body>
</html>