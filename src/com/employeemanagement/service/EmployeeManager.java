package com.employeemanagement.service;

import com.employeemanagement.model.Employee;
import java.io.*;
import java.util.*;

public class EmployeeManager {
    private List<Employee> employees;
    private int nextId;
    private static final String DATA_FILE = "employees.csv";

    public EmployeeManager() {
        employees = new ArrayList<>();
        nextId = 1;
        loadFromFile();
    }

    public void addEmployee(String name, String department, String designation, double salary, String email) {
        Employee emp = new Employee(nextId++, name, department, designation, salary, email);
        employees.add(emp);
        saveToFile();
        System.out.println("Employee added successfully with ID: " + emp.getId());
    }

    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Employee> searchByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }

    public List<Employee> searchByDepartment(String department) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getDepartment().equalsIgnoreCase(department)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean updateEmployee(int id, String name, String department, String designation, double salary, String email) {
        Employee emp = getEmployeeById(id);
        if (emp == null) return false;

        if (name != null && !name.isEmpty()) emp.setName(name);
        if (department != null && !department.isEmpty()) emp.setDepartment(department);
        if (designation != null && !designation.isEmpty()) emp.setDesignation(designation);
        if (salary > 0) emp.setSalary(salary);
        if (email != null && !email.isEmpty()) emp.setEmail(email);

        saveToFile();
        return true;
    }

    public boolean deleteEmployee(int id) {
        boolean removed = employees.removeIf(e -> e.getId() == id);
        if (removed) saveToFile();
        return removed;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        displayTable(employees);
    }

    public void displayTable(List<Employee> list) {
        System.out.println("+------+----------------------+--------------------+----------------------+------------+---------------------------+");
        System.out.println("| ID   | Name                 | Department         | Designation          | Salary     | Email                     |");
        System.out.println("+------+----------------------+--------------------+----------------------+------------+---------------------------+");
        for (Employee e : list) {
            System.out.println(e);
        }
        System.out.println("+------+----------------------+--------------------+----------------------+------------+---------------------------+");
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Employee e : employees) {
                writer.println(e.toFileString());
            }
        } catch (IOException ex) {
            System.out.println("Error saving data: " + ex.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Employee emp = Employee.fromFileString(line);
                    employees.add(emp);
                    if (emp.getId() >= nextId) {
                        nextId = emp.getId() + 1;
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error loading data: " + ex.getMessage());
        }
    }
}
