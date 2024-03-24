package OCP.Thread;

public class Thread_2 implements Runnable{
    @Override
    public void run() {
        for(int i = 0 ; i<10; i++){
            System.out.println("Child Thread : " + i);
        }
    }
}

class ThreadEx21{
    public static void main(String[] args) {
        Thread_2 task = new Thread_2();
        Thread t = new Thread(task);
        t.start();
        for(int i = 0 ; i<10; i++){
            System.out.println("Main Thread : " + i);
        }
    }
}


class MyRunnable21 implements Runnable{
    @Override
    public void run() {
        System.out.println("Running Runnable");
    }
}

class ThreadEx22{
    public static void main(String[] args) {
        MyRunnable21 task = new MyRunnable21();
        Thread t1 = new Thread();
        Thread t2 = new Thread(task);
        t1.start(); // creates a new Runnable thread and no o/p as run method is empty
        t1.run(); // no new thread is spawned and no o/p as run method is empty
        t2.start(); // creates a new Runnable thread and o/p will be "Running Runnable"
        t2.run(); //  no new thread is spawned and o/p will be "Running Runnable"
//        task.start(); // CE => No such method exists
        task.run(); // no thread is spawned and o/p will be "Running Runnable"

    }
}


class ThreadConstructorDemo{
    public static void main(String[] args) {
        Thread t = new Thread();
//        Thread t1 = new Thread(Runnable r);
//        Thread t2 = new Thread(String name);
//        Thread t3 = new Thread(Runnable r, String name);
//        Thread t4 = new Thread(ThreadGroup g, String name);
//        Thread t5 = new Thread(ThreadGroup g, Runnable r);
//        Thread t6 = new Thread(ThreadGroup g, Runnable r, String name);
//        Thread t7 = new Thread(ThreadGroup g, Runnable r, String name, long stackSize);

    }
}

class MyThread21 extends Thread{
    @Override
    public void run() {
        System.out.println("Running ");
    }
}

class ThreadExample22{
    public static void main(String[] args) {
        MyThread21 task = new MyThread21();
        Thread t1 = new Thread(task);
        t1.start();
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("My-Main-Thread");
        System.out.println(Thread.currentThread().getName());
        System.out.println(10/0);
    }
}

class ThreadCannotBeStartedAgain {
    public static void main(String[] args) {
        MyThread21 task = new MyThread21();
        Thread t1 = new Thread(task);
        t1.start();
        t1.start();
    }
}

class MyRunnable22 implements Runnable{
    @Override
    public void run() {
        System.out.println("Running Runnable by : " + Thread.currentThread().getName());
    }
}


class ThreadEx23{
    public static void main(String[] args) {
        MyRunnable22 task = new MyRunnable22();
        Thread t1 = new Thread(task);
        t1.start();
        System.out.println("Main method is ran by : " + Thread.currentThread().getName());
    }
}

// ========== Thread priority

class ThreadPriorityExample{
    public static void main(String[] args) {
        Thread t1 = new Thread();
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(7);
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(2);
        System.out.println(Thread.currentThread().getPriority());
        t1.setPriority(15);
    }
}

class MyThreadPriorityEx01 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getPriority());
        System.out.println("Runnable running");
    }
}

class ThreadPriorityExample01{
    public static void main(String[] args) {
        System.out.println("Default thread priority is '5'.");
        System.out.println(Thread.currentThread().getPriority());
        System.out.println("Child will inherit the same priority");
        Thread.currentThread().setPriority(7);
        System.out.println(Thread.currentThread().getPriority());
        MyThreadPriorityEx01 task  = new MyThreadPriorityEx01();
        task.start();
    }
}

class MyThreadPriorityEx02 extends Thread{
    @Override
    public void run() {
        System.out.println("Child thread Priority : " + Thread.currentThread().getPriority());
        for(int i = 0 ; i<5; i++){
            System.out.println("Child Thread : " + i);
        }
    }
}


class ThreadPriorityExample02{
    public static void main(String[] args) {
        System.out.println("Main thread Priority : " + Thread.currentThread().getPriority());
        MyThreadPriorityEx02 task  = new MyThreadPriorityEx02();
        task.setPriority(10);
        System.out.println("Child thread Priority : " + task.getPriority());
        task.start();
        for(int i = 0 ; i<5; i++){
            System.out.println("Main Thread : " + i);
        }
    }
}

// ========= Thread yield
class ThreadYieldEx{
    public static void main(String[] args) {
        MyThreadPriorityEx02 myThread =  new MyThreadPriorityEx02();
    }
}


class MyThreadPriorityEx03 extends Thread{
    @Override
    public void run() {
        System.out.println("Child thread Priority : " + Thread.currentThread().getPriority());
        for(int i = 0 ; i<5; i++){
            System.out.println("Part1 : Child Thread : " + i);
        }
        Thread.yield();
        for(int i = 0 ; i<5; i++) {
            System.out.println("Part2 : Child Thread : " + i);
        }
    }
}

class ThreadPriorityExample03{
    public static void main(String[] args) {
        MyThreadPriorityEx03 myThread = new MyThreadPriorityEx03();
        myThread.start();

        for(int i = 0 ; i<5; i++) {
            System.out.println("Part1 : Main Thread : " + i);
        }
//        Thread.yield();

        for(int i = 0 ; i<5; i++) {
            System.out.println("Part1 : Main Thread : " + i);
        }
    }
}

class MyThreadEx extends Thread{
    MyThreadEx(){
        System.out.println("My Thread");
    }

    @Override
    public void run() {
        System.out.println("bar");
    }

    public void run(String s) {
        System.out.println("baz");
    }
}

class TestThread2{
    public static void main(String[] args) {
        Thread t = new MyThreadEx() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        t.start();
    }
}


