package com.example.student;

/**
 * Student class
 * --------------
 * Represents a student entity corresponding to a record in the 'students' table.
 */
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String enrollmentDate;

    public Student(int studentId, String firstName, String lastName, String email, String enrollmentDate) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return String.format("%d | %s %s | %s | %s",
                studentId, firstName, lastName, email, enrollmentDate);
    }
}
