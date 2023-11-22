package Chap3;

import java.awt.*;

public class Chap3_3_Heap_Stack {
    int x , y=x + 1, z; // works as instance variable are given default values.
    public static void main(String[] args) {
//        int x , y= x + 1, z; // will not work as x is not given default value in local variables.
        int sal = 100_00_000;
        float f = 10_00.00_1f;
        int bin = 0B101010;
        int octal = 01117;
        int a = 0X1237AF;
        float d = 10.0f;

//      Even if a number is decimal, it is by default assigned to double type, despite saving it into float.
//      But if you want to save it in float, you must give "f" or "F" at the end of the decimal number
//      to make it float type. float d = 10.0; => This wont work.


//      For Double, you need not mention "d" or "D" explicitly.

        long l = 10L;
        char c = 0x123;
        double dou = 10.5;
        byte a1 = 6;
        //  a1 = a1 + 1; //⇒ will not work as we are adding integer to byte.
        a1++; // ⇒ will work as the compiler does the casting for us.
        a1 += 7; // ⇒ will work as the compiler does the casting for us.
        byte a2 = 12;
        byte a3 = 13;
//      byte e = a2 + a3; // Will not work. as max(int , type of a2, type of a3) = int. Hence, We will have to do explicit type casting.
        byte e = (byte) (a2 + a3);
        long l1 = 2192819;
    }
}


class B3{
    static int y = 10;

    public static void main(String[] args) {
        System.out.println(y); // => this represents static class var "y".
        int y = 8;
        System.out.println("Now as there is another 'y', local variable will be given priority");
        System.out.println(y);
        System.out.println(Byte.MAX_VALUE + 1);
    }
}


class Book32{
    String name;

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Book32 b = new Book32();
        String s = b.getName();
        s.toLowerCase(); // => run time null pointer
//        error as default value of name is null. and you cannot
//      perform "toLowerCase()"on null object.
        System.out.println(s);
    }
}


class ReferenceTest {
    public static void main (String [] args) {
        String x = "Java";
        String y = x;
        Integer a = 5;
        Integer g = a;
        g += 7;
        System.out.println(g);
        System.out.println(a);
//      String is a class in java which is immutable and whenever you do
//      ANY changes in the object, it creates a new object. Even a topUpperCase() creates
//      a new object.
//        ==========
        Dimension a1 = new Dimension(5,10);
//      here a1 is a local variable which is stored in stack. It points to the
//      heap object create of class Dimension with attributes width and height
        System.out.println("a1.height = " + a1.height);
        Dimension b1 = a1; // as a1 is a reference variable, "b1" also points to the same object
//      as "a1". So "a1" and "b1" both are pointing to the same object.
        b1.height = 30;
        System.out.println("a1.height = " + a1.height +
                " after change to b");
    }
}

class Foo32 {
    static int size = 7;
    static void changeIt(int size) {
        size = size + 200;
        System.out.println("size in changeIt is " + size);
    }
    public static void main (String [] args) {
//        Foo32 f = new Foo32();
        System.out.println("size = " + size);
        changeIt(size);
        System.out.println("size after changeIt is " + size);
    }
}


class Student322{
    int id  = 100;
    public static void main(String[] args) {
        int val = 200;
        Student322 st1 = new Student322();
        st1.id = val;
        update(st1);
        System.out.println(st1.id);
        Student322 st2 = new Student322();
        st2.id = 500;
        switchStudents(st2, st1);
        System.out.println(st1.id);
        System.out.println(st2.id);
    }

    static void switchStudents(Student322 st1, Student322 st2){
        int tempid = st1.id;
        st1.id = st2.id;
        st2 = new Student322();
        st2.id = tempid;
    }

    static void update(Student322 st){
        st.id = 300;
        st = new Student322();
        st.id = 400;
    }
}

class Test3{
    Test3 t;
    int val;

    Test3(int val){
        this.val = val;
    }
    Test3(int val, Test3 t){
        this.val = val;
        this.t = t;
    }

    public static void main(String[] args) {
        Test3 t1 = new Test3(1);
        Test3 t2 = new Test3(2, t1);
        Test3 t3 = new Test3(3, t1);
        Test3 t4 = new Test3(4, t2);

        t2.t = t3;
        t3.t = t4;
        t1.t = t2.t;
        t2.t = t4.t;
        System.out.println(t1.t.val);
        System.out.println(t2.t.val);
        System.out.println(t3.t.val);
        System.out.println(t4.t.val);
    }
}