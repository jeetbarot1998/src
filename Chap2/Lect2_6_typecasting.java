package Chap2;

public class Lect2_6_typecasting {
}

// ====================== Singleton Design Pattern ===============================
// The Singleton Pattern is a design pattern that ensures a class has
// only one instance and provides a global point of access to that instance.
class JavaTeacher{
//    Making this variable static as the static method has to access this variable. If it is not static then it
//    cannot be accessed without making an object
    private static JavaTeacher instance = null;
    private JavaTeacher(){
//        As the constructor is private, hence no one can call the constructor directly.
        System.out.println("Constructor Invoked");
    }

//    We have to make this variable static as we cannot call the constructor, so using the class name we can
//    call the method to invoke the method internally.

    public static JavaTeacher getTeacherInstance(){
        if (instance == null){
            instance = new JavaTeacher();
            return instance;
        }
        return instance;
    }


    public static void main(String[] args) {
        JavaTeacher obj = new JavaTeacher();
    }
}

class Child26{
    public static void main(String[] args) {
//        JavaTeacher obj = new JavaTeacher(); => Cannot create object.
        JavaTeacher obj1 = JavaTeacher.getTeacherInstance();
        JavaTeacher obj2 = JavaTeacher.getTeacherInstance();
        System.out.println(obj1==obj2);
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
    }
}

// ====================== Type Casting Objects ===============================
//   Identify if type casting is correct or not.
// E d = new F();
// A b = (C) d
// 1. "E" and "C" are supposed to have a parent child relationship.
// ie "E" parent "C" child => Compile time error.
// 2. "A" and "C" are supposed to have a parent child relationship.
// ie "A" parent "C" child or same => Compile time error.
// 3. "F" and "C" should be related to each other.
// ie "F" parent of "C" or same as "C" => Run time error. [ClassCastException]



class TypeCaste26{
    public static void main(String[] args) {
// ============ EXAMPLE 1 [ClassCastException] ============
//      Run time error =>
//      is "Object" parent of "StringBuffer" ? Yes
//      is "StringBuffer" child of or same as "StringBuffer" ? Yes
//      is "String" parent of "StringBuffer" or same ? No.
//      We tried casting "String" into "StringBuffer" as they are siblings not
//      parent child => Runtime error
//        ===== CODE =====
//        Object o = new String("New");
//        StringBuffer sb = (StringBuffer) o;

// ============ EXAMPLE 2 [ClassCastException] ============
//      Run time error =>
//      is "Object" parent of "ArrayList" ? Yes
//      is "ArrayList" child of or same as "ArrayList" ? Yes
//      is "String" parent of "ArrayList" or same ? No.
//      We tried casting "String" into "ArrayList" as they are siblings not
//      parent child => Runtime error
//        ===== CODE =====
//        Object o2 = new String("New");
//        ArrayList ao = (ArrayList) o2;


// ============ EXAMPLE 3 [Inconvertible types] ============
//      Compile time error =>
//      is "String" parent of "StringBuffer" ? No.
//      is "StringBuffer" child of or same as "StringBuffer" ? Yes.
//      is "StringBuffer" parent of "String" or same ? No.
//      We tried casting "String" into "ArrayList" as they are siblings not
//      parent child => Runtime error
//        ===== CODE =====
//        String o3 = new String("New");
//        StringBuffer os = (StringBuffer) o3;


// ============ EXAMPLE 4 [Inconvertible types] ============
//      Compile time error =>
//      is "Object" parent of "String" ? Yes
//      is "String" child of or same as "StringBuffer" ? No.
//      is "String" parent of "String" or same ? Yes.
//      We tried casting "String" into "ArrayList" as they are siblings not
//      parent child => Runtime error
//        ===== CODE =====
//        Object o4 = new String("New");
//        StringBuffer os = (String) o4;


    }
}

// ====================== Type Casting and Over riding Objects ===============================

class A26{
    int x = 999;
    void m1(){
        System.out.println("A26 m1");
    }
    void m2(){
        System.out.println("B m2");
    }
}

class B26 extends A26 {
    int x = 888;
    void m1(){
        System.out.println("B26 m1");
    }
    void m2(){
        System.out.println("B m2");
    }
}

class C26 extends  B26{
    int x = 777;
    void m1(){
        System.out.println("C26 m1");
    }

    void m2(int i){
        System.out.println("C m2 over loaded with params");
    }
}
class Test262{
    public static void main(String[] args) {

        ((C26) new B26()).m2();
//      In Java, you can perform type casting on references, but it won't
//      change the actual type of the object. The type of the object is
//      determined at the time of its creation and cannot be changed during the
//      program's execution.
//      Type casting is mainly about treating an object as if it belongs to a
//      different type (either a superclass or a subclass) from its actual
//      declared type. There are two types of casting: up-casting (casting
//      to a superclass type) and down-casting (casting to a subclass type).
//      Method over loading on run time is only valid on methods
        C26 c = new C26();
//      whenever you are typecasting, you only change the type of the reference
//      variable. Hence, even if you change the reference variable,
//      the object type is still of type "C".
        c.m1(); //=> C
        ((B26) c).m1(); //=> C m1
        ((A26)((B26) c)).m1(); //=> C m1
// =============== over ridding is only applicable on methods , not on instance variables ===============
        System.out.println("over ridding is only applicable on methods , not on instance variables");
        System.out.println(c.x);
        System.out.println(((B26) c).x);
        System.out.println(((A26)((B26) c)).x);

// Over loading
        B26 b26 = ((B26) c);
        b26.m2(); //B m2

//        b26.m2(2); => error.

    }
}

// ====================== Coupling and Cohesion ===============================
// Tight Coupling
class A261{
    static int i = B261.j;
}

class B261{
    static int j = C261.k;
}

class C261{
    static int k = D261.m1();
}

class D261{
    public static int m1(){
        return 10;
    }
}

// ========== low Cohesion ==========
// Less preferable.
class Gmail{
    void composeMail(){}
    void deleteMail(){}
    void reply(){}
}


// ========== High Cohesion ==========
// BETTER
class ComposeMail{}
class DeleteMail{}
class Reply{}

// ====================== Over-riding and static ===============================
// We do not inherit the static methods. Hence, we cannot over-ride it.
// It is called method hiding

class A262{
    static void m1(){
        System.out.println("A262 m1");
    }
}

class B262 extends A262{
    static void m1(){
        System.out.println("B262 m1");
    }
}

class C262 extends B262{
    static void m1(){
        System.out.println("C262 m1");
    }
}

class E262 extends C262{
//    If we have a static method in parent and
//    try to over-ride its child class with instance method, then it will give an error.
//    void m1(){
//        System.out.println("C262 m1");
//    }
}


class D262{

    public static void main(String[] args) {
        C262 c = new C262();

//      For static methods the over-riding methods are done on the basis of the reference type of the object.
//      This is called method hiding.
        c.m1();
        ((B262) c).m1();
        ((A262)((B262) c)).m1();
    }
}




