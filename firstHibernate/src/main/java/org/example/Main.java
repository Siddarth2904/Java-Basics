package org.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("Press 1: Create Employee");
            System.out.println("Press 2: Read Employee");
            System.out.println("Press 3: Delete Employee");
            System.out.println("Press 4: Update Employee");
            System.out.println("Press any other number to Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createEmployee();
                case 2 -> readEmployee();
                case 3 -> deleteEmployee();
                case 4 -> updateEmployee();
                default -> {
                    System.out.println("Exiting... Thank you!");
                    return; // Exit the program
                }
            }
        }
    }

    private static void createEmployee() {
        System.out.println("\n--- Create Employee ---");
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter Designation: ");
        String designation = scanner.next();
        System.out.print("Enter Department: ");
        String department = scanner.next();

        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setDesignation(designation);
        employee.setDepartment(department);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(employee);
        transaction.commit();
        session.close();

        System.out.println("Employee created successfully with ID: " + employee.getId());
    }

    private static void readEmployee() {
        System.out.println("\n--- Read Employee ---");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();

        if (employee != null) {
            System.out.println("Employee Details:");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Designation: " + employee.getDesignation());
            System.out.println("Department: " + employee.getDepartment());
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.println("\n--- Delete Employee ---");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);

        if (employee != null) {
            session.remove(employee);
            transaction.commit();
            System.out.println("Employee with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
        session.close();
    }

    private static void updateEmployee() {
        System.out.println("\n--- Update Employee ---");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);

        if (employee != null) {
            System.out.print("Enter New Name: ");
            String name = scanner.next();
            System.out.print("Enter New Salary: ");
            double salary = scanner.nextDouble();
            System.out.print("Enter New Designation: ");
            String designation = scanner.next();
            System.out.print("Enter New Department: ");
            String department = scanner.next();

            employee.setName(name);
            employee.setSalary(salary);
            employee.setDesignation(designation);
            employee.setDepartment(department);

            session.merge(employee);
            transaction.commit();

            System.out.println("Employee with ID " + id + " updated successfully.");
        }
        else {
            System.out.println("Employee with ID " + id+" not found.");
        }
        session.close();
    }
}