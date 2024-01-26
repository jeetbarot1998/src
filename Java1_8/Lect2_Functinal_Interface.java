package Java1_8;

import java.util.HashSet;
import java.util.Set;

public class Lect2_Functinal_Interface {
}

@FunctionalInterface
interface I1{
    void m1();
}

@FunctionalInterface
interface I2 extends I1{
//    Inherits m1()
}

@FunctionalInterface
interface I3 extends I1{
    void m1();
//    m1 Over ridden
}

@FunctionalInterface
interface I4 extends I1{
    void m1();
//    m1 Over ridden
//    void m2(); //is not a functional interface if there are ore than 2 abstract methods.
}


// ================================== IN JAVA 1.7 START ==================================
interface I11{
    void m1();
}


class c21 implements I11{

    @Override
    public void m1() {
        System.out.println(" Using Interface implemented class. ");
    }
}

class c22{
    public static void main(String[] args) {
        I11 i = new c21();
        i.m1();
    }
}
// ================================== IN JAVA 1.7 STOP ==================================

// ================================== IN JAVA 1.8 START ==================================
class c23{
    public static void main(String[] args) {
        I11 i = () -> {
            System.out.println("Using lambda m1 implemented. ");
        };
    }
}

// ================================== IN JAVA 1.8 STOP ==================================
@FunctionalInterface
interface I12{
    void add(int a, int b);
}

class c24{
    public static void main(String[] args) {
        I12 i = (a,b) -> {
            System.out.println("Using Lambda " + (a+b));
        };
        i.add(10,20);
    }
}


@FunctionalInterface
interface I13{
    int getLength(String s);
}

class c25{
    public static void main(String[] args) {
        I13 i = (s) -> {
            int len = s.length();
            System.out.println("Using Lambda length is : "+ len);
            return len;
        };
        System.out.println(i.getLength("asdfghjkl"));
    }
}

@FunctionalInterface
interface I14{
    int square(int i);
}

class c26{
    public static void main(String[] args) {
        I14 i1 = (i) -> {
            return i*i;
        };
        System.out.println(i1.square(5));
    }
}

// =================== Implementing runnable interface =======================

class MyRunable implements Runnable{
    public void run(){
        System.out.println("Job or Task Mentioned here");
    }
}

class c27{
    public static void main(String ... args){
        Runnable r = new MyRunable();
        // Here we have made an object of MyRunnable which has over-ridden the method 'run'
        // which defined what is the task and what is to be run.
        // We pass this custom runnable class which implements the Runnable interface
        // to the Thread class to run as a thread.
        Thread t = new Thread(r);
        t.start();
    }
}

// =================== Extending thread class =======================
class MyThread extends Thread{
    public void run(){
        System.out.println("Running Job");
    }

    public static void main(String[] args) {
        Thread t =  new MyThread();
        t.start();
    }
}

class MyRunable2 implements Runnable{
    public void run(){
        for(int i = 0; i<10; i++){
            System.out.println("Child Thread");
        }
    }
}

class c28{
    public static void main(String ... args){
        Runnable r = new MyRunable2();
        Thread t = new Thread(r);
//        t.setPriority(9);
        t.start();
        for(int i = 0; i<10; i++){
            System.out.println("Main Thread");
        }
    }
}

// ===================== Using Lambda ==========================

class c29{
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("Runnable task mentioned using lambda");
            for(int i = 0; i<10; i++){
                System.out.println("Child Thread");
            }
        };
//        This will over-ride the 'run' Method inside the Runnable interface
//        As Runnable is a FunctionalInterface and hence lambda
//        by default over-rides it

        Thread t = new Thread(r);
        t.start();

        System.out.println("================= OR =====================");
        new Thread(() -> {
            System.out.println("Runnable task mentioned using lambda");
            for(int i = 0; i<10; i++){
                System.out.println("Child Thread");
            }
        }).start();

    }
}

class E2{
    private String name;
    private int score;

    public E2(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object b){
        if(b instanceof E2){
            E2 obj = (E2) b;
            if(obj.name.equals(this.getName()) && (obj.getScore() == this.getScore())){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 0;
    }


    public static void main(String[] args) {
        Set<E2> s = new HashSet<E2>();
        E2 e = new E2("ABC", 10);
        E2 e0 = new E2("ABC", 10);
        System.out.println(e.equals(e0));
        E2 e1 = new E2("DEF", 12);
        System.out.println("Before adding it checks if the hasCode() is same \n" +
                "And also the equals method of the object inside the class.");
        s.add(e);
        s.add(e);
        System.out.println(s.size());
        s.add(e1);
        System.out.println(s.size());
        s.add(e0);
        System.out.println(s.size());
    }
}




