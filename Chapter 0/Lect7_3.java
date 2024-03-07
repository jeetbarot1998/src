public class Lect7_3 {
}

class Student2 {

    private int marks;
    private String name;

    private int age;

    public Student2(String name, int age, int marks){
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public int getMarks(){
        return marks;
    }

    public void setMarks(int updatedMarks){
        this.marks = updatedMarks;
    }

    public String getName(){
        return name;
    }

    public void setName(String updatedName){
        this.name = updatedName;
    }

    public static void main(String[] args) {
        Student2 s1 = new Student2("Levar", 35, 76);
        System.out.println(s1.marks);
        System.out.println(s1.getMarks());
        s1.setMarks(90);
        System.out.println(s1.marks);
        System.out.println(s1.getMarks());
    }
}

class Employee4 {
    int id;
    String name;
    int salary;
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    public Employee4(int empId, String name, int salary) {
        this.id = empId;
        this.name = name;
        this.salary = salary;
    }

    public static void main(String arg[ ] ) {
        Employee4 emp1 = new Employee4(1,"Peter",4000); // Line 1
        // At this line attributes of employee object emp1 object gets initialised with id as 1, name as Peter.
        // After the attributes are initialised , if you have the need to change the value of the attribute you can use setters.
        System.out.println(emp1.salary );
        // This will print 4000 But if Peter gets an appraisal and his salary needs to be revised then we can use a special kind
        // of method called setter to set/update the salary
        emp1.setSalary(7000); // This will now update the salary from 4000 to 7000.
        // Just to make sure that salary is updated /revised you would like to read //the updated salary..
        // There are two ways to read the salary attribute..
        System.out.println(emp1.salary); //1st way
        System.out.println(emp1.getSalary()); //2nd  way
    }

}