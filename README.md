# Assignment3Q1 - Java PostgreSQL CRUD Application

## Overview
This project is a Java application that connects to a PostgreSQL database and performs basic CRUD (Create, Read, Update, Delete) operations on a `students` table. The program includes an interactive menu for user input.

---

## Database Setup

### 1. Create Database
Using `pgAdmin` or `psql`, create the database:

### 2. Create Table and Insert Initial Data

Switch to the database and execute the schema.sql (db/schema.sql)

### 3. Database Connection Configuration

In the Java program, the database connection is managed by the DatabaseConnection.java class.
You need to configure the connection string, username, and password to match your PostgreSQL setup.

### 3. Compile and Run Instructions
# Compile the project:
mvn compile

# Run the program:
mvn exec:java -Dexec.mainClass="com.example.student.Main"


### Program Features

* Display all students
* Add a new student
* Update a student's email
* Delete a student
* Interactive menu for user input

### Video Demonstration
A short demonstration video is available at: https://youtu.be/Wrj8QqZJmVg

### Notes
* Ensure the PostgreSQL server is running and accessible.
* Update DatabaseConnection.java with your correct username, password, and database URL.
* If your database name contains spaces, use “%20” for URL encoding in JDBC:

