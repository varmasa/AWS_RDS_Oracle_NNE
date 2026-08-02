<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>

<body>

<h2>Add Employee</h2>

<form action="employee" method="post">

    <input type="hidden" name="action" value="add"/>

    <table>

        <tr>
            <td>ID</td>
            <td><input type="number" name="id" required></td>
        </tr>

        <tr>
            <td>Name</td>
            <td><input type="text" name="name" required></td>
        </tr>

        <tr>
            <td>Email</td>
            <td><input type="email" name="email" required></td>
        </tr>

        <tr>
            <td>Department</td>
            <td><input type="text" name="department" required></td>
        </tr>

        <tr>
            <td>Salary</td>
            <td><input type="number" step="0.01" name="salary" required></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Save Employee">
            </td>
        </tr>

    </table>

</form>

<br>

<a href="employee?action=list">View Employees</a>

</body>
</html>
