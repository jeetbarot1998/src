package OCP.Generic_AIC_Threads_Intro;

import java.util.*;

public class Generics {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(8);
        al.add(0);
        for(Object i:al){
            System.out.println(((Integer)i).intValue());
        }

        ArrayList <Integer> al1 = new ArrayList();
        al1.add(1);
        al1.add(2);
        al1.add(3);
        al1.add(8);
        al1.add(0);
//        al1.add(10.0);
        for(Integer i :al1){
            System.out.println(i);
        }

        Map k = new HashMap();


    }
}

class Gen<T>{
    T obj;
    Gen(T obj){
        this.obj = obj;
    }

    public void show(){
        System.out.println("The Object is of type + " + obj.getClass().getName());
    }

    public T getObj(){
        return obj;
    }
}


class Runner{
    public static void main(String[] args) {
        Gen<String> gs = new Gen<>("ABC");
        gs.show();
        System.out.println(gs.getObj());
        Gen<Double> gd = new Gen<>(10.7);
        gs.show();
        System.out.println(gs.getObj());
    }
}


class BoxBounded<T extends Number> {
    private T value;

    void m1(){

        System.out.println();
    }
    public BoxBounded(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        BoxBounded<Integer> intBox = new BoxBounded<>(10);
        System.out.println("Value: " + intBox.getValue());

        BoxBounded<Double> doubleBox = new BoxBounded<>(10.1);
        System.out.println("Value: " + intBox.getValue());

        // Compile-time error: String is not a subtype of Number
        // Box<String> stringBox = new Box<>("Hello");
    }
}


interface i{}
class InterfaceBounded<T extends i> {

}


class testG2<T extends Number>{}
class testR<T extends Runnable>{}

class DriverG1{
    public static void main(String[] args) {
        testG2<Integer> tg = new testG2<>();
//        testG2<String > tg1 = new testG2<>();
        testR<Runnable> r = new testR<>();
//        testR<Integer> ri = new testR<>();
//        Type parameter 'java.lang.Integer' is not
//        within its bound; should implement 'java.lang.Runnable'
        testR<Thread> rt = new testR<>();

    }
}

// T should be Extending Number and implementing Runnable
class testNR<T extends Number & Runnable>{}

// cannot implement then extend. The sequence should be maintained
//class testNR2<T extends Runnable & Number>{}

// cannot extend multiple classes
//class testNR3<T extends StringBuffer & Number>{}

//Can implement multiple interfaces
class testNR3<T extends Runnable & Comparable>{}

// T should be Extending Number and implementing Runnable, Comparable
class testNR4<T extends Number & Runnable & Comparable>{}


class testG3{
    public static void main(String[] args) {
        ArrayList<String > al =  new ArrayList<>();
        al.add("ABC");
        m1(al);

        ArrayList<Integer > ali =  new ArrayList<>();
        ali.add(1);
        ali.add(1);
        m1(ali);


        ArrayList<? extends Number> al1 = new ArrayList<Integer>();
//        al1.add(10); => Cannot add as we do not know what will
//        be the input at runtime

        ArrayList<? super String> al0 = new ArrayList<Object>();
//        Wildcard type '? extends java.lang.Number'
//        cannot be instantiated directly
//        ArrayList<?> l = new ArrayList<? extends Number>();
    }
    static void m1(List<?> l){
//        l.add(1)
        System.out.println("Because we are not sure of the type or \n" +
                " do not know at compile time what will be \n" +
                " the type of the argument being passed we cannot add. \n" +
                "So this can be used for read only ");
        System.out.println(l);
    }

    static void m2(List<? super Runnable> l){

    }
}


// Required type: ArrayList <Object>
//Provided: ArrayList <String>
//class testG4{
//    public static void main(String[] args) {
//        ArrayList<String > al =  new ArrayList<>();
//        m1(al);
//    }
//    static void m1(ArrayList<Object> l){
//        l.get(1);
//    }
//}