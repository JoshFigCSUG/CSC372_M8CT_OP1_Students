package com.studentmanagement;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            // Use a LinkedList to store student data
            LinkedList<Student> studentList = new LinkedList<>();
            
            // Main loop to continuously get student data
            while (true) {
                System.out.println("Enter student data (or type 'done' to finish):");

                // --- Name Input ---
                System.out.print("Name: ");
                String name = input.nextLine();
                if (name.equalsIgnoreCase("done")) {
                    break; // Exit loop if user enters "done"
                }
                // Validate name input to ensure it's not empty
                while (name.trim().isEmpty()) {
                    System.out.println("Name cannot be empty. Please enter a name.");
                    System.out.print("Name: ");
                    name = input.nextLine();
                }

                // --- Address Input ---
                System.out.print("Address: ");
                String address = input.nextLine();
                if (address.equalsIgnoreCase("done")) {
                    break;// Exit loop if user enters "done"
                }
                // Validate address input to ensure it's not empty
                while (address.trim().isEmpty()) {
                    System.out.println("Address cannot be empty. Please enter an address.");
                    System.out.print("Address: ");
                    address = input.nextLine();
                }

                // --- GPA Input ---
                double gpa = 0;
                String gpaInput;
                // Loop to get valid GPA input
                while (true) {
                    System.out.print("GPA: ");
                    gpaInput = input.nextLine(); 
                    if (gpaInput.equalsIgnoreCase("done")) {
                        break; // Exit loop if user enters "done"
                    }
                    try {
                        gpa = Double.parseDouble(gpaInput);
                        // Validate GPA to be within the range 0-4.0
                        if (gpa >= 0 && gpa <= 4.0) {
                            break; // Valid GPA, exit loop
                        } else {
                            System.out.println("Invalid GPA. Please enter a value between 0 and 4.0.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a numeric value for GPA.");
                    }
                }
                if (gpaInput.equalsIgnoreCase("done")) { 
                    break; // Exit loop if user enters "done"
                }

                // Create a new Student object and add it to the list
                studentList.add(new Student(name, address, gpa));
            }

            // Sort the studentList ascending by name (case-insensitive)
            Collections.sort(studentList, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));

            // Write student data to file with exception handling
            String fileName = "student_data.txt";
            try (FileWriter writer = new FileWriter(fileName)) {
                for (Student student : studentList) {
                    writer.write(student.toString() + "\n");
                }
                System.out.println("Student data written to " + fileName);
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found: " + e.getMessage());
            } catch (SecurityException e) {
                System.err.println("Error: Permission denied to write to file: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
    }
}
