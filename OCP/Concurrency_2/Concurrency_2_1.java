package OCP.Concurrency_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrency_2_1{
    public static void main(String[] args) {
        Lock l = new ReentrantLock(true);
        l.lock();
        l.lock();
        System.out.println(((ReentrantLock)l).getHoldCount());
        System.out.println(((ReentrantLock)l).isHeldByCurrentThread());
        System.out.println(((ReentrantLock)l).getQueueLength());
        l.unlock();
        System.out.println(((ReentrantLock)l).getHoldCount());
        System.out.println(((ReentrantLock)l).isLocked());
        l.unlock();
        System.out.println(((ReentrantLock)l).isLocked());
        System.out.println(((ReentrantLock)l).isFair());
    }
}

class ReEntrantLockDemoC_22{
    private int count = 0;
    private Lock l = new ReentrantLock();

    private void increment(){
        for(int i = 0; i<10000; i++){
//            System.out.println(Thread.currentThread().getName());
            count++;
        }
    }

    void firstThread(){
        l.lock();
        try{
            increment();
        }
        catch (Exception ex){}
        finally {
            l.unlock();
        }
    }

    void secondThread(){
        l.lock();
        increment();
        l.unlock();
    }

    void finished(){
        System.out.println("Result is " + count);
    }
}

class ReEntrantDemoC25{
    public static void main(String[] args) throws InterruptedException {
        ReEntrantLockDemoC_22 re = new ReEntrantLockDemoC_22();
        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                re.firstThread();
            }
        });
        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                re.secondThread();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        re.finished();
    }
}


