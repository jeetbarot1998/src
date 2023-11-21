package Chap2;

import java.io.IOException;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class Lect2_3_over_loading_riding {
}

// NULL is compatible with any reference type.
// Compiler gives precedence to the child over the parent in over loading.

// ==================== Composition and Aggregation =====================

// Example of Composition: Highly dependent. If Body is destroyed, even lungs will be destroyed.
// Both have 'HAS A RELATION'
class Lungs{
}

class Body{
    private Lungs lung;
}

// Example of Aggregation: Independent. If Department is destroyed, the Professor won't be destroyed.
// Both have 'HAS A RELATION'
class Professor{
}

class Department{
    private Professor professor;
}

// ==================== Over Riding =====================
class Parent2_3{
    public void display1(){
        System.out.println("PARENT");
    }
}

class Child2_3 extends Parent2_3{
    public void display(){
        System.out.println("CHILD");
    }
}

class Test2_3{
    public static void main(String ...args) {
        Parent2_3 p = new Child2_3();
//        p.display(); // => this will give error as the parent type does not have "display" method.
//        You'll have to type cast it.
    }
}

// ==================== Over Loading =====================

class Test2_3_1{
//  Implicit type casting
    int a = 'c';

//  Explicit type casting
    int j = 6;
    char o = (char) j;

    public void print(long i){
        System.out.println("long " + i);
    }
    public void print(byte i){
        System.out.println("byte " + i);
    }
    public void print(int i){
        System.out.println("int " + i);
    }
    public void print(float f){
        System.out.println("float " + f);
    }

    public int print(String d){
        System.out.println("String " + d);
        return 5;
    }

    public int print(Object d){
        System.out.println("Object " + d);
        return 5;
    }

//    This is invalid.
//    public int print(float f){
//        System.out.println("float " + f);
//        return 1;
//    }

    public static void main(String ...args) {
        Test2_3_1 t = new Test2_3_1();
        t.print((byte)5);
        t.print(5);
        t.print(50L);
        t.print(30.554f);
        t.print(10.2); // => goes from double type to Double as Double is wrapper type and is an object type, hence it goes to "Object"
        t.print('a');
        System.out.println("double type over loaded print method with response of type int "+t.print(9D));


//      The below examples will fit into "Object" but
//      Compiler gives precedence to the child over the parent in over loading.
//      Hence, if String type is given then it will go to String even if it can fit into Object
        t.print(null);
        t.print("String Example");
    }
}

// Widening or implicit conversion or casting down: Converting a lower data type to a higher data type.
// byte -> short -> char -> int -> long -> float -> double

// Narrowing or casting up or explicit type: casting reducing a larger data type to a smaller one.
// If we do not do this explicitly, we will get a compile-time error.
//double -> float -> long -> int -> char -> short -> byte


//============================= Ambiguous method call & Re-ordering & var args===========================
class A2_3{}
class B2_3{}

class Test2_3_2{

//  Ambiguous method call
    private A2_3 a =null;
    public void m1(A2_3 a){
        System.out.println("A2_3 ");
    }

    public void m1(B2_3 b){
        System.out.println("B2_3 ");
    }

//  Re-ordering the parameters and over loading.
    public void m2(int i,float f){
        System.out.println("m2 with int and float");
    }

    public void m2(float f, int i){
        System.out.println("m2 with float and int");
    }

//   overloading with var args
    public void m3(int x){
        System.out.println("int ");
    }

    public void m3(int ...x){
        System.out.println("int var args");
    }

    public static void main(String ...args) {
        Test2_3_2 t = new Test2_3_2();

//      ===============  Ambiguous method call ===============
        System.out.println("===============  Ambiguous method call ===============");
//        t.m1(null); => error saying Ambiguous method call. as both the methods can take a parameter as null.

//      ===============  Re-ordering ===============
        System.out.println("===============  Re-ordering ===============");
        t.m2(10,10.5f);
        t.m2(10.5f,10);
//        t.m2(10,10); => Ambiguous method call as both the methods can take these parameters and hence compilation errors.
//        t.m2(10.5f,10.5f); => Cannot resolve method 'm2(float, float)' as there is no such overloading which takes float and float.

//      ===============  var args ===============
        System.out.println("===============  var args ===============");
        t.m3(2); // =>  more specific hence one argument
        t.m3(2,3);
        t.m3(); // => No argument means an empty array. Hence, valid.
    }
}

//============================= Reference type resolution for Parent child ===========================
class Animal{}
class Monkey extends Animal{}

class Test2_3_3{
    public void m1(Animal a){
        System.out.println("Animal");
    }

    public void m1(Monkey m){
        System.out.println("Monkey");
    }

    public static void main(String ...args) {
        Test2_3_3 t =  new Test2_3_3();
        Animal a = new Animal();
        t.m1(a);
        Monkey m = new Monkey();
        t.m1(m);
        Animal am = new Monkey();
        t.m1(am);
//        The compiler always chooses the most specific method
//        that can handle the argument type. Since Monkey is more specific than Animal
//        (because Monkey is a subclass of Animal), it selects m1(Monkey m).
//        Compiler gives precedence to the child over the parent in over loading.
        t.m1(null);
    }

}

//============================= Exception ===========================

// There is only one Run time exception which comes under Exception. All the other
// one level child of Exception class are Compile time exceptions.
//
class Test234{

}

class Parent23{
    void m1() throws SQLException, IOException {

    }
}


class Child23 extends Parent23{
//    when you override a method in a subclass, you are allowed to declare a more specific
//    exception type (subtype) in the throws clause of the overridden method.
//    This is known as "covariant return types" and it allows the overriding method to
//    declare exceptions that are subclasses of the exceptions declared in the overridden method.
    void m1() throws SQLWarning, RuntimeException{

    }
}







