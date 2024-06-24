# Java Employee Management Application

A simple Java application for managing employees and departments.

## Features

1.  **Department Management:**
    *   View list of departments (No., ID, name, number of employees).
    *   View department details (ID, name, list of employees).
    *   Add department (name, expected number of employees).
    *   Update department information (name).
    *   Delete department.

2.  **Employee Management:**
    *   View list of employees (No., ID, name, age, join date & time, department).
    *   View employee details (ID, name, age, join date & time, department).
    *   Add employee to a department (name, age).
    *   Update employee information (name, age).
    *   Delete employee.

## Constraints

*   Maximum of 5 departments.
*   Maximum of 3 employees per department.

## How to Use

1.  Run `Main.java` to start the application.
2.  Choose options from the menu to perform management operations.

## Project Structure

*   `NhanVien.java`: Class representing an employee.
*   `PhongBan.java`: Class representing a department.
*   `DepartmentManager.java`: Class managing the list of departments and employees.
*   `Main.java`: Class containing the `main()` function to run the application.

## Technologies Used

*   Java
*   java.time (LocalDateTime, DateTimeFormatter)
*   java.util (List, ArrayList, Scanner)

## Author

[Rains]
