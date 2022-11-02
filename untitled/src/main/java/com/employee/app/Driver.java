package com.employee.app;

import com.employee.app.dao.EmployeeUtility;
import com.employee.app.dao.EmployeeService;
import com.employee.app.dao.EmployeeServiceImpl;
import com.employee.app.dto.Employee;

public class Driver {
    public static void main(String[] args) {
        // Create DAO using MySql
        EmployeeService employeeService = new EmployeeServiceImpl(EmployeeUtility.getConnectionToMySQL());

        //Add Employee


    }
}