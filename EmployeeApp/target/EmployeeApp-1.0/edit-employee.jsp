<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>
<title>Edit Employee</title>
</head>

<body>

<h2>Edit Employee</h2>

<form action="employee" method="post">

<input type="hidden" name="action" value="update">

<table>

<tr>
<td>ID</td>
<td>
<input type="number"
name="id"
value="<%=request.getParameter("id")%>"
readonly>
</td>
</tr>

<tr>
<td>Name</td>
<td>
<input type="text"
name="name"
value="<%=request.getParameter("name")%>">
</td>
</tr>

<tr>
<td>Email</td>
<td>
<input type="email"
name="email"
value="<%=request.getParameter("email")%>">
</td>
</tr>

<tr>
<td>Department</td>
<td>
<input type="text"
name="department"
value="<%=request.getParameter("department")%>">
</td>
</tr>

<tr>
<td>Salary</td>
<td>
<input type="number"
step="0.01"
name="salary"
value="<%=request.getParameter("salary")%>">
</td>
</tr>

<tr>
<td colspan="2">

<input type="submit" value="Update Employee">

</td>
</tr>

</table>

</form>

</body>
</html>
