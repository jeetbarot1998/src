package OCP.Thread;

public class Thread_1 extends Thread {
    static Thread mt;
    @Override
    public void run() {
        try{
            System.out.println("Joining");
            mt.join();
        }
        catch (InterruptedException e){
            for(int i = 0; i<10; i++){
                System.out.println("Child Thread : " + i);
            }
        }
    }
}

class ChildThreadJoinMainMethod{
    public static void main(String[] args) throws InterruptedException {
        Thread_1.mt = Thread.currentThread();
        Thread_1 t = new Thread_1();
        t.start();
        for(int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
//            Thread.sleep(1000);
        }
    }
}


// ======== DEADLOCK

class MyThreadDeadLockDemo extends Thread {
    static Thread mt;
    @Override
    public void run() {
        try{
            System.out.println("Joining");
            mt.join();
        }
        catch (InterruptedException e){
            for(int i = 0; i<10; i++){
                System.out.println("Child Thread : " + i);
            }
        }
    }
}

class ChildThreadJoinMainMethod2{
    public static void main(String[] args) throws InterruptedException {
        MyThreadDeadLockDemo.mt = Thread.currentThread();
        MyThreadDeadLockDemo t = new MyThreadDeadLockDemo();
        t.start();
        t.join(); // Both of are attempting to join
        for(int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
//            Thread.sleep(1000);
        }
    }
}


// ======= Main thread waiting for itself to complete (deadlock-2)
class MainThreadJoiningItselfDemo{
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().join();
        System.out.println("Hello I am waiting for the main thread to complete");
    }
}

// ======= Sleep method.
class SlideRotator {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("Slide : " + i);
            Thread.sleep(1000);
        }
    }
}


// ======== Interrupt a thread

class InterruptThreadDemo1 extends Thread{
    public void run(){
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println("lazy child thread : " + i);
                Thread.sleep(2000);
            }
        }
        catch (Exception e){
            System.out.println("I got interrupted");
        }
    }
}

class InterruptDemo1{
    public static void main(String[] args) {
        InterruptThreadDemo1 thread = new InterruptThreadDemo1();
        thread.start();
        System.out.println("Target thread must be in sleeping or wait state. \n" +
                "If not then no exception is thrown");
        thread.interrupt();
        System.out.println("Main Thread");
    }
}

class InterruptThreadDemo2 extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("lazy child thread : " + i);
        }
        try{
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("I got interrupted");
        }
    }
}

class InterruptDemo3{
    public static void main(String[] args) {
        InterruptThreadDemo2 thread = new InterruptThreadDemo2();
        thread.start();
        System.out.println("Target thread must be in sleeping or wait state. \n" +
                "If not then no exception is thrown");
        thread.interrupt();
        System.out.println("Main Thread");
    }
}

class ThreadX {
    private int count = 0;

    public synchronized void m1() {
        // This is a synchronized method
        count++;
    }

    public synchronized int m2() {
        // This is also a synchronized method
        return count;
    }
    public synchronized void m3() {
        // This is a synchronized method
        count++;
    }

    public void m4() {
        // This is not a synchronized method

    }

}

class SynchronizedLockExample {
    public static void main(String[] args) {
        ThreadX obj = new ThreadX();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("t1");
                obj.m1();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("t2");
                obj.m1();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + obj.m2());
    }
}


class CounterThread_1 {
    private int count = 0;

    public synchronized void increment() {
        // This is a synchronized method
        count++;
        System.out.println("Incremented by " + Thread.currentThread().getName());
    }

    public synchronized int getCount() {
        // This is also a synchronized method
        return count;
    }
}

class SynchronizationPerObject2 {
    public static void main(String[] args) throws InterruptedException {
        CounterThread_1 counter1 = new CounterThread_1();
        CounterThread_1 counter2 = new CounterThread_1();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                counter1.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                counter2.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Count from counter1: " + counter1.getCount());
        System.out.println("Count from counter2: " + counter2.getCount());
    }
}

