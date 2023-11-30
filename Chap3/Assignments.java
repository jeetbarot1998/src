package Chap3;

import java.awt.*;
import java.util.Date;

public class Assignments {
}
class Collar { }

class Dog3 {
    Collar c; // instance variable
    String name; // instance variable

    public static void main(String[] args) {
        Dog3 d; // local variable: d
        d = new Dog3();
        d.go(d);
    }

    void go(Dog3 dog) { // local variable: dog
        c = new Collar();
        dog.setName("Aiko");
    }

    void setName(String dogName) { // local variable: dogName
        name = dogName;
        // do more stuff
    }
}

class Test3A{
    public static void main(String[] args) {
        int pre7 = 1000000; // pre Java 7 – we hope it's a million
        int with7 = 1_000_000; // much clearer!
//        int i1 = _1_000_000; // illegal, can't begin with an "_"
        int i2 = 10_0000_0; // legal, but confusing
        int length = 343;

//        Binary Literals
        int b1 = 0B101010; // set b1 to binary 101010 (decimal 42)
        int b2 = 0b00011; // set b2 to binary 11 (decimal 3)

//        Octal Literals
        int six = 06; // Equal to decimal 6
        int seven = 07; // Equal to decimal 7
        int eight = 010; // Equal to decimal 8
        int nine = 011; // Equal to decimal 9

//        Hexadecimal Literals
        int x = 0X0001;
        int y = 0x7fffffff;
        int z = 0xDeadCafe;

        long jo = 110599L;
        long so = 0xFFFFl; // Note the lowercase 'l'

//        Floating-point Literals
        double d = 11301874.9881024;
//        float f = 23.467890; // Compiler error, possible loss of precision
        float g = 49837849.029847F; // OK; has the suffix "F"
        double d1 = 110599.995011D; // Optional, not required
        double g1 = 987.897; // No 'D' suffix, but OK because the literal is a double by default
//        int x = 25,343; // Won't compile because of the comma

//        Boolean Literals
        boolean t = true; // Legal
//        boolean f = 0; // Compiler error!
//    Look out for such
//        int x = 1; if (x) { } // Compiler error!

//        Character Literals [ unsigned 16-bit range (0 to 65535) ]
        char a = 'a';
        char b = '@';
        char a1 = 0x892; // hexadecimal literal
        char b3 = 982; // int literal
        char c = (char)70000; // The cast is required; 70000 is out of char range
        char d2 = (char) -98; // Ridiculous, but legal
//        char e2 = -29; // Possible loss of precision; needs a cast
//        char f2 = 70000; // Possible loss of precision; needs a cast

    }
}


class Test3B{
    public static void main(String[] args) {
//        Primitive
        int x = 7; // literal assignment
        int y = x + 2; // assignment with an expression (including a literal)
        int z = x * y; // assignment with an expression
        byte b = 27;
//        implicitly does
        byte b1 = (byte) 27; // Explicitly cast the int literal to a byte
        byte a = 3; // No problem, 3 fits in a byte
        byte b2 = 8; // No problem, 8 fits in a byte
//        byte c = a + b2;

//        declaring multiple variables at a time
        int a1, b4, c;
        int j, k=1, l, m=3;
        int j2;
        int k2=1;
        int l2;
        int m2=3;
        int j3, k3=1, l3, m3=k3+3; // legal: k is initialized before m uses it
//        int j, k=m+3, l, m=1; // illegal: m is not initialized before k uses it
//        int x, y=x+1, z; // illegal: x is not initialized before y uses it
    }
}

class Test3C{
    public static void main(String[] args) {
        int a = 100;
        long b = a; // Implicit cast, an int value always fits in a long
        float af = 100.001f;
        int bf = (int)a; // Explicit cast, the float could lose info
        double d = 100L; // Implicit cast
    }
}

class Casting {
    public static void main(String [] args) {
//        int x = 3957.229; // illegal: Incompatible type for declaration. Explicit cast
//        needed to convert double to int.
        int x = (int)3957.229; // legal cast
        System.out.println("int x = " + x);
        int x1 = 3957;
        long l = 56L;
        byte b = (byte)l;
        System.out.println("The byte is " + b);
    }
}

class Casting1 {
    public static void main(String [] args) {
        long l = 130L;
        byte b = (byte)l;
        System.out.println("The byte is " + b);
//        byte a1 = 128; // byte can only hold up to 127
        byte b1 = 3;
        b1 += 7; // No problem - adds 7 to b (result is 10) and it is equivalent to this:
        byte b2 = 3;
        b2 = (byte) (b2 + 7); // Won't compile without the cast, since b + 7 results in an in
    }
}

class ValueTest {
    public static void main (String [] args) {
        int a = 10; // Assign a value to a
        System.out.println("a = " + a);
        int b = a;
        b = 30;
        System.out.println("a = " + a + " after change to b");
    }
}


