package com.employee.app.dto;

import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Comparable<Employee>{

    //Attributes
    private Integer id;
    private String name;
    private Double salary;
    private LocalDate doj;

    public Employee(Integer id, String name, Double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(Integer id, String name, Double salary, LocalDate doj) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.doj = doj;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    // Naturally order employees by ids:
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", doj=" + doj + "]";
    }

    @Override
    public int compareTo(Employee e2) {
        return this.getId().compareTo(e2.getId());
    }
}
