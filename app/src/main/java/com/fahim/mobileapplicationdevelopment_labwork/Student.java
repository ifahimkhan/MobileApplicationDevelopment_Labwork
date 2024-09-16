package com.fahim.mobileapplicationdevelopment_labwork;

public class Student {
    private String sapNumber;
    private String rollNumber;
    private String studentName;

    public Student(String sapNumber, String rollNumber, String studentName) {
        this.sapNumber = sapNumber;
        this.rollNumber = rollNumber;
        this.studentName = studentName;
    }

    public String getSapNumber() {
        return sapNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }
}
