package controller;

import dao.EmployeeDAO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO dao;

    @Override
    public void init() {
        dao = new EmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {

            case "list":
                listEmployees(request, response);
                break;

            case "delete":
                deleteEmployee(request, response);
                break;

            default:
                listEmployees(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Inside doPost()");	
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addEmployee(request, response);
        } else if ("update".equals(action)) {
            updateEmployee(request, response);
        }
    }

    private void listEmployees(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> employees = dao.getAllEmployees();

        request.setAttribute("employees", employees);

        request.getRequestDispatcher("employee-list.jsp")
                .forward(request, response);
    }

    private void addEmployee(HttpServletRequest request,
                             HttpServletResponse response)
            throws IOException {

        Employee emp = new Employee();

        emp.setId(Integer.parseInt(request.getParameter("id")));
        emp.setName(request.getParameter("name"));
        emp.setEmail(request.getParameter("email"));
        emp.setDepartment(request.getParameter("department"));
        emp.setSalary(Double.parseDouble(request.getParameter("salary")));

        dao.addEmployee(emp);

        response.sendRedirect("employee?action=list");
    }

    private void updateEmployee(HttpServletRequest request,
                                HttpServletResponse response)
            throws IOException {

        Employee emp = new Employee();

        emp.setId(Integer.parseInt(request.getParameter("id")));
        emp.setName(request.getParameter("name"));
        emp.setEmail(request.getParameter("email"));
        emp.setDepartment(request.getParameter("department"));
        emp.setSalary(Double.parseDouble(request.getParameter("salary")));

        dao.updateEmployee(emp);

        response.sendRedirect("employee?action=list");
    }

    private void deleteEmployee(HttpServletRequest request,
                                HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        dao.deleteEmployee(id);

        response.sendRedirect("employee?action=list");
    }
}
