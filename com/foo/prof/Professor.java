package com.foo.prof;
import com.foo.emp.Student;
public class Professor {
    private String department;
    private int salary;
    private String educationQualification;
    public Professor(String dept,int sal, String qual){
        this.department = dept;
        this.salary = sal;
        this.educationQualification = qual;
    }
    public String getDepartment() {
        return department;
    }

    private int getSalary() {
        return salary;
    }
    public String getEducationQualification() {
        return educationQualification;
    }
    public static void main(String[] args) {
        Student s1 = new Student(78, "Mumbai");
        System.out.println("getMarks: " + s1.getMarks());
    }
}
