public class Lect13_Assessment {
}


class Student {
    private int marks;
    private String address;

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
        Professor p1 = new Professor("CSE", 1000, "Doctorate");
        System.out.println("getEducationQualification: " + p1.getEducationQualification());
        System.out.println("getDepartment: " + p1.getDepartment());

    }
}

class Professor{
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

class ClientDemo {
    public static void main(String[] args) {
        Student s1 = new Student(80, "London");
        Professor p1 = new Professor("IT", 20000, "PHD");

        System.out.println("getEducationQualification: " + p1.getEducationQualification());
        System.out.println("getDepartment: " + p1.getDepartment());
        System.out.println("student getMarks: " + s1.getMarks());
    }
}