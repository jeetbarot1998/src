package Lect19_NestedObjectDemo;
public class Lect19_static_non_static_pt2 {
}

class NestedObjectDemo{
//  This is a valid declaration.
    int String;

    int rollNumber;
    String name;

    void read(){
        System.out.println(" The object which is being called from main method " + this);
//      Making a local instance reference variable "s2"
        NestedObjectDemo s2 = new NestedObjectDemo();
        s2.play();
        System.out.println("Student reads");
    }

    void play(){
        System.out.println("Student plays");
    }


    public static void main(String[] args) {
        NestedObjectDemo s = new NestedObjectDemo();
        s.read();
        s.play();
//      Calling static method of another class in the same package
        Teacher.deptName();
//      Unable to call "dept" despite being static because it is private.
//      As the main method is also static in nature, we can call the "main" method of the "Teacher" class
        Teacher.main(null);
    }
}