class Foo3 {
    public void doFooStuff() { }
}
class Bar3 extends Foo3 {
    public void doBarStuff() { }
}
class Test4 {
    public static void main (String [] args) {
        Foo3 reallyABar = new Bar3(); // Legal because Bar is a subclass of Foo
//        Bar3 reallyAFoo = new Foo3(); // Illegal! Foo is not a subclass of Bar
    }
}


class Layout { // class
    static int s = 343; // static variable
    int x; // instance variable
    { x = 7; int x2 = 5; } // initialization block
    Layout() { x += 8; int x3 = 6;} // constructor
    void doStuff() { // method
        int y = 0; // local variable
        for(int z = 0; z < 4; z++) { // 'for' code block
            y += z + x;
        }
    }
}
// s is a static variable.
// x is an instance variable.
// y is a local variable (sometimes called a "method local" variable).
// z is a block variable.
// x2 is an init block variable, a flavor of local variable.
// x3 is a constructor variable, a flavor of local variable.

class ScopeErrors {
    int x = 5;
    public static void main(String[] args) {
//        x++; // won't compile, x is an 'instance' variable
    }
}

class ScopeErrors2 {
    public static void main(String [] args) {
        ScopeErrors2 s = new ScopeErrors2();
        s.go();
    }
    void go() {
        int y = 5;
        go2();
        y++; // once go2() completes, y is back in scope
    }
    void go2() {
//        y++; // won't compile, y is local to go()
    }
    void go3() {
        for(int z = 0; z < 5; z++) {
            boolean test = false;
            if(z == 3) {
                test = true;
                break;
            }
        }
//        System.out.print(test); // 'test' is an ex-variable,
// it has ceased to be...
    }
}

//Primitive Instance Variables
class BirthDate {
    int year; // Instance variable

    public static void main(String[] args) {
        BirthDate bd = new BirthDate();
        bd.showYear();
    }

    public void showYear() {
        System.out.println("The year is " + year);
    }
}

//Object Reference Instance Variables
class Book3 {
    private String title; // instance reference variable
    public String getTitle() {
        return title;
    }
    public static void main(String [] args) {
        Book3 b = new Book3();
        System.out.println("The title is " + b.getTitle());
        String s = b.getTitle(); // Compiles and runs
        String t = s.toLowerCase(); // Runtime Exception!
        if (s != null) {
            String t1 = s.toLowerCase();
        }
    }
}


//Array Instance Variables
class BirthDays {
    static int [] year = new int[100];
    public static void main(String [] args) {
        for(int i=0;i<100;i++)
            System.out.println("year[" + i + "] = " + year[i]);
    }
}


//Local Primitives
class TimeTravel {
    public static void main(String [] args) {
        int year; // Declared but not initialized
        int day; // Declared but not initialized
        System.out.println("You step into the portal.");
        year = 2050; // Initialize (assign an explicit value)
        System.out.println("Welcome to the year " + year);
    }
}

class TestLocal {
    public static void main(String [] args) {
        int x;
        if (args[0] != null) { // assume you know this is true
            x = 7; // compiler can't tell that this
// statement will run
        }
//        int y = x; // the compiler will choke here => variable x might not have been initialized
    }
}



//    Local Object References
class TimeTravel3 {
    public static void main(String [] args) {
        Date date;
//        Instance variable references are always given a default value of null, until they
//        are explicitly initialized to something else. But local references are not given a
//        default value; in other words, they aren't null.
//        if (date == null)
//            System.out.println("date is null");
    }
}


class ReferenceTest2 {
    public static void main (String [] args) {
        Dimension a1 = new Dimension(5,10);
        System.out.println("a1.height = " + a1.height);
        Dimension b1 = a1;
        b1.height = 30;
        System.out.println("a1.height = " + a1.height +
                " after change to b");
    }
}


class StringTest {
    public static void main(String [] args) {
        String x = "Java"; // Assign a value to x
        String y = x; // Now y and x refer to the same String object
        System.out.println("y string = " + y);
        x = x + " Bean"; // Now modify the object using the x reference
        System.out.println("y string = " + y);
    }
}

class ReferenceTest4 {
    public static void main (String [] args) {
        Dimension d = new Dimension(5,10);
        ReferenceTest4 rt = new ReferenceTest4();
        System.out.println("Before modify() d.height = " + d.height);
        rt.modify(d);
        System.out.println("After modify() d.height = " + d.height);
    }

    void modify(Dimension dim) {
        dim.height = dim.height + 1;
        System.out.println("dim = " + dim.height);
    }
}

class ReferenceTest5 {
    public static void main (String [] args) {
        int a = 1;
        ReferenceTest5 rt = new ReferenceTest5();
        System.out.println("Before modify() a = " + a);
        rt.modify(a);
        System.out.println("After modify() a = " + a);
    }
    void modify(int number) {
        number = number + 1;
        System.out.println("number = " + number);
    }
}


