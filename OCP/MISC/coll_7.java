package OCP.MISC;

import java.io.*;
import java.util.*;

public class coll_7 {
}

class SortedMapDemo{
    public static void main(String[] args) {
        TreeMap t = new TreeMap();
        t.put(100, "Hundred");
        t.put(200, "Two Hundred");
        t.put(300, "Three Hundred");
        t.put(400, "Four Hundred");
        t.put(500, "Five Hundred");
        System.out.println(t);
        System.out.println(t.firstKey());
        System.out.println(t.lastEntry());
        System.out.println(t.headMap(106));
        System.out.println(t.tailMap(110));
        System.out.println(t.subMap(104,120));
        System.out.println(t.subMap(104,true,120,true));
        System.out.println(t.comparator());
        System.out.println(t.remove(1));
        System.out.println(t.remove(100));
    }
}




class NavigableMapDemo{
    public static void main(String[] args) {
        TreeMap<Integer, String> t = new TreeMap<>();
        t.put(100, "Hundred");
        t.put(200, "Two Hundred");
        t.put(300, "Three Hundred");
        t.put(400, "Four Hundred");
        t.put(500, "Five Hundred");
        System.out.println(t);
        System.out.println("ceiling 200 : " + t.ceilingKey(200));
        System.out.println("higher 200 : " + t.higherKey(200));
        System.out.println("ceiling 250 : " + t.ceilingKey((250)));
        System.out.println("higher 250 : " + t.higherKey(250));
        System.out.println("floor 200 : " + t.floorKey(200));
        System.out.println("lower 200 : " + t.lowerKey(200));
        System.out.println("floor 350 : " + t.floorKey(350));
        System.out.println("lower 350 : " + t.lowerKey(350));
        System.out.println(t.pollFirstEntry());
        System.out.println(t.pollLastEntry());
        System.out.println(t.descendingKeySet());

    }
}

class PriorityQueueExample2 {
    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue();
        try{
            System.out.println(pq.element());
        }
        catch (NoSuchElementException nse){
            System.out.println("No such element if queue is empty");
        }
        System.out.println(pq.peek()); // returns null
//        System.out.println(pq.remove()); // returns exception
        for(int i = 0;i<=10;i++){
            pq.offer(i);
        }
        System.out.println(pq.remove(5));
        System.out.println(pq.remove(100));
        System.out.println(pq); // Print queue.
        System.out.println(pq.poll());
//      removes head element and returns it. returns 0.
        System.out.println(pq); // returns queue after removing head element.
        // It might not print in sequence. Depends on platform
    }
}

class PriorityQueueExample {
    public static void main(String[] args){
        // Creating Priority queue constructor having
        // initial capacity=5 and a StudentComparator instance
        // as its parameters
        PriorityQueue<Student7> pq = new
                PriorityQueue<Student7>(5, new StudentComparator());

        // Invoking a parameterized Student constructor with
        // name and cgpa as the elements of queue
        Student7 student1 = new Student7("ABC", 3.2);

        // Adding a student object containing fields
        // name and cgpa to priority queue
        pq.add(student1);
        Student7 student3 = new Student7("EFG", 4.0);
        pq.add(student3);
        Student7 student2 = new Student7("CDE", 3.6);
        pq.add(student2);

        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);

        // Printing names of students in priority order,poll()
        // method is used to access the head element of queue
        System.out.println("Students served in their priority order");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getName());
        }
    }
}

class StudentComparator implements Comparator<Student7>{

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(Student7 s1, Student7 s2) {
        if (s1.cgpa < s2.cgpa)
            return 1;
        else if (s1.cgpa > s2.cgpa)
            return -1;
        return 0;
    }
}

class Student7 {
    public String name;
    public double cgpa;

    public Student7(String name, double cgpa) {

        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: " + name  +", cgpa: " + cgpa ;
    }
}


class PropertiesExample{
    public static void main(String[] args) throws IOException{
        Properties p = new Properties();
        String address = "C:\\Users\\barot\\IdeaProjects\\test\\src\\OCP\\MISC\\db.properties";
        FileInputStream fis = new FileInputStream(address);
        p.load(fis);
        System.out.println(p);
        System.out.println(p.getProperty("INVALID"));
        System.out.println(p.getProperty("URL"));
        p.setProperty("NAME", "OGF");
        System.out.println(p.getProperty("URL"));
        FileOutputStream fos = new FileOutputStream(address);
        p.store(fos,"Updated by user");
    }
}
