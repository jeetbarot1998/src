package com.foo.client;

import com.foo.emp.Student;
import com.foo.prof.Professor;

public class ClientDemo {
    public static void main(String[] args) {
        Student s1 = new Student(80, "London");
        Professor p1 = new Professor("IT", 20000, "PHD");

        System.out.println("getEducationQualification: " + p1.getEducationQualification());
        System.out.println("getDepartment: " + p1.getDepartment());
        System.out.println("student getMarks: " + s1.getMarks());
        System.out.println(args);
    }
}
