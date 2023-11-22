package Chap2;

// static import
import static java.lang.System.out;

public class Lect2_4_constructor {
}


// ============================ Singleton pattern ============================
class A24{
//    This is a method, not a constructor
    void A24(){

    }
}

class Emp24{
    private int sal;
    private String name;
    private static String dept = "IT";

//    Singleton pattern
    private Emp24() {}

    public void m1(){
        System.out.println("M1");
    }

    public static void main(String[] args) {
        Emp24 e = new Emp24();
        e.m1();
    }
}

// ============================ Instance Initializer Block - Count the number of objects of a class ============================
class ObjectCounter{
    private static int count = 0;

//  Instance Initializer Block:
//  An instance initializer block is used
//  to initialize instance variables of a class.
    {
        count++;
    }
    public ObjectCounter(){
//      The only place from where you can call a constructor is from another
//      constructor. use keyword “this(<argument>)” to call another
//      constructor. Call to 'this()' [another constructor]  must be first
//      statement in constructor body.
        this(10);
//        count++; // => static method increment
        System.out.println("No argument constructor");
        System.out.println("Calling another constructor from a constructor");
    }

    public ObjectCounter(int i){
        this((float)i);
        System.out.println("Inside arg constructor with INT value " + i);
    }

    public ObjectCounter(float f){
        System.out.println("Inside arg constructor with FLOAT value " + f);
    }

    public static int getCount(){
        return count; // => Number of objects created
    }


    public static void main(String[] args) {
        ObjectCounter oc = new ObjectCounter();
        ObjectCounter oc1 = new ObjectCounter(10f);
        ObjectCounter oc2 = new ObjectCounter(10);

        System.out.println(getCount());
    }
}

// ============================ Constructor Example ============================
// =========== Ex 1 ===========
class P{
//    Here it will inject a no argument constructor like
//    P(){ super(); }
}

class C extends P{
//    Here it will inject a no argument constructor like
//    C(){ super(); }
//    This will check if the parent has a no argument constructor and call it. hence,it will work fine.
//    the default constructor injected has the call to super.
}

// =========== Ex 2 ===========
class P2{
    P2(){}
}

class C2 extends P2{
}

// =========== Ex 3 ===========
class P3{
    public int i = 5;
    P3(int i){}
    P3(){}
}

class C3 extends P3{

    public int i =0;
//    Here it will inject a no argument constructor like
//    C(){ super(); }
//    This will check if the parent has a no argument constructor and call it. But as the parent does not
//    have a no argument constructor, so either you add a no argument constructor to the parent.
//    or you invoke the parent constructor with the required parameters from this constructor.
    C3(){
//      We cannot use both super();or this();
//        super(5);
//        this(5);
    }
    C3(int i) {
//      Call to 'super()' must be first statement in constructor body.
        super(i);
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        C3 c = new C3();
        System.out.println(c.i);

    }
}

// ============================ method Overloaded ============================

class Employee24{
    static void method(Integer i){
        System.out.println("Integer");
    }


    static void method(Float i){
        System.out.println("Float");
    }


    static void method(Number i){
        System.out.println("Number");
    }



    static void method(Object o){
        System.out.println("Object");
    }


    public static void main(String[] args) {
        method((short)12); // => as this is a primitive data type it will trigger, "Number".
//      A primitive cannot be stored in Non-primitive type by implicit type casting
//        Integer a = (short) 5; => Invalid.
        Short a = (short) 5;
    }
}

// ============================ Constructor Chaining ============================

class Parent24{

    Parent24(){
//      Compiler will automatically inject super();
        out.println("Parent");
    }
}

class Child24 extends Parent24{
    Child24(){
//      Compiler will automatically inject super();
        System.out.println("Child");
    }

    Child24(int i){
//      Compiler will automatically inject super();
        System.out.println("Child with params");
    }

    public static void main(String[] args) {
        Child24 c = new Child24();
        Child24 c1 = new Child24(5);

    }
}

/// ============================ Static Initializer Block ============================
class Test24{

    static {
        System.out.println("First");
    }

    {
        System.out.println("Instance block");
    }

    public Test24(){
        System.out.println("Default Constructor");
    }

    public static void main(String[] args) {
        System.out.println("hello");
        new Test24();
    }
}


