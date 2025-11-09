package com.example.student;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Student Management System ===");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Show all students");
            System.out.println("2. Add a new student");
            System.out.println("3. Update student email");
            System.out.println("4. Delete a student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    List<Student> students = dao.getAllStudents();
                    System.out.println("\n--- All Students ---");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 2:
                    System.out.print("First name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enrollment date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    dao.addStudent(firstName, lastName, email, date);
                    break;

                case 3:
                    System.out.print("Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New email: ");
                    String newEmail = scanner.nextLine();
                    dao.updateStudentEmail(updateId, newEmail);
                    break;

                case 4:
                    System.out.print("Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    dao.deleteStudent(deleteId);
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
