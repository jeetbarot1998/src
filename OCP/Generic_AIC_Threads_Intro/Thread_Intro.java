package OCP.Generic_AIC_Threads_Intro;

public class Thread_Intro {
    
}

class MyThreadIntro1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println("Child Thread : " + i);
        }
    }
}

class ThreadExtendApproachIntro1{
    public static void main(String[] args) {
        System.out.println("USING Start");
        MyThreadIntro1 mt = new MyThreadIntro1();
        mt.start();
        for (int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
        }
    }
}


class ThreadExtendApproachIntro2{
    public static void main(String[] args) {
        System.out.println("USING Run");
        MyThreadIntro1 mt = new MyThreadIntro1();
        mt.run();
        for (int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
        }
    }
}

class MyThreadIntro2 extends Thread {
//    @Override
//    public void run() {
//        System.out.println("No args");
//    }

    public void run(String ar) {
        System.out.println("args : " + ar);
    }
}

class ThreadDemoIntro1{
    public static void main(String[] args) {
        MyThreadIntro2 mtd = new MyThreadIntro2();
        mtd.start();
    }
}

class MyThreadIntro3 extends Thread {

}


class ThreadDemoIntro2{
    public static void main(String[] args) {
        MyThreadIntro3 mtd = new MyThreadIntro3();
        mtd.start();
    }
}

class MyThreadIntro4 extends Thread {
    @Override
    public void start() {
        System.out.println("start");
    }

    public void run() {
        System.out.println("over ridden run");
    }
}

class ThreadDemoIntro3{
    public static void main(String[] args) {
        MyThreadIntro4 mtd = new MyThreadIntro4();
        mtd.start();
        System.out.println("main method");
    }
}

class MyThreadIntro5 extends Thread {
    @Override
    public void start() {
        super.start();
        System.out.println("start");
    }

    public void run() {
        System.out.println("over ridden run");
    }
}

class ThreadDemoIntro{
    public static void main(String[] args) {
        MyThreadIntro5 mtd = new MyThreadIntro5();
        mtd.start();
        System.out.println("main method");
    }
}

class ThreadDemo2{
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



