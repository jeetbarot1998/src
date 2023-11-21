package SJCP.chap_1;

import SJCP.chap_1.food.Fruit;

import java.util.ArrayList;
// using wildcard to import and scan through multiple classes inside a package/file.
import java.util.*;
// Static imports
import static java.lang.System.out;
import static java.lang.Integer.*;

public class chap1 {
}

class MyClass {
    public static void main(String[] args) {
        System.out.println(args[0] + " " + args[1]);
    }
}


class MyClass2 {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
//      another way
        ArrayList<String> a1 = new ArrayList<String>();
        java.util.ArrayList<String> a2 = new java.util.ArrayList<String>();
    }
}

class MyClass3 {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        TreeSet<String> t = new TreeSet<String>();
    }
}

// Static Import
class TestStatic {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toHexString(42));
    }
}

class TestStaticImport {
    public static void main(String[] args) {
        out.println(MAX_VALUE);
        out.println(toHexString(42));
    }
}

// abstract class: works fine as far as we do not make an object of the abstract class.
abstract class Car {
    private double price;
    private String model;
    private String year;
    public abstract void goFast();
    public abstract void goUpHill();
    public abstract void impressNeighbors();

    public static void main(String[] args) {
//        Car x = new Car(); => Won't work as we cannot instantiate object of an abstract class.
    }
}



// exercise 1-1
class Apple extends Fruit {

    @Override
    public void abstractMethod(){
        System.out.println("abstractMethod implemented");
    }

    void newMethod(){
        System.out.println("New method implemented");
    }

    public static void main(String[] args) {
        Fruit n1 = new Apple();
        n1.definedMethod();
//      The below line would work because we have made an object of type
//      "Apple" but saved it in type "Fruit". The "Fruit" type object
//      has the method "abstractMethod" and hence will be referred to the implementation.

        n1.abstractMethod();
//        n1.newMethod() => This will not work as we have saved the
//      instance variable in type of "Fruit" which does not have the method
//      "newMethod". We have saved the "Apple" object inside the type
//      "Fruit", the "n1" has the attribute "newMethod" but due to type it is
//      not possible to access it. If we want to access it we will have to typecast it to
//      "Apple" type and access.
        ((Apple) n1).newMethod();
    }
}


// Access Modifiers

/** Access using reference variable **/
class Zoo {
    public String coolMethod() {
        return "Wow baby";
    }
}
class Moo {
    public void useAZoo() {
        Zoo z = new Zoo();
// If the preceding line compiles Moo has access
// to the Zoo class
// But... does it have access to the coolMethod()?
        System.out.println("A Zoo says, " + z.coolMethod());
// The preceding line works because Moo can access the
// public method
    }

    public static void main(String[] args) {
        Moo m = new Moo();
        m.useAZoo();
    }
}

/** Access using inheritance **/
class Zoo1 {
    public String coolMethod() {
        return "Wow baby";
    }
}
class Moo1 extends Zoo1 {
    public void useMyCoolMethod() {
// Does an instance of Moo inherit the coolMethod()?
        System.out.println("Moo says, " + this.coolMethod());
// The preceding line works because Moo can inherit the
// public method
// Can an instance of Moo invoke coolMethod() on an
// instance of Zoo?
        Zoo z = new Zoo();
        System.out.println("Zoo says, " + z.coolMethod());
// coolMethod() is public, so Moo can invoke it on a Zoo
// reference
    }
    public static void main(String[] args) {
        Moo1 m = new Moo1();
        m.useMyCoolMethod();
    }
}


// Final
class SuperClass{
    public final void showSample() {
        System.out.println("One thing.");
    }
}

class SubClass extends SuperClass{
//    public void showSample() { // Try to override the final superclass method
//        System.out.println("Another thing.");
//    }
    public void getRecord(int fileNumber, final int recNumber) {
//     the "recNumber" variable's value cannot be changed inside the function
////     and cannot be reassigned
//        the variable recNumber is declared as final, which of course
//        means it can't be modified within the method. In this case, "modified" means
//        reassigning a new value to the variable. In other words, a final argument must keep
//        the same value that the parameter had when it was passed into the method
    }
}

// Abstract
// IllegalClass
//public class IllegalClass{
//    public abstract void doIt();
//}

abstract class LegalClass{
    void goodMethod() {
// lots of real implementation code here
    }
}

