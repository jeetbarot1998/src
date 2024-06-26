package OCP.Concurrency_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class UserBankAccount{
    private int balance = 10000;
    private void deposit(int amt){balance += amt;}
    private void withdraw(int amt){balance -= amt;}
    int getBalance(){return balance;}
    public static synchronized void tx(UserBankAccount acc1, UserBankAccount acc2, int amt){
        acc1.withdraw(amt);
        acc2.deposit(amt);
    }

    public static void tx2(UserBankAccount acc1, UserBankAccount acc2, int amt){
        acc1.withdraw(amt);
        acc2.deposit(amt);
    }
}
public class Concurrency_2_3 {
    private UserBankAccount acc1 = new UserBankAccount();
    private UserBankAccount acc2 = new UserBankAccount();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void acquireLock(){
        boolean gotFirstLock =  false;
        boolean gotSecondLock =  false;
        while (true){
            try {
                gotFirstLock = lock1.tryLock();
                gotSecondLock = lock2.tryLock();
            }
            finally {
                if(gotFirstLock && gotSecondLock){
                    return;
                }
                if(gotFirstLock){
                    lock1.unlock();
                }
                if(gotSecondLock){
                    lock2.unlock();
                }
            }
        }
    }

    void firstThread() throws InterruptedException{
        Random r = new Random();
        for(int i = 0;i<10000;i++){
//            lock1.lock();
//            Thread.sleep(1000);
//            lock2.lock();
            acquireLock();
            try {
                UserBankAccount.tx(acc1,acc2, r.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    void secondThread() throws InterruptedException{
        Random r = new Random();
        for(int i = 0;i<10000;i++){
//            lock2.lock();
//            Thread.sleep(1000);
//            lock1.lock();
            acquireLock();
            try {
                UserBankAccount.tx(acc2,acc1, r.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    void finished(){
        System.out.println("acc1 balance = " + acc1.getBalance());
        System.out.println("acc2 balance = " + acc2.getBalance());
        System.out.println(acc1.getBalance() + acc2.getBalance() + " == Balance ");
    }
}


class MyConcurrentThreadC41{
    public static void main(String[] args) throws InterruptedException {
        Concurrency_2_3 runner = new Concurrency_2_3();
        Thread t1 = new Thread(() ->{
            try {
                runner.firstThread();
            }
            catch (Exception e){
            }
        });
        Thread t2 = new Thread(() ->{
            try {
                runner.secondThread();
            }
            catch (Exception e){
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        runner.finished();
    }
}

class ConcurrentHashMapEx{
    static ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        chm.put(1, "M");
        chm.put(2, "N");
        chm.put(4, "K");
        chm.forEach((i,j) -> {
            System.out.println(i + " : " + j);
        });
    }
}

class CMEDemoThread extends Thread{
    static List<String> al = new ArrayList<>();

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){}
        System.out.println("Child thread trying to update the list");
        al.add("New");
    }

    public static void main(String[] args) {
        al.add("A");
        al.add("B");
        al.add("C");
        CMEDemoThread cme = new CMEDemoThread();
        cme.start();
        al.forEach(each_str -> {
            System.out.println("Main thread " + each_str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
        });
        System.out.println(al);
    }
}


class CopyOnWriteDemoThread extends Thread{
    static CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<>();

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){}
        System.out.println("Child thread trying to update the list");
        al.add("New");
    }

    public static void main(String[] args) throws InterruptedException {
        al.add("A");
        al.add("B");
        al.add("C");
        CopyOnWriteDemoThread cme = new CopyOnWriteDemoThread();
        cme.start();
        al.forEach(each_str -> {
            System.out.println("Main thread " + each_str);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(al);
    }
}


class ArrayListConcurrentEx{
    public static void main(String[] args) {
        System.out.println("List.Iterators are not thread safe \n" +
                "If a thread is iterating on the collection and if \n" +
                "the collection is modified even by the same thread \n" +
                "it will give cme.\n" +
                "When you make an iterator object internally jvm\n" +
                "thinks that it will be iterated upon now hence you \n" +
                "are not supposed to change it as it will give cme");



        
        ArrayList <Integer> al = new ArrayList<>();
        al.add(2);
        al.add(4);
        al.add(6);
        Iterator it = al.iterator();
        al.remove(2);
        System.out.println(al);
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(al);
    }
}



class PrinterResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void printDocument(String document, String threadName) throws InterruptedException {
        lock.lockInterruptibly(); // Attempt to acquire the lock, can be interrupted
        try {
            System.out.println(threadName + " is printing: " + document);
            Thread.sleep(2000); // Simulating printing time
        } finally {
            lock.unlock(); // Release the lock
            System.out.println(threadName + " finished printing.");
        }
    }

    public static void main(String[] args) {
        PrinterResource printer = new PrinterResource();

        Thread urgentPrintTask = new Thread(() -> {
            try {
                printer.printDocument("URGENT Document", "UrgentTaskThread");
            } catch (InterruptedException e) {
                System.out.println("Urgent task interrupted while waiting for the printer.");
            }
        });

        Thread normalPrintTask = new Thread(() -> {
            try {
                printer.printDocument("Normal Document", "NormalTaskThread");
            } catch (InterruptedException e) {
                System.out.println("Normal task interrupted while waiting for the printer.");
            }
        });

        urgentPrintTask.start();

        // Simulating a delay before starting the normal print task
        try {
            Thread.sleep(1000); // Delay of 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        normalPrintTask.start();

        // Interrupting the urgent print task after a delay
        try {
            Thread.sleep(500); // Delay of 0.5 seconds
            urgentPrintTask.interrupt(); // Interrupt the urgent print task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
