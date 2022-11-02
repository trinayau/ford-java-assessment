package com.employee.app.dao;

import com.employee.app.dto.Employee;

import java.sql.Connection;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private Connection connection;

    public EmployeeServiceImpl(Connection connection) {
        super();
        this.connection = connection;
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {

    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }
}
