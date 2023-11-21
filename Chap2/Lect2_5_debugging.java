package Chap2;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lect2_5_debugging {
}

class DebugDemo{

    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        double sum = 0;
        for(int i=0; i<3; i++){
            System.out.println("Enetr a number");
            sum += sc.nextDouble();
        }

        double avg = sum/3;
        System.out.println("Avg is " + avg);
    }

}

class StudentDebugDemo{

    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(new Student("ABC", 20),
                new Student("DEF", 30), new Student("XYZ", 40));
        double sum = 0;
        for (Student each_student: studentList){
            System.out.println(each_student.getMarks() + " " + each_student.getName());
            sum += each_student.getMarks();

        }
    }
}

class Student{
//    list is an interface in Java.
//    Array list implements this list and hence we can save the object of array list in type list
    private String name;
    private int marks;

    public Student(String name, int marks){
        this.marks = marks;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

// ====================== private constructor ===============================
// We cannot have a private constructor if you want to extend it.
// You have to create an available (protected, public or default) super constructor to be able to extend.
class Parent25{
    private Parent25(){}

    public static Parent25 makeObject() {
        return new Parent25();
    }
}

// We cannot call the super(); as the parent does not have a public constructor.
//class Child25 extends Parent25{
//    Child25(){
//        super.makeObject();
//        Parent25.makeObject();

//    }
//}


