# Employee Management System

A console-based Employee Management System built in Java demonstrating core OOP principles — encapsulation, inheritance, polymorphism, and abstraction.

## Features

- **Employee CRUD**: Add, view, update, and delete employee records
- **Department Management**: Organize employees by departments
- **Salary Management**: Track salary details and payroll
- **Search & Filter**: Find employees by name or department
- **Data Persistence**: CSV file-based storage

## Technologies Used

- **Language**: Java
- **Concepts**: OOP (Encapsulation, Inheritance, Polymorphism, Abstraction)
- **Data Storage**: CSV file persistence
- **Build**: Manual compilation (javac)

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- Any Java IDE or terminal

### Running

```bash
# Compile
javac -d out src/com/employeemanagement/model/*.java src/com/employeemanagement/service/*.java src/com/employeemanagement/ui/*.java

# Run
java -cp out com.employeemanagement.ui.Main
```

Or open the project in IntelliJ/Eclipse/VS Code and run `Main.java`.

## Project Structure

```
src/
└── com/
    └── employeemanagement/
        ├── model/
        │   ├── Employee.java         # Employee entity with validation
        │   └── Department.java       # Department entity
        ├── service/
        │   └── EmployeeManager.java  # CRUD logic + file persistence
        └── ui/
            └── Main.java             # Console user interface
```

## OOP Concepts Demonstrated

| Concept | Implementation |
|---|---|
| Encapsulation | Private fields with getter/setter methods |
| Abstraction | Clean API surface via EmployeeManager |
| Inheritance | (Extensible for specialized employee types) |
| Polymorphism | Stream-based operations, method overloading |
| File I/O | CSV read/write for data persistence |

## What I Learned

- Implementing OOP principles in a real-world application
- Designing modular and maintainable code structure
- Handling file I/O for data persistence
- Building a complete CRUD workflow with input validation
- Clean separation of concerns (model/service/ui)

## Author

**Nazeer Ahmed** — [LinkedIn](https://linkedin.com/in/nazeer-ahmed-971382327/)

## License

MIT
