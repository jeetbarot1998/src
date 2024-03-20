package OCP.Generic_AIC_Threads_Intro;

class Method_Inner_Classes {
    int x = 10;
    static int y = 15;
    public void m1(){
        int o = 19;
        class Inner{
            public void m2(){
                System.out.println("This class cannot be accessed outside the method m2().");
                System.out.println(o);
                System.out.println(x);
                System.out.println(y);
            }
        }
        Inner i = new Inner();
        i.m2();
    }

    public static void main(String[] args) {
        Method_Inner_Classes mic = new Method_Inner_Classes();
        mic.m1();
        System.out.println("If we declare a class inside a method,\n" +
                " then from that method local inner class we can access \n" +
                "both static and non static members of the outer class directly\n" +
                "If we declare a class inside a static method, then from \n" +
                " that method local inner class we can access only static \n" +
                "members of the outer class directly");
    }
}


class Inner1 {
    void display() {
        System.out.println("Inside Parent class");
    }
}

class InnerEx {
    public static void main(String[] args) {
        // Anonymous inner class extends Parent class
        Inner1 anonymousInner = new Inner1() {
            @Override
            void display() {
                System.out.println("Inside Anonymous Inner class");
            }
            // Invalid : Rules of over-riding
            // private void display() {
            //  System.out.println("Inside Anonymous Inner class");
            // }
            void Invisible(){
                System.out.println("This is not visible");
            }
        };

        anonymousInner.display(); // Output: Inside Anonymous Inner class
        System.out.println("Extra methods declaration inside inner\n" +
                " AIC has no meaning as the reference type is of \n" +
                "parent and hence it will not be visible. Also it \n" +
                "cannot be type casted as there is no name for the \n" +
                "class to type it to.");
//        anonymousInner.Invisible();
        System.out.println(anonymousInner.getClass().getName());

    }
}

class PopCorn{
    void taste(){
        System.out.println("Sweet");
    }
}

class SipcyPopCorn extends PopCorn{
    @Override
    void taste() {
        System.out.println("Spicy");
    }
}

class InnerClassEx2{
    public static void main(String[] args) {
        System.out.println("=========== PopCorn-Anonymous2 =========== ");
        PopCorn p = new PopCorn(){
          void taste(){
              System.out.println("Custom taste 1");
          }
        };
        p.taste();
        System.out.println(p.getClass().getName());

        System.out.println("=========== PopCorn =========== ");
        PopCorn p1 = new PopCorn();
        p1.taste();
        System.out.println(p1.getClass().getName());

        System.out.println("=========== SipcyPopCorn =========== ");
        SipcyPopCorn sp = new SipcyPopCorn();

        sp.taste();
        System.out.println(sp.getClass().getName());

        System.out.println("=========== PopCorn-Anonymous1 =========== ");
        PopCorn p2 = new PopCorn(){
            void taste(){
                System.out.println("Custom taste 2");
            }
        };

        p2.taste();
        System.out.println(p2.getClass().getName());

    }
}


class InnerEx1{
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Inner Class Implementing an Interface ");
            }
        };
        Thread t = new Thread(r);
        t.start();
        System.out.println(r.getClass().getName());
        new Thread(){
            @Override
            public void run() {
                System.out.println("Anonymous Inner class");
            }
        }.start();
    }
}


class MyThreadCl extends Thread{
    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println("Child Thread : " + i);
        }
    }
}

class ThreadExtendApproach{
    public static void main(String[] args) {
        MyThreadCl mt = new MyThreadCl();
        mt.start();
        for (int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
        }
    }
}


