package OCP.Concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrency_1 {
}

class DisplayC1{
    Lock l =  new ReentrantLock();
    void wish(String name){
        try{
            l.lock();
            for (int i = 0 ; i<5;i++){
                System.out.println("Good morning : " + name);
                try {
                    Thread.sleep(500);
                }
                catch (Exception e){
                }
            }
        }
        finally {
            System.out.println(" ======= ");
            l.unlock();
        }
    }

    synchronized void wishsync(String name){
        for (int i = 0 ; i<5;i++){
            System.out.println("Good morning : " + name);
            try {
                Thread.sleep(500);
            }
            catch (Exception e){

            }
        }
    }
}

class MyThreadC1 extends Thread{
    DisplayC1 d;
    String name;
    MyThreadC1(DisplayC1 d, String name){
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}

class SyncDemoC1{
    public static void main(String[] args) {
        DisplayC1 d = new DisplayC1();
        MyThreadC1 mt = new MyThreadC1(d, "ABC");
        MyThreadC1 mt1 = new MyThreadC1(d, "CDE");
        MyThreadC1 mt2 = new MyThreadC1(d, "EFG");
        mt.start();
        mt1.start();
        mt2.start();
    }
}


// ===== With tryLock => Never enter into wait state

class ReEntrantDemoC1 extends Thread{
    static ReentrantLock l = new ReentrantLock();
    ReEntrantDemoC1(String name){
        super(name);
    }

    @Override
    public void run() {
        if(l.tryLock()){
            System.out.println(Thread.currentThread().getName() + "\n " +
                    "Got the thread and now performs thread safe operations.");
            try {
                Thread.sleep(500);
            }
            catch (Exception e){

            }
            finally {
                l.unlock();
            }
        }
        else{
            System.out.println(Thread.currentThread().getName() + "\n " +
                    "Did not get the lock, performing alternate operations.");

        }
    }
}

class ReEntrantLockDemoC2{
    public static void main(String[] args) {
        ReEntrantDemoC1 t1 = new ReEntrantDemoC1("First Thread");
        ReEntrantDemoC1 t2 = new ReEntrantDemoC1("Second Thread");
        t1.start();
        t2.start();
    }
}


// ======= tryLock with argument
class ReEntrantDemoC3 extends Thread{
    static ReentrantLock l = new ReentrantLock();
    ReEntrantDemoC3(String name){
        super(name);
    }

    @Override
    public void run() {
        do{
            try {
                if(l.tryLock(2, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName() + "\n " +
                            "Got the thread and now performs thread safe operations.");
                    System.out.println(Thread.currentThread().getName() + "\n " + "" +
                            " is going to perform operation which takes 5 seconds");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + "\n " +
                            "Releasing the lock");

                    l.unlock();
                    break;
                }
                else {
                    System.out.println(Thread.currentThread().getName() + "\n " +
                            "Did not get the lock, performing alternate operations.\n" +
                            "And will try to get the lock every 2 second again");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while (true);
    }
}

class ReEntrantLockDemoC3{
    public static void main(String[] args) throws InterruptedException {
        ReEntrantDemoC3 t1 = new ReEntrantDemoC3("First Thread");
        ReEntrantDemoC3 t2 = new ReEntrantDemoC3("Second Thread");
        t1.start();
        t2.start();
        t1.join();
        t1.join();
        System.out.println("All operations completed.");
    }
}



class AtomicIntegerExample {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet(); // Atomically increment the counter
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet(); // Atomically increment the counter
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

        System.out.println("Final counter value: " + counter.get());
    }
}

class NonAtomicIntegerExample {
    private volatile static Integer counter = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter++; // Atomically increment the counter
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter++; // Atomically increment the counter
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

        System.out.println("Final counter value: " + counter);
    }
}

class ProducerConsumerDemo1{
    private static BlockingQueue<Integer> queue =  new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    produce();
                }
                catch (Exception e){}
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    consume();
                }
                catch (Exception e){}
            }
        });

        t1.start();
        t2.start();
    }

    private static void produce() throws InterruptedException{
        Random random = new Random();
        while (true){
            queue.put(random.nextInt(100));
        }
    }

    private static void consume() throws InterruptedException{
        Random random = new Random();
        while (true){
            Thread.sleep(100);
            if(random.nextInt(10) == 0){
                final Integer value  = queue.take();
                System.out.println("Value taken = "+ value + "Queue size = " + queue.size());
            }
        }
    }
}

// Lock, its methods, Blockingqueue, ReentrantLock, Volatile, Atomic

