package OCP.Concurrency_2;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Concurrency_2_5 {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.add("A");
        l.add("B");
        l.add("B");
        System.out.println(l);
        CopyOnWriteArrayList cowl = new CopyOnWriteArrayList();
        cowl.addIfAbsent("A");
        cowl.addIfAbsent("B");
        cowl.addIfAbsent("B");
        cowl.addAllAbsent(l);
        System.out.println(cowl);
        cowl.remove(1);
        System.out.println(cowl);
    }
}

class ArrayListRemove2_5{
    public static void main(String[] args) {
        ArrayList <Integer> al =  new ArrayList();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(7);
        al.add(6);
        System.out.println("List before remove operation : " + al);
        Iterator<Integer> it =  al.iterator();
        while (it.hasNext()){
            Integer next = it.next();
            if(next < 6){
                it.remove();
            }
        }
        System.out.println("List after remove operation : " + al);
    }
}
class CopyOnWriteArrayList2_5{
    public static void main(String[] args) {
        CopyOnWriteArrayList <Integer> al =  new CopyOnWriteArrayList();
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(7);
        al.add(6);
        System.out.println("List before remove operation : " + al);
        Iterator<Integer> it =  al.iterator();
        while (it.hasNext()){
            Integer next = it.next();
            if(next < 6){
                it.remove();
            }
        }
        System.out.println("List after remove operation : " + al);
    }
}


class Concurrency_2_5_1 {
    public static void main(String[] args) {
        CopyOnWriteArrayList cowl = new CopyOnWriteArrayList();
        cowl.add(4);
        cowl.add("Ten");
        cowl.add(null);
        cowl.add(true);
        cowl.add("Ten");
        System.out.println(cowl);
    }
}


class Concurrency_2_5_2 {
    public static void main(String[] args) {
        CopyOnWriteArrayList cowl = new CopyOnWriteArrayList();
        cowl.add("A");
        cowl.add("B");
        cowl.add("C");
        Iterator it = cowl.iterator();
        cowl.add("D");
        while (it.hasNext()){
            String s = (String) it.next();
            System.out.println(s);
        }
        System.out.println(cowl);
    }
}

class Concurrency_2_5_3 {
    public static void main(String[] args) {
        ArrayList cowl = new ArrayList();
        cowl.add("A");
        cowl.add("B");
        cowl.add("C");
        Iterator it = cowl.iterator();
        cowl.add("D");
        while (it.hasNext()){
            String s = (String) it.next();
            System.out.println(s);
        }
        System.out.println(cowl);
    }
}

class CopyOnWriteArrayListIterator_2_5_4 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");

        // Create a ListIterator from the CopyOnWriteArrayList
        ListIterator<String> iterator = list.listIterator();

        // Add an element using the ListIterator reference
        iterator.add("Orange");

        System.out.println("List after adding element using ListIterator: " + list);

        try {
            // Attempt to add an element directly using the CopyOnWriteArrayList object
            list.add("Grapes"); // This will throw UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: Cannot add directly using CopyOnWriteArrayList");
        }
    }
}


class ArrayListIterator_2_5_5 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");

        // Create a ListIterator from the ArrayList
        ListIterator<String> iterator = list.listIterator();

        // Add an element using the ListIterator reference
        iterator.add("Orange");

        System.out.println("List after adding element using ListIterator: " + list);

        // Add an element directly using the ArrayList object
        list.add("Grapes");

        System.out.println("List after adding element directly using ArrayList: " + list);
        System.out.println("Once you have taken a snapshot of the AL in an Iterator, \n" +
                "You can use both the iterator object and the original list\n" +
                " object to add any element to the AL. It will not give \n" +
                "UnsupportedOperationException");
        System.out.println("Once you have taken a snapshot of the COWL in\n" +
                " an Iterator, You can only use both the iterator object\n" +
                " to add any element to the COWL. If you use original \n" +
                "COWL object It will throw UnsupportedOperationException");
    }
}

