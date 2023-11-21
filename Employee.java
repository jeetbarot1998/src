public class Employee {
    private int age = 29;
    private int salary = 60000;
    private String company = "XYZ";

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    public void work(){
        System.out.println("I am working");
    }

    private void play(String name){
        System.out.println(name  + " of company " + this.company + " 'private' is playing");
    }

/**
 * {@code Encapsulation} is a method whereby you can hide data. So you might want the salary of a person to be hidden.
 * But you might not like it to be hidden from everyone. Hence, to apply some logic and allow conditional get or set on
 * the private variable we use public methods such as getters and setters. We cannot have direct logical
 * implementations on an attribute and check who to show it to. But we can apply some kind of layering like
 * “ldap” to check if a user is allowed to view and then allow a user to view the private variable conditionally
 * using a public method.
**/
    public void publicPlay(String name){
        System.out.println(name + " of company " + this.company + " 'public' is playing");
    }

/**
 * A class can have multiple constructors that differ in the number and/or type of their parameters.
 * It's not, however, possible to have two constructors with the exact same parameters
**/
    public Employee(){
// constructor with no params
    }

    public Employee(int sal){
        this.salary = sal;
// constructor with single params
    }


    public static void main(String[] args){
//      instantiate an object of employee class
        Employee e1 = new Employee();
//      possible to call private members of the class as the main class is inside the "employee" class
        e1.play("newobj");
//      calling private members of the class "employee" via an object in same does not give error
        System.out.println("obj1 salary " + e1.salary);
        Employee e2 = new Employee(50000);
        System.out.println("obj2 salary " + e2.salary);

    }

}

