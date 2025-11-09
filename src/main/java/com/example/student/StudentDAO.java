package com.example.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO
 * -----------
 * Data Access Object class responsible for all CRUD operations on the 'students' table.
 */
public class StudentDAO {

    /**
     * Retrieves and returns all student records from the database.
     */
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT student_id, first_name, last_name, email, enrollment_date FROM students ORDER BY student_id;";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("enrollment_date")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    /**
     * Inserts a new student record into the database.
     */
    public void addStudent(String firstName, String lastName, String email, String enrollmentDate) {
        String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertSQL)) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setDate(4, Date.valueOf(enrollmentDate));
            ps.executeUpdate();

            System.out.println("[INFO] New student added successfully.");

        } catch (SQLException e) {
            System.err.println("[ERROR] Failed to add student: " + e.getMessage());
        }
    }

    /**
     * Updates the email of the student with the given ID.
     */
    public void updateStudentEmail(int studentId, String newEmail) {
        String updateSQL = "UPDATE students SET email = ? WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(updateSQL)) {

            ps.setString(1, newEmail);
            ps.setInt(2, studentId);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("[INFO] Student email updated successfully.");
            } else {
                System.out.println("[WARN] No student found with ID: " + studentId);
            }

        } catch (SQLException e) {
            System.err.println("[ERROR] Failed to update email: " + e.getMessage());
        }
    }

    /**
     * Deletes a student record by ID.
     */
    public void deleteStudent(int studentId) {
        String deleteSQL = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(deleteSQL)) {

            ps.setInt(1, studentId);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("[INFO] Student deleted successfully.");
            } else {
                System.out.println("[WARN] No student found with ID: " + studentId);
            }

        } catch (SQLException e) {
            System.err.println("[ERROR] Failed to delete student: " + e.getMessage());
        }
    }
}