class Set_Example_2_5_6{
    static Set<Employee_2_5> set =  new HashSet<>();
    public static void main(String[] args) {
        set.add(new Employee_2_5(1, "ABC"));
        set.add(new Employee_2_5(2, "DEF"));
        set.add(new Employee_2_5(2, "DEF"));
        System.out.println(set.size());
        System.out.println(set.contains(new Employee_2_5(1, "ABC")));
    }
}

class List_Example_C_6{
    static List<Employee_2_5> list =  new ArrayList<>();

    public static void main(String[] args) {
        list.add(new Employee_2_5(1, "ABC"));
        list.add(new Employee_2_5(2, "DEF"));
        list.add(new Employee_2_5(2, "DEF"));
        System.out.println(list.size());
        System.out.println(list.contains(new Employee_2_5(1, "ABC")));
    }
}



class Employee_2_5{
    private int id;
    private String name;

    public Employee_2_5(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee_2_5)) return false;
        Employee_2_5 that = (Employee_2_5) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        System.out.println("Hash is called.");
        return Objects.hash(id, name);
    }
}

class CopyOnWriteArraySetIterator_2_5_6 extends Thread{

    static CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){

        }
        System.out.println("Child thread trying to update the list");
        set.add("New");
    }

    public static void main(String[] args) {
        set.add("Apple");
        set.add("Banana");

        CopyOnWriteArraySetIterator_2_5_6 t = new CopyOnWriteArraySetIterator_2_5_6();
        t.start();

        // Create an Iterator from the CopyOnWriteArraySet
        Iterator<String> iterator = set.iterator();

        // Add an element using the Iterator reference
        set.add("Orange"); // Allowed when adding using Iterator reference

        System.out.println("Set after adding element using Iterator: " + set);

        try {
            // Attempt to add an element directly using the CopyOnWriteArraySet object
            set.add("Grapes"); // This will throw UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: Cannot add directly using CopyOnWriteArraySet");
        }
        set.forEach(i ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        });
        System.out.println(set);
    }
}
class SetIteratorExample extends Thread{

    static Set<String> set = new HashSet<>();
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){

        }
        System.out.println("Child thread trying to update the list");
        set.add("New");
    }

    public static void main(String[] args) {
        set.add("Apple");
        set.add("Banana");

        CopyOnWriteArraySetIterator_2_5_6 t = new CopyOnWriteArraySetIterator_2_5_6();
        t.start();

        // Create an Iterator from the CopyOnWriteArraySet
        Iterator<String> iterator = set.iterator();

        // Add an element using the Iterator reference
        set.add("Orange"); // Allowed when adding using Iterator reference

        System.out.println("Set after adding element using Iterator: " + set);

        try {
            // Attempt to add an element directly using the CopyOnWriteArraySet object
            set.add("Grapes"); // This will throw UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: Cannot add directly using CopyOnWriteArraySet");
        }
        set.forEach(i ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        });
        System.out.println(set);
    }
}

class ExecutorDemo_2_5{
    public static void main(String[] args) {
        for(int i = 0; i<10;i++){
            Thread t = new Thread(new ExecutorDemo_2_5.Task());
            t.start();
        }
        System.out.println(" Thread name : " + Thread.currentThread().getName());
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(" Thread name : " + Thread.currentThread().getName());
        }
    }
}

class PrintJob_2_5 implements Runnable{
    private String name;

    public PrintJob_2_5(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " Job started by : " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " Job Completed by : " + Thread.currentThread().getName());
    }
}
class ExecutorDemo2{
    public static void main(String[] args) {
        PrintJob_2_5[] pjob = {
                new PrintJob_2_5("ABC"),
                new PrintJob_2_5("DEF"),
                new PrintJob_2_5("HIJ"),
                new PrintJob_2_5("KLM"),
                new PrintJob_2_5("OJK"),
                new PrintJob_2_5("PFG"),
        };
        ExecutorService ex = Executors.newFixedThreadPool(3);
        Arrays.asList(pjob).forEach(ex::submit);
        ex.shutdown();

    }

}