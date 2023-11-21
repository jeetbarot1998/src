package Chap2;

// ================= type casting =================
public class Lect2_7_typecasting {
    public static void main(String[] args) {
        Object o = new String("ABS");
        String s = (String) o;
    }
}


class Base1{}
class Base2{}
class Der1 extends Base1{}
class Der2 extends Base1{}
class Der3 extends Base2{}
class Der4 extends Base2{}

class Test27{
    public static void main(String[] args) {
        Base2 b = new Der4();
        Der4 d = (Der4) b;

//        Base1 b1 = (Base1)b; => Inconvertible types
        Base2 b2 = (Base2) b;
//        Base2 b21 = (Der4) b; => JVM rule issue, cannot store parent in child [ClassCastException]
//        Object ob = (Der3) b; => JVM rule issue [are siblings] [ClassCastException]
//        Base2 b3 = (Base1) b;
    }
}

// ================= Abstraction =================
interface Vehicle{
    void drive();
}

class Car implements Vehicle{
//    IMPLEMENTED METHOD SHOULD ALWAYS BE PUBLIC.
    public void drive(){
        System.out.println("Driving car");
    }
}

class Bus  implements Vehicle{
//    IMPLEMENTED METHOD SHOULD ALWAYS BE PUBLIC.
    public void drive(){
        System.out.println("Driving bus");
    }
}

class Scooter  implements Vehicle{
//    IMPLEMENTED METHOD SHOULD ALWAYS BE PUBLIC.
    public void drive(){
        System.out.println("Driving Scooter");
    }
}

class Test271{
//    Example of loosely coupled code.
    public void callDrive(Vehicle v){
//        abstraction
        System.out.println("Calling from Test271");
        v.drive();
    }

    public static void main(String[] args) {
        Test271 t2 = new Test271();

        Car c = new Car();
        c.drive();

        Bus b = new Bus();
        b.drive();

        Scooter sc = new Scooter();
        sc.drive();

//        Or we can have a common method
//        re-usability
        t2.callDrive(b);
        t2.callDrive(c);
        t2.callDrive(sc);
    }
}

// ================= Encapsulation =================

class Emp27{
    private int salary;
    private String name = "ABS";

    public int getSalary() {
//      validation to show conditionally
        return salary;
    }

    public String getName() {
//      validation to show conditionally
        return name;
    }

    public void setSalary(int salary) {
//      validation to show conditionally
        this.salary = salary;
    }

    public void setName(String name) {
//      validation to show conditionally
        this.name = name;
    }

    public static void main(String ...args) {
        Emp27 e = new Emp27();
        System.out.println(e.getSalary());
        System.out.println(e.name);
    }

}

class Colleague{
    public static void main(String[] args) {
        Emp27 e = new Emp27();
        System.out.println(e.getSalary());
        System.out.println(e.getName());
//        System.out.println(e.name); => encapsulated

    }
}