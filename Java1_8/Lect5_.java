package Java1_8;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Lect5_ {
}

interface intrf51{
    default void m1(){
        System.out.println("Default intrf51");
    }

    void m2();
}

class c51 implements intrf51{
    public static void main(String[] args) {
        new c51().m1();
    }

    @Override
    public void m1(){
        System.out.println("Over ridden m1 method");
    }

    @Override
    public void m2(){
        System.out.println("M2 implemented C51.");
    }
}

class c52 implements intrf51{
    @Override
    public void m2() {
        System.out.println("M2 implemented C52.");
    }
}

interface intrf52{
    default void m1(){
        System.out.println("Default intrf52");
    }

    void m2();
}


// Diamond Problem
//Java1_8.c53 inherits unrelated defaults for m1()
// from types Java1_8.intrf51 and Java1_8.intrf52
class c53 implements intrf51, intrf52{

    public void m1(){
        System.out.println("Implementing m1() as to remove ambiguity.");
    }

    @Override
    public void m2() {
        System.out.println("Interface implemented.");
    }

    void callInterfaceDefault(){
        intrf52.super.m1();
        intrf51.super.m1();
    }

    public static void main(String[] args) {
        c53 c = new c53();
        c.m1();
        c.m2();
        c.callInterfaceDefault();
    }
}


interface intrf53{
    static void staticMethod(){
        System.out.println("Static Method intrf53");
    }
}

class c54 implements intrf53{

    void staticMethod(){
        System.out.println("Instance method which of the class C54");
    }

    public static void main(String[] args) {
        c54 c = new c54();
//        staticMethod();
//        c.staticMethod();
//        c54.staticMethod();
        System.out.println("Static methods are not available by default to the implementer class.");
        intrf53.staticMethod();
    }
}

interface intrf54{
//    This will not be inherited
    static void staticMethod(){
        System.out.println("Static Method intrf54");
    }
}

class c56{
//    This will be inherited
    static void staticM(){
        System.out.println("Static method c56");
    }
}

class c55 extends c56 implements intrf54{
    static void staticMethod(){
        System.out.println("Static Method c55");
    }

//    Instance method 'staticM()' in 'Java1_8.c55' cannot override static method 'staticM()' in 'Java1_8.c56'
//    void staticM(){
//    }

    static void staticM(){
        System.out.println("The parent class static method is inherited but\n" +
                "This is not over riding, this is shadowing.\n" +
                "It is a static method of class c55.");
    }

    public static void main(String[] args) {
        Predicate<Integer> checkEven = (i) -> {
          return i%2 == 0;
        };
        System.out.println(checkEven.test(5));
        System.out.println(checkEven.test(10));

        BiPredicate<Integer,Integer> isGreaterThan20 = (i0,i1) -> {
            return i0+i1 > 20;
        };
        System.out.println(isGreaterThan20.test(5,22));
        System.out.println(isGreaterThan20.test(5,2));
    }
}



