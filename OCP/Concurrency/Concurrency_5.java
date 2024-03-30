package OCP.Concurrency;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

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






