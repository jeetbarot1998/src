package com.foo.emp;
import com.foo.prof.Professor;
public class Student {
    private int marks;
    private String address;
    public static final String a = "Test";
    public Student(int marks,String address){
        this.marks = marks;
        this.address = address;
    }

    public int getMarks() {
        return marks;
    }

    private String getAddress() {
        return address;
    }

    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(Student.a);
        Professor p1 = new Professor("CSE", 1000, "Doctorate");
        System.out.println("getEducationQualification: " + p1.getEducationQualification());
        System.out.println("getDepartment: " + p1.getDepartment());
    }
}
