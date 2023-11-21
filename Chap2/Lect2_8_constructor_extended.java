package Chap2;

public class Lect2_8_constructor_extended {
}

class Demo{
    private static String name = "ABC";
    private int x = 5;
    public void show(){
        System.out.println(this);
        System.out.println("Showing");
        System.out.println(this.name);
        tell();
    }

    public void tell(){
        System.out.println("Telling");
        System.out.println(x);
        int x = 7;
//        Shadowing.
        System.out.println(x);
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        d.show();
        d.tell();
    }
}

// =============== Constructor Example  ===============
class A11{
    int i = 5;

    A11(){
//        Before calling of "super()" method, the values are still the default values based
//        on their data types (e.g., 0 for numeric types, false for boolean, null for objects).
//        But as the constructor inject the "super()" call automatically, once the parents constructor
//        call is over the default values are assigned.
        System.out.println(i);
//        This will call the method of B11 as we are making an object of B11 and the method has been over-ridden.
        this.print();
    }


    void print(){
        System.out.println("A11");
    }
}

class B11 extends A11{
    int i = 4;

    void print(){
//        Over-riding the method.
        System.out.println(i);
    }

    B11(){
//        Before calling of "super()" method, the values are still the default values based
//        on their data types (e.g., 0 for numeric types, false for boolean, null for objects).
//        But as the constructor inject the "super()" call automatically, once the parents constructor
//        call is over the default values are assigned.
        System.out.println("B11 "+ i);
    }
//    instance variables (non-static fields) are instantiated as part of the object's creation process,
//    before the constructor is invoked. When an object is created using the new keyword, memory
//    is allocated for the object, and all its instance variables are given default values based
//    on their data types (e.g., 0 for numeric types, false for boolean, null for objects).

//    After the memory allocation and default initialization of instance variables, the constructor is
//    called to perform any additional initialization or setup. The constructor can reassign values to the
//    instance variables or perform any other required operations specific to the object being created.

    public static void main(String[] args) {
//        before the line below, instance variable has not been initialized, hence "i" is 0;
        A11 a = new B11();
//        the instance variable i is declared and set to 4, but before the constructor of B11 completes
//        its initialization (and before "i" is set to 4), the overridden print() method in B11 is executed
//        as a part of the constructor of A11. At this point, "i" hasn't been initialized in B11, so its
//        default value, which is 0 for an int, is printed.
//        After initializing the value of "i" is 4
        a.print();
    }
}

