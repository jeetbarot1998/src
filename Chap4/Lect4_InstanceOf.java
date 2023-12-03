package Chap4;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

public class Lect4_InstanceOf {
}

interface Machine{}

class Vehicle implements Machine{}

class Car extends Vehicle{}

class Toy{}

class InstanceDemo{
    public static void main(String[] args) {
        Machine m = new Vehicle();
        Machine m2 = new Car();
        Vehicle v = new Car();
        Car c1 = new Car();
        Car c2 = new Car();
        Car [] carr = new Car[] {c1,c2};
        Car c = new Car();
        System.out.println( "c instanceof Machine: "+ (c instanceof Machine));
        System.out.println( "m instanceof Vehicle: "+ (m instanceof Vehicle));
        System.out.println( "m2 instanceof Car: "+ (m2 instanceof Car));
        System.out.println( "m instanceof Car: "+ (m instanceof Car));
        System.out.println( "c instanceof Vehicle: "+ (c instanceof Vehicle));
        System.out.println( "v instanceof Machine: "+ (v instanceof Machine));
        System.out.println( "v instanceof Car: "+ (v instanceof Car));
        System.out.println( "null instanceof Object: "+ (null instanceof Object));
        System.out.println( "carr[1] instanceof Object: "+ (carr[1] instanceof Car));
        System.out.println( "carr instanceof Object: "+ (carr instanceof Object));
//        System.out.println( "carr instanceof Object: "+ (carr instanceof Car));
        int [] arr = new int[] {1,2,3};
        System.out.println( "arr instanceof Object: "+ (arr instanceof Object));
        System.out.println(arr.getClass().getName());

    }
}

class InstanceOf{
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.println(t instanceof Thread);
        System.out.println(t instanceof Object);
        System.out.println(t instanceof Runnable);
//        System.out.println(t instanceof String);
//      null instanceof <anything> will give false

    }
}


class Student{
    void read(){
        System.out.println("Reading");
    }
    void play(){
        System.out.println("Playing");
    }
}


class TypeCastingDemo{
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("ABC");
        list.add(new Student());
        for (Object each_elem : list){
            if(each_elem instanceof Student){
                ((Student)each_elem).play();
            } else if (each_elem instanceof String) {
                System.out.println(((String)each_elem).length());
            }
        }
    }
}


