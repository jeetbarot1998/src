public class Lect15_AccessSpecifier_Interface_Recap {

}

class Employee15{
    private int empId;
    private String name;

    boolean isContractor;

//    Class level attribute.
    private static String dept = "IT";

//    Constructor overloading
    public Employee15(int empId, String name, boolean isContractor){
        this.empId = empId;
        this.name = name;
        this.isContractor = isContractor;
    }

    public Employee15(){
        ;
    }
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Employee15 emp1 = new Employee15(123,"XYZ", false);
        System.out.println(emp1.empId);
        System.out.println(emp1.name);
        System.out.println(emp1.isContractor);
        System.out.println(emp1.getEmpId());
        System.out.println(emp1.getName());
        Employee15 emp2 = new Employee15(456,"OLM", true);
        System.out.println(emp2.empId);
        System.out.println(emp2.name);
        System.out.println(emp2.isContractor);
        System.out.println(emp2.getEmpId());
        System.out.println(emp2.getName());


    }
}

class Student15{
    private int rollnumber;
    private String name;
    private int marks;

//    You will have to use the keyword "f" to define float variables.
    private static final float pi = 3.14f;
    private static String subject = "Java";

    public static String getSubject() {
//        System.out.println(this); => This gives an error as  static methods are independent of the class and hence
//        you cannot use the keyword “this” to address a certain instance of the class as it is independent of the instance.
        return subject;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        System.out.println(this);
        return marks;
    }

    public int getRollnumber() {
        return rollnumber;
    }

    public Student15(int rollnumber, String name, int marks){
        this.rollnumber = rollnumber;
        this.name = name;
        this.marks = marks;
    }

    public static void main(String[] args) {
        Student15 st1 = new Student15(123, "ABC", 90);
        System.out.println(st1.getName() + " Scored " + st1.getMarks());
        Student15 st2 = new Student15(456, "DEF", 92);
        System.out.println(st2.getName() + " Scored " + st2.getMarks());
        Student15 st3 = new Student15(789, "GHI", 88);
        System.out.println(st3.getName() + " Scored " + st3.getMarks());
        System.out.println(getSubject());
        System.out.println(Student15.getSubject());
    }
}


interface ICalculator {
    float pi = 3.14f;
    int add(int a, int b);
    int subtract(int a,int b);


}

class ChineeseCalculator implements ICalculator{

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        ChineeseCalculator c1 = new ChineeseCalculator();
//        c1.pi = 7 => it is final by default and hence cannot be changed
    }

}


class SportsCar{
    private void goFast(){
        System.out.println("going fast");
    }
    private void doStuff(){
        goFast();
    }
}

class Convertible extends SportsCar{
    private void doThings(){
        SportsCar sc = new SportsCar();
//        sc.doStuff(); => cannot call as it is a private method
    }
    
}