class FooA {
    static int size = 7;
    static void changeIt(int size) {
        size = size + 200;
        System.out.println("size in changeIt is " + size);
    }
    public static void main (String [] args) {
        FooA f = new FooA();
        System.out.println("size = " + size);
        changeIt(size);
        System.out.println("size after changeIt is " + size);
    }
}

class BarA {
    int barNum = 28;
}
class FooB {
    BarA myBar = new BarA();
    void changeIt(BarA myBar) {
        myBar.barNum = 99;
        System.out.println("myBar.barNum in changeIt is " + myBar.barNum);
        myBar = new BarA();
        myBar.barNum = 420;
        System.out.println("myBar.barNum in changeIt is now " + myBar.barNum);
    }
    public static void main (String [] args) {
        FooB f = new FooB();
        System.out.println("f.myBar.barNum is " + f.myBar.barNum);
        f.changeIt(f.myBar);
        System.out.println("f.myBar.barNum after changeIt is "
                + f.myBar.barNum);
    }
}


class GarbageTruck {
    public static void main(String [] args) {
        StringBuffer sb = new StringBuffer("hello");
        System.out.println(sb);
        // The StringBuffer object is not eligible for collection
        sb = null;
        // Now the StringBuffer object is eligible for collection
    }
}

class Nulling {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello");
        System.out.println(sb);
        // The StringBuffer object is not eligible for collection
        sb = null;
        // Now the StringBuffer object is eligible for collection
    }
}

class Reassigning {
    public static void main(String [] args) {
        StringBuffer s1 = new StringBuffer("hello");
        StringBuffer s2 = new StringBuffer("goodbye");
        System.out.println(s1);
// At this point the StringBuffer "hello" is not eligible
        s1 = s2; // Redirects s1 to refer to the "goodbye" object
// Now the StringBuffer "hello" is eligible for collection
    }
}

class Island {
    Island i;
    public static void main(String [] args) {
        Island i2 = new Island();
        Island i3 = new Island();
        Island i4 = new Island();
        i2.i = i3; // i2 refers to i3
        i3.i = i4; // i3 refers to i4
        i4.i = i2; // i4 refers to i2
        i2 = null;
        i3 = null;
        i4 = null;
// do complicated, memory intensive stuff
    }
}

class CheckGC {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total JVM memory: " + rt.totalMemory());
        System.out.println("Before Memory = " + rt.freeMemory());
        Date d = null;
        for (int i = 0; i < 10000; i++) {
            d = new Date();
            d = null;
        }
        System.out.println("After Memory = " + rt.freeMemory());
        rt.gc(); // an alternate to System.gc()
        System.out.println("After GC Memory = " + rt.freeMemory());

    }
}


class Ouch {
static int ouch = 7;
    public static void main(String[] args) {
        new Ouch().go(ouch);
        System.out.print(" " + ouch);
    }
    void go(int uch) {
        ouch++;
//        for(int ouch = 3; ouch < 6; ouch++)
//            ;
        System.out.print(" " + uch);
        }
}


/*
1. C Correct
2. E Correct
3. C Correct
4. F Correct
5. A Correct
6. B Correct
7. A,B,G Correct
8. C Wrong // Cannot have more than 1 variable of same name in a scope
9. D Correct
10. A Correct
11. B Correct
12. E Wrong // local variable gets precedence
13. E Correct

 */

/*

4. ===========
m2 ==== 1000x [m1 = null]
m3 ==== 2000x [m1 = m2]
m4 ==== m2(1000x)
m5 ==== null

5. ============
f1 ===== 1000x [x=5/6]
f2 ===== 2000x [x=5]
z  ===== f1 = 1000x [x=5/6]
f3 ===== f1 = 1000x

6. ============
m1 ==== 1000x [size = 7/8]
m2 ==== m1 = 1000x
i1 = 10
i2 = 10

7. ============
w1 ==== 1000x [id = 1]
w2 ==== 2000x [id = 2]

8. ============
static int ouch = 7

9. ============
h1 ==== 1000x [id=1/2]
go ====
    h3 = 1000x

h1 ==== 1000x [id=1]

10. ============
n1 ==== 1000x [id=1 , p=this(1000x)]
go ===
    n2 = 2000x[id=2 , p=1000x]
    n3 = 3000x[id=3 , p=2000x]

11. ============
static Beta b1 = null/1000x/; => in class Alpha
b1 ==== (1000x)/null
b2 ==== (2000x)/null
a1 ==== (3000x[b2 = null/1000x])/null
a2 ==== 4000x[b2 = null/2000x]

12. ============
go ===
    zoomIn ===
        magnify = 2/10;
        zoomMore ===
            magnify = 2/10/70;

13. ============



 */
