package OCP.MISC;

import java.util.*;

public class coll_6 {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        m.put("D", 3);
        m.put("A", 1);
        m.put("E", 9);
        m.put("B", 2);
        m.put("C", 1);

        Map<String, Integer> result = new HashMap<>();
        m.forEach((key, value) -> {
            if (key.equals("E")) {
                result.put(key, value);
            }
        });

        System.out.println("Result Map: " + result);
        Set set = m.keySet();
        System.out.println(set);
        Collection values = m.values();
        System.out.println(values);
        System.out.println(m.put("D", 7));
        Set entrySet = m.entrySet();
        Iterator iter = entrySet.iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) (iter.next());
            System.out.println("KEY : " + entry.getKey() + " VALUE : " + entry.getValue());
            if(entry.getKey() == "A"){
                entry.setValue(0);
            }
        }
        System.out.println(m);
        System.out.println("============= USING For Loops. ============= ");
        for (Iterator it = m.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) (it.next());
            System.out.println("KEY : " + entry.getKey() + " VALUE : " + entry.getValue());
        }

        for(Map.Entry<String,Integer> entry: m.entrySet()){
            System.out.println("KEY : " + entry.getKey() + " VALUE : " + entry.getValue());
        }
    }
}



class HashMapDemo{
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        System.out.println("go to bucket as hash is 5 and save the obj and key as 'A' with value 1");
        hm.put(new Emp61(5, "A"), 1);
        System.out.println("go to bucket as hash is 4 and save the obj and key as 'B' with value 2");
        hm.put(new Emp61(4, "B"), 2);
        System.out.println("go to bucket as hash is 2 and save the obj and key as 'D' with value 4");
        hm.put(new Emp61(2, "D"), 4); // go to bucket as hash is 2 and save the obj and key as "D"
        System.out.println("go to bucket as hash is 1 and save the obj and key as 'E' with value 5");
        hm.put(new Emp61(1, "E"), 5); // go to bucket as hash is 1 and save the obj and key as "E"
        System.out.println(hm);
        System.out.println("go to bucket as hash 1. As objects already \n" +
                "exists, then check if the object is equals to any of\n" +
                " the existing object in the bucket. If yes then replace.\n" +
                " If no then append to the bucket in Linked List.\n");
        hm.put(new Emp61(1, "E"), 6);
        System.out.println(hm);
        System.out.println(hm.get(new Emp61(1, "E"))); // This gives null as there
        // is no object which gives equals as true
        for (Iterator it = hm.entrySet().iterator(); it.hasNext();){
            Map.Entry entry = (Map.Entry) (it.next());
            System.out.println("KEY : " + entry.getKey() + " VALUE : " + entry.getValue());
        }
    }
}

class Emp61{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + id;
    }

    public Emp61(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

//    @Override
//    public boolean equals(Object obj) {
//        System.out.println("Called equals");
//        if(obj instanceof Emp61){
//            Emp61 new_obj = (Emp61) obj;
//            return this.getId() == new_obj.getId();
//        }
//        return false;
//    }
}

class HashSetDemo61{
    public static void main(String[] args) {
        HashSet hm = new HashSet();
        hm.add(new Emp61(5, "A"));
        hm.add(new Emp61(4, "B"));
        hm.add(new Emp61(2, "D"));
        hm.add(new Emp61(1, "E"));
        System.out.println(hm);
        hm.add(new Emp61(5, "A"));
        System.out.println(hm);

    }
}


class SortedSetDemo{
    public static void main(String[] args) {
        TreeSet t = new TreeSet();
        t.add(100);
        t.add(101);
        t.add(104);
        t.add(106);
        t.add(110);
        t.add(115);
        t.add(120);
        System.out.println(t);
        System.out.println(t.first());
        System.out.println(t.last());
        System.out.println(t.headSet(106));
        System.out.println(t.tailSet(110));
        System.out.println(t.subSet(104,120));
        System.out.println(t.subSet(104,true,120,true));
        System.out.println(t.comparator());
        System.out.println(t.remove(1));
    }
}

class NavigableSetDemo{
    public static void main(String[] args) {
        TreeSet <Integer> t = new TreeSet<Integer>();
        t.add(100);
        t.add(200);
        t.add(300);
        t.add(400);
        t.add(500);
        System.out.println(t);
        System.out.println("ceiling 200 : " + t.ceiling(200));
        System.out.println("higher 200 : " + t.higher(200));
        System.out.println("ceiling 250 : " + t.ceiling(250));
        System.out.println("higher 250 : " + t.higher(250));
        System.out.println("floor 200 : " + t.floor(200));
        System.out.println("lower 200 : " + t.lower(200));
        System.out.println("floor 350 : " + t.floor(350));
        System.out.println("lower 350 : " + t.lower(350));
        System.out.println(t.pollFirst());
        System.out.println(t.pollLast());
        System.out.println(t.descendingSet());

    }
}
