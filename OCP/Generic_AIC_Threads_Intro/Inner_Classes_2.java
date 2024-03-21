package OCP.Generic_AIC_Threads_Intro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inner_Classes_2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i<10; i++){
                    System.out.println("Running using Anonymous inner class : " + i);
                }
            }
        };
        t.start();
        for (int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
        }

        t.join();
        System.out.println(t.getClass().getName());
    }
}
class MyThreadIC extends Thread{
    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println("Child Thread : " + i);
        }
    }
}

class ThreadExtendApproachIC{
    public static void main(String[] args) {
        MyThreadIC mt = new MyThreadIC();
        mt.start();
        for (int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
        }
    }
}


class RunnableType{
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10; i++){
                    System.out.println("Running using Anonymous implementing Interface : " + i);
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
        }
        t.join();
        System.out.println(r.getClass().getName());
        System.out.println("============ usingLambda ==============");
        usingLambda();

    }

    static void usingLambda() throws InterruptedException {
        Runnable r1 = () -> {
            for (int i = 0; i<10; i++){
                System.out.println("Running using Anonymous implementing Interface : " + i);
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        for (int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
        }
        t1.join();
        System.out.println(r1.getClass().getName());
    }
}

class ThreadDemoRunnableAsMethodArgument{
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10; i++){
                    System.out.println("Thread Demo Runnable As Method Argument : " + i);
                }
            }
        });
        t.start();
        for (int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
        }
    }
}


class OuterClass {
    private static int staticOuterVariable = 30;
    private int InsatnceOuterVariable = 33;

    // Static Nested Class
    static class NestedClass {
        void display() {
            System.out.println("Static Outer Variable: " + staticOuterVariable);
//            System.out.println("Instance Outer Variable: " + InsatnceOuterVariable);
            System.out.println("You cannot access instance variable of \n" +
                    " outside class from static inner class as the static\n" +
                    " inner class is like a static method. ");
            OuterClass oc = new OuterClass();
            System.out.println(oc.InsatnceOuterVariable);
        }

        public static void main(String[] args) {
            System.out.println("Inside main method of Static nested Inner class");
        }
    }

    public static void main(String[] args) {
        NestedClass nc =  new NestedClass();
        nc.display();
        nc.main(null);
        OuterClass.NestedClass nested = new OuterClass.NestedClass();
        nested.display();
    }
}

class OuterClassReg {
    private int outerVariable = 10;

    // Regular Inner Class
    class InnerClass {
        void display() {
            System.out.println("Outer Variable: " + outerVariable);
        }
    }

    public static void main(String[] args) {
        OuterClassReg outer = new OuterClassReg();
        OuterClassReg.InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}


class TestObjIc{
    public static void main(String[] args) {
        Object o = new Object() {
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("Hello"));
        System.out.println(o.equals("Aloo"));
    }
}

class Guid extends JFrame{
    static JButton b1,b2,b3,b4;

    public static void main(String[] args) {
        b1 = new JButton("hi");
        b2 = new JButton("b2");
        b3 = new JButton("b3");
        b4 = new JButton("b4");

        Guid g =  new Guid();
        g.setSize(new Dimension(500,500));
        g.setVisible(true);
        g.add(b1);
        g.add(b3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked B1");
            }
        });

        b3.addActionListener((e) -> {
            System.out.println(e);
            System.out.println("Clicked B3");
        });
    }
}


