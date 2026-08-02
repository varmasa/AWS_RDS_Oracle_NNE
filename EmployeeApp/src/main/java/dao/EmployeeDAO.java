package dao;

import model.Employee;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Add Employee
    public boolean addEmployee(Employee employee) {

        String sql = "INSERT INTO EMPLOYEE(ID, NAME, EMAIL, DEPARTMENT, SALARY) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getDepartment());
            ps.setDouble(5, employee.getSalary());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {

        List<Employee> list = new ArrayList<>();

        String sql = "SELECT * FROM EMPLOYEE ORDER BY ID";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Employee emp = new Employee();

                emp.setId(rs.getInt("ID"));
                emp.setName(rs.getString("NAME"));
                emp.setEmail(rs.getString("EMAIL"));
                emp.setDepartment(rs.getString("DEPARTMENT"));
                emp.setSalary(rs.getDouble("SALARY"));

                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Get Employee by ID
    public Employee getEmployeeById(int id) {

        String sql = "SELECT * FROM EMPLOYEE WHERE ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Employee emp = new Employee();

                emp.setId(rs.getInt("ID"));
                emp.setName(rs.getString("NAME"));
                emp.setEmail(rs.getString("EMAIL"));
                emp.setDepartment(rs.getString("DEPARTMENT"));
                emp.setSalary(rs.getDouble("SALARY"));

                return emp;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Update Employee
    public boolean updateEmployee(Employee employee) {

        String sql = "UPDATE EMPLOYEE SET NAME=?, EMAIL=?, DEPARTMENT=?, SALARY=? WHERE ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());
            ps.setInt(5, employee.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete Employee
    public boolean deleteEmployee(int id) {

        String sql = "DELETE FROM EMPLOYEE WHERE ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
