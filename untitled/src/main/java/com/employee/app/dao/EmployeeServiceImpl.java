package com.employee.app.dao;

import com.employee.app.dto.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private Connection connection;

    public EmployeeServiceImpl(Connection connection) {
        super();
        this.connection = connection;
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (id,name,salary) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setDouble(3, employee.getSalary());
            System.out.println(preparedStatement);
            Integer count = preparedStatement.executeUpdate();
            if (count == 1)
                System.out.println("Employee added successfully to DB.");
            else
                System.out.println("Employee could not be added to DB.");

        } catch (SQLException e) {
            System.out.println("Could not add employee to DB.");
        }

    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        String sql = "SELECT * FROM employee WHERE id = ?";

        Employee newEmployee = null; // return null if emp does not exists for id
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // if employee exists for given id

                // Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3));
                newEmployee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getDouble("salary"));

            }
        } catch (SQLException e) {
            System.out.println("Could not find employee in DB " + e);
        }
        System.out.println("Employee found:");
        return newEmployee;
    }

    @Override
    public void updateEmployee(Employee employee){
        String sql = "UPDATE employee set name = ? , salary= ? WHERE id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setInt(3, employee.getId());
            Integer count = preparedStatement.executeUpdate();
            if(count == 1)
                System.out.println("Employee updated: " + employee);
            else
                System.out.println("Employee could not be updated.");

        } catch (SQLException ex) {
            System.out.println("Unable to update record: " + ex);
        }
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        String sql = "DELETE FROM employee WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);
            Integer count = preparedStatement.executeUpdate();

            if (count == 1) {
                System.out.println("Employee deleted successfully with id:" + employeeId);
            } else
                System.out.println("Employee could not be deleted with id:" + employeeId);

        } catch (SQLException e) {
            System.out.println("Could not delete this employee with id: " + employeeId);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> returnValue = new ArrayList<>();
        String sql = "SELECT id, name, salary FROM employee";

       try(Statement statement = connection.createStatement()){
           try(ResultSet resultSet = statement.executeQuery(sql)){
               while(resultSet.next()){
                   returnValue.add(new Employee(resultSet));
               }

           }

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
        System.out.println("List of employees:");
        return returnValue;

    }
}
