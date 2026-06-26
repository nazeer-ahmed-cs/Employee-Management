package com.employeemanagement.ui;

import com.employeemanagement.service.EmployeeManager;
import java.util.Scanner;

public class Main {
    private static final EmployeeManager manager = new EmployeeManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   Employee Management System");
        System.out.println("========================================");

        int choice;
        do {
            showMenu();
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewAllEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static void showMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");
    }

    private static void addEmployee() {
        System.out.println("\n--- Add New Employee ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter department: ");
        String dept = scanner.nextLine();
        System.out.print("Enter designation: ");
        String designation = scanner.nextLine();
        double salary = getDoubleInput("Enter salary: ");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        manager.addEmployee(name, dept, designation, salary, email);
    }

    private static void viewAllEmployees() {
        System.out.println("\n--- All Employees ---");
        manager.displayAllEmployees();
    }

    private static void searchEmployee() {
        System.out.println("\n--- Search Employee ---");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Department");
        int choice = getIntInput("Choose: ");

        switch (choice) {
            case 1 -> {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                manager.displayTable(manager.searchByName(name));
            }
            case 2 -> {
                System.out.print("Enter department: ");
                String dept = scanner.nextLine();
                manager.displayTable(manager.searchByDepartment(dept));
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void updateEmployee() {
        System.out.println("\n--- Update Employee ---");
        int id = getIntInput("Enter employee ID to update: ");

        if (manager.getEmployeeById(id) == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Enter new name (or press Enter to skip): ");
        String name = scanner.nextLine();
        System.out.print("Enter new department (or press Enter to skip): ");
        String dept = scanner.nextLine();
        System.out.print("Enter new designation (or press Enter to skip): ");
        String designation = scanner.nextLine();
        System.out.print("Enter new salary (or 0 to skip): ");
        double salary = getDoubleInput("");
        System.out.print("Enter new email (or press Enter to skip): ");
        String email = scanner.nextLine();

        boolean updated = manager.updateEmployee(id,
            name.isEmpty() ? null : name,
            dept.isEmpty() ? null : dept,
            designation.isEmpty() ? null : designation,
            salary,
            email.isEmpty() ? null : email);

        System.out.println(updated ? "Employee updated successfully." : "Update failed.");
    }

    private static void deleteEmployee() {
        System.out.println("\n--- Delete Employee ---");
        int id = getIntInput("Enter employee ID to delete: ");
        boolean deleted = manager.deleteEmployee(id);
        System.out.println(deleted ? "Employee deleted successfully." : "Employee not found.");
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}
