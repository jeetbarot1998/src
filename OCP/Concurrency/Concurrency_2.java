package OCP.Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrency_2  {
}

class ReEntrantLockDemoC_2{
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

// ============== WO Locks
class ReEntrantLockDemoC_23{
    private int count = 0;
//    private Lock l = new ReentrantLock();

    private void increment(){
        for(int i = 0; i<10000; i++){
//            System.out.println(Thread.currentThread().getName());
            count++;
        }
    }

    void firstThread(){
//        l.lock();
        try{
            increment();
        }
        catch (Exception ex){}
        finally {
//            l.unlock();
        }
    }

    void secondThread(){
//        l.lock();
        increment();
//        l.unlock();
    }

    void finished(){
        System.out.println("Result is " + count);
    }
}


class ReEntrantDemoC24{
    public static void main(String[] args) throws InterruptedException {
        ReEntrantLockDemoC_23 re = new ReEntrantLockDemoC_23();
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

// ============== With Lock

class ReEntrantLockDemoC_24{
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
        ReEntrantLockDemoC_24 re = new ReEntrantLockDemoC_24();
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

