package com.employeemanagement.model;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String designation;
    private double salary;
    private String email;

    public Employee() {}

    public Employee(int id, String name, String department, String designation, double salary, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("| %-4d | %-20s | %-18s | %-20s | %-10.2f | %-25s |",
                id, name, department, designation, salary, email);
    }

    public String toFileString() {
        return id + "," + name + "," + department + "," + designation + "," + salary + "," + email;
    }

    public static Employee fromFileString(String line) {
        String[] parts = line.split(",");
        return new Employee(
            Integer.parseInt(parts[0]),
            parts[1],
            parts[2],
            parts[3],
            Double.parseDouble(parts[4]),
            parts[5]
        );
    }
}
