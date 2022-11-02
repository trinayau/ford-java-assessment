package com.employee.app;

import com.employee.app.dao.EmployeeUtility;
import com.employee.app.dao.EmployeeService;
import com.employee.app.dao.EmployeeServiceImpl;
import com.employee.app.dto.Employee;

import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
        // Create DAO using MySql
        EmployeeService employeeService = new EmployeeServiceImpl(EmployeeUtility.getConnectionToMySQL());

//         Add Employee
        employeeService.addEmployee(new Employee(1, "Patrick", 25000.0));
        employeeService.addEmployee(new Employee(2, "Idris", 35000.0));
        employeeService.addEmployee(new Employee(3, "Trina", 15000.0));

        // Find Employee
        Employee foundEmployee = employeeService.getEmployeeById(1);
        System.out.println(foundEmployee);

        // Update Employee
        Employee updateEmployee = new Employee(1, "Pat", 300.00);
        try {
            employeeService.updateEmployee(updateEmployee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Delete Employee using ID
        employeeService.deleteEmployeeById(2);

        //List all employees
        System.out.println(employeeService.getAllEmployees());
    }
}