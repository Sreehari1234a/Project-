package com.cem.learning.oop;

public class Student extends PlatformUser {
    private final String studentNumber;

    public Student(String userId, String displayName, String studentNumber) {
        super(userId, displayName);
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber() { return studentNumber; }

    @Override
    public String roleName() { return "STUDENT"; }

    @Override
    public String dashboardLabel() { return "My campus events"; }
}
