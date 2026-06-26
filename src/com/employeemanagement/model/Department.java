package com.employeemanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Employee> getEmployees() { return employees; }

    public void addEmployee(Employee emp) { employees.add(emp); }

    public boolean removeEmployee(int employeeId) {
        return employees.removeIf(e -> e.getId() == employeeId);
    }

    public int getEmployeeCount() { return employees.size(); }

    public double getAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }
}
