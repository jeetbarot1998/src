package Chap2;

public class Lect2_2_over_riding_over_loading {
}

class Parent{
    public static void myStaticMethod() {
    }

    public void marry(){
        System.out.println("Amrish puri has fixed the shadi of Simran ");
    }

    public void porperty(){
        System.out.println("Millions of pounds");
    }

    private void pvtMethod(){
        System.out.println("pvt Method");
    }


}


class Child extends Parent{
    public void marry(){
        System.out.println("Dil wale dulhaniya le jaenge");
    }

    public void pvtMethod(){
        System.out.println("seems To Over Ride But Is Not as while inheriting ony public methods" +
                "are inherited");
    }

}


class Test{
    public static void main(String ...args){
        Parent p = new Parent();
        p.marry();

        Child c = new Child();
        c.marry();

        Parent cp = new Child();
//      Parent has child type of object.
        cp.marry();
//        cp.pvtMethod(); // error
        // run time polymorphism
//      The type of variable is "Parent" but the object stored in it is "Child". If the child has over-ridden
//      the method then it will call from th child or else it will call from the parent.
//      Which method to run is decided at run time, hence it ios called run time polymorphism, dynamic polymorphism
//      late binding
    }
}


//============================= RULES OF OVER RIDDING ==============================

class Parent1 {
    public Object m1(){
        System.out.println("Parent method");
        return null;
    }
}

class Child1 extends Parent1{
    @Override
    public String m1(){
//       The overriding method can return either the same type
//       or any child type of the return type of the overridden method.
//       We have changed the return type of the over-riding class
//       but, it is valid as the "String" is the child of "Object".
        System.out.println("Child method");
        return null;
    }

//    Also Valid
//    @Override
//    public ArrayList m1(){
//        return new ArrayList<>();
//    }

//    if Parent is "Object"
//       Child can be  "Object", "ArrayList", "String", "AnyOtherClassThatWeDeclared"

//  if Parent is "Number"
//     Child can be  "Integer", "Float", "Double", "Long" => For rapid data types.
//     Non-primitive class data types.

// These are only valid for objects not for primitive data types.
}

class Test1{
    public static void main(String ...args) {
        Parent1 p = new Parent1();
        p.m1();
        Parent1 p1 = new Child1();
        p1.m1();
    }
}


// ====================== Type Casting and Over riding Objects ===============================

class A22 {
    int x = 999;
    void m1(){
        System.out.println("A26 m1");
    }
    void m2(){
        System.out.println("B m2");
    }
}

class B22 extends A22 {
    int x = 888;
    void m1(){
        System.out.println("B26 m1");
    }
    void m2(){
        System.out.println("B m2");
    }
}

class C22 extends  B22{
    int x = 777;
    void m1(){
        System.out.println("C26 m1");
    }

    void m2(int i){
        System.out.println("C m2 over loaded with params");
    }
}
class Test22{
    public static void main(String[] args) {
//      In Java, you can perform type casting on references, but it won't
//      change the actual type of the object. The type of the object is
//      determined at the time of its creation and cannot be changed during the
//      program's execution.
//      Type casting is mainly about treating an object as if it belongs to a
//      different type (either a superclass or a subclass) from its actual
//      declared type. There are two types of casting: up-casting (casting
//      to a superclass type) and down-casting (casting to a subclass type).
//      Method over loading on run time is only valid on methods
        C22 c = new C22();
//      whenever you are typecasting, you only change the type of the reference
//      variable. Hence, even if you change the reference variable,
//      the object type is still of type "C".
        c.m1(); //=> C
        ((B22) c).m1(); //=> C m1
        ((A22)((B22) c)).m1(); //=> C m1
// =============== Method over loading on run time is only valid on methods ===============
        System.out.println("Method over loading on run time is only valid on methods");
        System.out.println(c.x);
        System.out.println(((B22) c).x);
        System.out.println(((A22)((B22) c)).x);

// Over loading
        B22 b22 = ((B22) c);
        b22.m2(); //B m2
//        b22.m2(2); => error.

    }
}