abstract class Vehicle4 {
    private String type;
    public abstract void goUpHill(); // Abstract method
    public String getType() { // Non-abstract method
        return type;
    }
}
abstract class Car4 extends Vehicle4 {
    public abstract void goUpHill(); // Still abstract
    public void doCarThings() {
// special car code goes here
    }
}
class Mini extends Car4 {
    public void goUpHill() {
// Mini-specific going uphill code
    }
}

abstract class A11 {
    abstract void foo();
}
//class B extends A11 {
//    Class B won't compile because it doesn't implement the inherited abstract
//    method foo(). Although the foo(int I) method in class B might appear to be an
//    implementation of the superclass' abstract method, it is simply an overloaded
//    method (a method using the same identifier, but different arguments), so it doesn't
//    fulfill the requirements for implementing the superclass' abstract method.
//    void foo(int I) { }
//}



// Constructors
class Foo2 {
    // legal constructors
    Foo2() { }
    private Foo2(byte b) { }
    Foo2(int x) { }
    Foo2(int x, int... y) { }
    // illegal constructors
    void Foo() { } // it's a method, not a constructor
//    Foo2() { } // not a method or a constructor
//    Foo2(short s); // looks like an abstract method
//    static Foo2(float f) { } // can't be static
//    final Foo2(long x) { } // can't be final
//    abstract Foo2(char c) { } // can't be abstract
//    Foo2(int... x, int t) { } // bad var-arg syntax
}


// Local variable

class TestServer {
    public void logIn() {
        int count = 10;
    }
    public void doSomething(int i) {
//        count = i; // Won't compile! Can't access count outside method logIn()
    }
}

// shadowing
class TestServer2 {
    int count = 9; // Declare an instance variable named count
    public void logIn() {
        int count = 10; // Declare a local variable named count
        System.out.println("local variable count is " + count);
    }
    public void count() {
        System.out.println("instance variable count is " + count);
    }
    public static void main(String[] args) {
        new TestServer2().logIn();
        new TestServer2().count();
    }
}

class Foo0 {
    final String test;
    int size = 27;

    Foo0(String test) {
        this.test = test; //=> Assigning final variable a value, as we can assign instance final variables value once as
//      Declaring a variable with the final keyword makes it impossible to reassign that
//      variable once it has been initialized with an explicit value (notice we said explicit rather than default).
    }


    public void setSize(int size) {
        size = size; // ??? which size equals which size???
    }
    public void setSize2(int size) {
        this.size = size; // this.size means the current object's instance variable, size. The size on the right is the parameter.
    }

    public void setSize3(int sz) {
        size = sz;
    }

    public static void main(String[] args) {
        Foo0 f0 = new Foo0("test");
        out.println(f0.test);
//        f0.test = "cannot change"; => Invalid as we are trying to change the final type variable.

    }
}

// Enums

enum CoffeeSize2 { BIG, HUGE, OVERWHELMING } // this cannot be
// private or protected
class Coffee {
    CoffeeSize2 size;
}
class CoffeeTest1 {
    public static void main(String[] args) {
        Coffee drink = new Coffee();
        drink.size = CoffeeSize2.BIG; // enum outside class
    }
}

class CoffeeSize {
    public static final CoffeeSize BIG =
            new CoffeeSize("BIG", 0);
    public static final CoffeeSize HUGE =
            new CoffeeSize("HUGE", 1);
    public static final CoffeeSize OVERWHELMING =
            new CoffeeSize("OVERWHELMING", 2);
    CoffeeSize(String enumName, int index) {// stuff here
    }

    public static void main(String[] args) {
        System.out.println(CoffeeSize.BIG);
    }
}

enum CoffeeSize3 {
    // 8, 10 & 16 are passed to the constructor
    BIG(8), HUGE(10), OVERWHELMING(16);
    CoffeeSize3(int ounces) { // constructor
        this.ounces = ounces;
    }
    private int ounces; // an instance variable
    public int getOunces() {
        return ounces;
    }
}
class Coffee2 {
    CoffeeSize3 size; // each instance of Coffee has an enum
    public static void main(String[] args) {
        Coffee2 drink1 = new Coffee2();
        drink1.size = CoffeeSize3.BIG;
        Coffee2 drink2 = new Coffee2();
        drink2.size = CoffeeSize3.OVERWHELMING;
        System.out.println(drink1.size.getOunces()); // prints 8
        for(CoffeeSize3 cs: CoffeeSize3.values())
            System.out.println(cs + " " + cs.getOunces());
    }
}


