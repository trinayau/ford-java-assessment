package com.employee.app.dao;
import java.util.List;
import java.util.Optional;
import com.employee.app.dto.Employee;

public interface EmployeeService {
    // CRUD
    void addEmployee(Employee employee);
    Employee getEmployeeById(Integer employeeId);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(Integer employeeId);
    List<Employee> getAllEmployees();

}
