package dao;

import model.Employee;

import java.util.List;

public class TestDAO {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();

        // Insert
        Employee emp = new Employee(
                3,
                "David",
                "david@test.com",
                "Finance",
                70000
        );

        boolean saved = dao.addEmployee(emp);

        System.out.println("Inserted : " + saved);

        // Read
        List<Employee> employees = dao.getAllEmployees();

        for (Employee e : employees) {

            System.out.println(
                    e.getId() + " " +
                    e.getName() + " " +
                    e.getDepartment() + " " +
                    e.getSalary()
            );
        }
    }
}
