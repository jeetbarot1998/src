package OCP.Concurrency;

import java.awt.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrency_5 {
}

class ArrayListConcurrentEx5{
    public static void main(String[] args) {
        System.out.println("List.Iterators are not thread safe \n" +
                "If a thread is iterating on the collection and if \n" +
                "the collection is modified even by the same thread \n" +
                "it will give cme.\n" +
                "When you make an iterator object internally jvm\n" +
                "thinks that it will be iterated upon now hence you \n" +
                "are not supposed to change it as it will give cme");
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(4);
        al.add(6);
        System.out.println("taking a snapshot of the array list.");
        Iterator it = al.iterator();
        al.remove(2);
        System.out.println("Cannot iterate over the array list w/o \n" +
                "getting an exception as the array list has been changed \n" +
                "after taking a snapshot on line 24");
        System.out.println(al);
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(al);
    }
}

class ArrayListConcurrentEx51{
    public static void main(String[] args) {
        System.out.println("List.Iterators are not thread safe \n" +
                "If a thread is iterating on the collection and if \n" +
                "the collection is modified even by the same thread \n" +
                "it will give cme.\n" +
                "When you make an iterator object internally jvm\n" +
                "thinks that it will be iterated upon now hence you \n" +
                "are not supposed to change it as it will give cme");
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(4);
        al.add(6);
        System.out.println("removing an element before taking the snapshot and is hence fine");
        al.remove(2);
        System.out.println("Taking a snapshot of the array.");
        Iterator it = al.iterator();
        System.out.println(al);
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(al);
    }
}

class Concurrency_51{
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(4);
        al.add(6);
        Iterator it = al.iterator();
        while (it.hasNext()){
            Integer num = (Integer) it.next();
            System.out.println(num);
            if(num > 4){
//                you can use the iterator ref to remove but cannot use the original reference
                it.remove();
//                al.add(9); // cannot alter the original collection as it is being
//                iterated simultaneously.
            }
        }
        System.out.print("updated list : " + al);

    }
}

class Concurrency_52{
    public static void main(String[] args) {
        System.out.println("CopyOnWriteArrayList IS IMMUTABLE IN NATURE");
        CopyOnWriteArrayList <Integer> cowl = new CopyOnWriteArrayList<>();
        cowl.add(5);
        cowl.add(3);
        cowl.add(1);
        Iterator <Integer> it = cowl.iterator();
        while (it.hasNext()){
            Integer num = it.next();
            if(num > 4){
                cowl.add(9);
            }
            System.out.println(num);
        }
        System.out.println(cowl);
    }
}


class ConcurrentHashMapExample5_4 {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Put some initial values in the map
        map.put("One", 1);
        map.put("Two", 2);

        // Insert a new key-value pair if the key "Three" is absent
        Integer value = map.putIfAbsent("Three", 3);

        // Check the return value to determine if the key was absent and the insertion was successful
        if (value == null) {
            System.out.println("Key 'Three' was absent. Insertion successful.");
        } else {
            System.out.println("Key 'Three' already existed. Insertion failed.");
        }

        System.out.println("=========== putIfAbsent ==========");
        // Print the updated map
        System.out.println("Updated Map: " + map);
        map.putIfAbsent("Three", 10);
        System.out.println("Updated Map 'putIfAbsent(\"Three\", 10)' : " + map);

        System.out.println("=========== remove ==========");
        map.remove("One", 2);
        System.out.println("remove '\"One\", 2' : " + map);
        map.remove("One", 1);
        System.out.println("remove \"One\", 1' : " + map);
        map.remove("Two");
        System.out.println("remove 'Two' using key : " + map);

        map.put("One", 1);
        map.put("Two", 2);
        System.out.println("=========== replace ==========");
        System.out.println(map);
        map.replace("One", 1, 10);
        System.out.println(" replace(\"One\", 1, 10) : "+ map);
        System.out.println("=========== put ==========");
        map.put("One", 11);
        System.out.println(" put(\"One\", 11) : "+ map);
    }
}

class UserBankAccount{
    private int balance = 10000;
    public void deposit(int amt){balance += amt;}
    public void withdraw(int amt){balance -= amt;}
    int getBalance(){return balance;}
    public Lock myLock = new ReentrantLock();
}

class Concurrency_53{

    void fetchLock(UserBankAccount acc1, UserBankAccount acc2){
        while (true){
            boolean gotLock1 = false;
            boolean gotLock2 = false;
            try {
                gotLock1 = acc1.myLock.tryLock();
                gotLock2 = acc2.myLock.tryLock();
            }
            finally {
                if(gotLock1 & gotLock2){
                    return;
                }
                if(gotLock1){
                    acc1.myLock.unlock();
                }
                if(gotLock2){
                    acc2.myLock.unlock();
                }
            }
        }
    }

    void firstThread(UserBankAccount acc1, UserBankAccount acc2){
        Random r = new Random();
        for (int i = 0;i<10000; i++){
            try{
                fetchLock(acc1,acc2);
                int amount = r.nextInt(100);
                acc1.withdraw(amount);
                acc2.deposit(amount);
            }
            finally {
                acc1.myLock.unlock();
                acc2.myLock.unlock();
            }
        }
    }
    void secondThread(UserBankAccount acc1, UserBankAccount acc2){
        Random r = new Random();
        for (int i = 0;i<10000; i++){
            try{
                fetchLock(acc1,acc2);
                int amount = r.nextInt(100);
                acc2.withdraw(amount);
                acc1.deposit(amount);
            }
            finally {
                acc1.myLock.unlock();
                acc2.myLock.unlock();
            }
        }
    }

    void finished(UserBankAccount acc1, UserBankAccount acc2){
        System.out.println("acc1 balance = " + acc1.getBalance());
        System.out.println("acc2 balance = " + acc2.getBalance());
        System.out.println(acc1.getBalance() + acc2.getBalance() + " == Balance ");
    }

    public static void main(String[] args) throws InterruptedException {
        UserBankAccount acc1 = new UserBankAccount();
        UserBankAccount acc2 = new UserBankAccount();
        Concurrency_53 runner = new Concurrency_53();
        Thread t1 = new Thread(() ->{
            try {
                runner.firstThread(acc1, acc2);
            }
            catch (Exception e){
            }
        });
        Thread t2 = new Thread(() ->{
            try {
                runner.secondThread(acc1, acc2);
            }
            catch (Exception e){
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        runner.finished(acc1,acc2);
    }
}

class Concurrent_HM_52 extends Thread{
    static ConcurrentHashMap <Integer, String> m =  new ConcurrentHashMap();

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
        }
        catch (Exception e){
        }
        System.out.println("Child thread updating the map");
        m.put(100, "A");
    }

    public static void main(String[] args) throws InterruptedException {
        m.put(110,"C");
        m.put(103,"B");
        Concurrent_HM_52 t = new Concurrent_HM_52();
        t.start();
        Set m1 = m.entrySet();
        Iterator it = m1.iterator();
        while (it.hasNext()){
            Map.Entry each_entry = (Map.Entry) it.next();
            System.out.println("Main thread current value = { " + each_entry.getKey() + " : " + each_entry.getValue() + " }");
            Thread.sleep(4000);
            System.out.println("Main thread after sleeping \n" +
                    "current value = { " + each_entry.getKey() + " : " + each_entry.getValue() + " }");
        }
        System.out.println("Outside iterator : " + m);
    }
}



