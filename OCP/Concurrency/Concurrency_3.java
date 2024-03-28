package OCP.Concurrency;

import java.util.Scanner;
import java.util.concurrent.locks.*;

public class Concurrency_3 {
    Lock l = new ReentrantLock();
    private int count = 0;
    Condition cond = l.newCondition();
//    await, signal, signalAll
     private void increment(){
         for(int i=0; i<10000; i++){
             count++;
         }
     }

     void firstThread() throws InterruptedException {
         l.lock();
         System.out.println("Waiting...");
         cond.await(); // only be called after acquiring the lock.
//         release the lock and give the other thread to run.
         System.out.println("Got notified in t1");
         System.out.println("t1 started again.");
         System.out.println("count after t2 : " + count);
         try {
             increment();
         }
         catch (Exception e){

         }
         finally {
             l.unlock();
         }
         System.out.println("Completing t1");
     }

     void secondThread() throws InterruptedException {
         Thread.sleep(1000);
         l.lock();
         System.out.println("Press the return key");
         new Scanner(System.in).nextLine();
         System.out.println("Got the return key");
         cond.signalAll();  // only be called after acquiring the lock.
         // notify the other thread waiting that the lock will be released
         // The rest of the code is executed and then the lock will be released
         // If we do not signal or notify the waiting thread, even after the
         // t2 thread has released the lock, t1 will be waiting to
         // be notified.
         System.out.println("Notifying others");
         try {
             increment();
         }
         catch (Exception e){}
         finally {
             l.unlock();
         }

         System.out.println("the lock is released and \n" +
                 "thread t1 can start working on it simultaneously");
         // Simulating a complex task
         int var = 0;
         for(int i=0; i<900000; i++){
             var++;
         }
         System.out.println("I am outside the lock and can be calculated asynchronously \n" +
                 "var = " + var);
         System.out.println("Completing t2");

     }

     void finished(){
         System.out.println(" Final count : " + count);
     }
}

class ReEntrantLockC31{
    public static void main(String[] args) throws InterruptedException {
        Concurrency_3 re = new Concurrency_3();
        Thread t1 =  new Thread(() ->{
                try {
                    re.firstThread();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }
        });
        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    re.secondThread();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        re.finished();
        System.out.println("=========================");
        System.out.println("t1 is given a chance to run due to sleep \n" +
                "in t2. t1 releases the lock using await. t2 takes up the task \n" +
                "and acquires the lock. It uses signal to inform t1 that \n" +
                "the lock will be released. t2 does not release the lock immediately \n" +
                "t2 completes it work and releases the lock. As t1 has been informed, \n" +
                "as soon as t2 releases the lock, t1 acquires the lock and continues \n" +
                "Once the lock has been released by t2 and notified,\n" +
                " t1 acquires the lock and t2 also continuous its task simultaneously");
    }
}


// =========== ReadWriteLockExample
class ReadWriteLockExample{
    ReadWriteLock lock = new ReentrantReadWriteLock();
    private int count = 0;
    void increment(){
        lock.writeLock().lock();
        try{
            System.out.println("Inside writer lock");
            Thread.sleep(8000);
            for(int i = 0; i<50000; i++){
                count = count + 1;
            }
            System.out.println("Writer thread is writing the final \n" +
                    "count as " + count);
        }
        catch (Exception e){

        }
        finally {
            lock.writeLock().unlock();
        }
    }

    int getCount() throws InterruptedException {
        Thread.sleep(1000);
        lock.readLock().lock();
        System.out.println("Inside reader thread : " + Thread.currentThread().getName());
        Thread.sleep(1000);
        try{
            System.out.println("Reader thread is returning the count as " + count);
            return count;
        }
        finally {
            System.out.println("Releasing lock : " + Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }
}

class ReadWriteLockEx{
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample rle = new ReadWriteLockExample();
        Thread t1 = new Thread(() -> {
            try {
                rle.getCount();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                rle.getCount();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t3 = new Thread(() -> {
            rle.increment();
        });

        t3.start();
        t1.start();
        t2.start();
        t3.join();
        t2.join();
        t1.join();
        System.out.println("In the example above as t3 acquired the \n" +
                "lock and slept for 8 seconds. As the lock has been acquired\n" +
                " and either the read or the write operation can happen at a \n" +
                "time, lock has already been acquired by the sleeping thread\n" +
                " t3. Hence t1 and t2 has to wait before the lock is released\n" +
                " and multiple reading locks can be acquired. Hence t1,t2 \n" +
                "waits for 8 seconds and then both of the threads acquire \n" +
                "the locks and can perform read simultaneously.  ");
    }
}

// Lock, condition interface, ReadWriteLockExample

