<%@ page language="java" import="java.util.*,model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employees</title>
</head>

<body>

<h2>Employee List</h2>

<a href="add-employee.jsp">Add New Employee</a>

<br><br>

<table border="1" cellpadding="8">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Department</th>
    <th>Salary</th>
    <th>Action</th>
</tr>

<%
List<Employee> list = (List<Employee>)request.getAttribute("employees");

if(list != null){

for(Employee emp : list){
%>

<tr>

<td><%= emp.getId() %></td>

<td><%= emp.getName() %></td>

<td><%= emp.getEmail() %></td>

<td><%= emp.getDepartment() %></td>

<td><%= emp.getSalary() %></td>

<td>

<a href="edit-employee.jsp?id=<%=emp.getId()%>
&name=<%=emp.getName()%>
&email=<%=emp.getEmail()%>
&department=<%=emp.getDepartment()%>
&salary=<%=emp.getSalary()%>">

Edit

</a>

|

<a href="employee?action=delete&id=<%=emp.getId()%>"
onclick="return confirm('Delete Employee?')">

Delete

</a>

</td>

</tr>

<%
}
}
%>

</table>

</body>
</html>
