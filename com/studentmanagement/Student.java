package com.studentmanagement;

public class Student {

    private String name;
    private String address;
    private double GPA;

    // Constructor
    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    // Override default toString method to a formatted string of Student object
    @Override
    public String toString() {
        return "Student [Name: " + name + ", Address: " + address + ", GPA: " + GPA + "]";
    }
}