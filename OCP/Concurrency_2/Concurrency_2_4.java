package OCP.Concurrency_2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


class ArrayListConcurrentEx2_4{
    public static void main(String[] args) {
         ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(4);
        al.add(6);
        System.out.println("taking a snapshot of the array list.");
        Iterator it = al.iterator();
        al.remove(2);
        System.out.println(al);
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(al);
    }
}

class ArrayListConcurrentExample{
    public static void main(String[] args) {
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

class Concurrency_2_4_1{
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
                it.remove();}
        }
        System.out.print("updated list : " + al);

    }
}

class Concurrency_2_4_2{
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> cowl = new CopyOnWriteArrayList<>();
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


class ConcurrentHashMapExample_2_4_3 {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        Integer value = map.putIfAbsent("Three", 3);

        // Check the return value to determine if the key was absent and the insertion was successful
        if (value == null) {
            System.out.println("Key 'Three' was absent. Insertion successful.");
        } else {
            System.out.println("Key 'Three' already existed. Insertion failed.");
        }

        // Print the updated map
        System.out.println("Updated Map: " + map);
        map.putIfAbsent("Three", 10);
        System.out.println("Updated Map 'putIfAbsent(\"Three\", 10)' : " + map);

        map.remove("One", 2);
        System.out.println("remove '\"One\", 2' : " + map);
        map.remove("One", 1);
        System.out.println("remove \"One\", 1' : " + map);
        map.remove("Two");
        System.out.println("remove 'Two' using key : " + map);

        map.put("One", 1);
        map.put("Two", 2);
        System.out.println(map);
        map.replace("One", 1, 10);
        System.out.println(" replace(\"One\", 1, 10) : "+ map);
        System.out.println("=========== put ==========");
        map.put("One", 11);
        System.out.println(" put(\"One\", 11) : "+ map);
    }
}


class Concurrent_HM_2_4_4 extends Thread{
    static ConcurrentHashMap <Integer, String> m =  new ConcurrentHashMap<>();

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
        Concurrent_HM_2_4_4 t = new Concurrent_HM_2_4_4();
        t.start();
        Set m1 = m.entrySet();
        Iterator it = m1.iterator();
        while (it.hasNext()){
            Map.Entry each_entry = (Map.Entry) it.next();
            System.out.println("Main thread current value = { " + each_entry.getKey() + " : " + each_entry.getValue() + " }");
            Thread.sleep(4000);
        }
        System.out.println("Outside iterator map value : " + m);
    }
}



