package OCP.MISC;
import java.util.*;

class LinkedListDemo{
    public static void main(String[] args) {
        LinkedList m = new LinkedList();
        m.add("A");
        m.add(2);
        m.add("2");
        m.add(null);
        System.out.println(m);
        m.set(0,"B");
        m.add(0,"Start");
        m.removeLast();
        m.addFirst("New Start");
        System.out.println(m);
    }
}


class ArrayListDemo2{
    public static void main(String[] args) {
        ArrayList m = new ArrayList();
        m.add("A");
        m.add(2);
        m.add("2");
        m.add(null);
        System.out.println(m);
        m.remove(2);
        System.out.println(m);
        m.add(2,"M");
        m.add("N");
        System.out.println(m);

    }
}


class HashSetDemo extends HashSet{
    public static void main(String[] args) {
        HashSetDemo hsd = new HashSetDemo();
        hsd.add("A");
        hsd.add("A");
        System.out.println(hsd);

        hsd = new HashSetDemo();
        Employee31 e = new Employee31("A");
        System.out.println("Before Inserted A");
        hsd.add(e);
        System.out.println("Inserted A");
        hsd.add(new Employee31("B"));
        System.out.println("Inserted B");
        hsd.add(new Employee31("A"));
        System.out.println("Inserted A again");
        System.out.println(hsd);
        System.out.println("Before insertion the `HashSet` data Structure checks \n" +
                "if the hash of object we are trying to insert already exits or not.\n" +
                " If yes then it checks by passing the already existing object having \n" +
                "the same hash to the equals method of the new object we are trying \n" +
                " to insert and check for true or false. If true then it does not \n" +
                " insert. If false then updates it with the new value.");

        System.out.println(new Employee31("A").equals(new Employee31("A")));
    }
}


class Employee31{
    private String name;

    public Employee31(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Equals by " + this.getName()  + " having HASH: " +  Objects.hash(this.name));
        if (o instanceof Employee31){
            System.out.println("Equals on " + ((Employee31) o).getName() + " having HASH: " + Objects.hash(((Employee31) o).getName()));
            if (((Employee31) o).getName().equals(this.name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        System.out.println("Hash called " + this.getName() + " having hash : " + Objects.hash(name));
        return Objects.hash(name);
    }

//    @Override
//    public String toString(){
//        return this.getName();
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class TreeSetDemo{
    public static void main(String[] args) {
        System.out.println("Objects.hash(null) : "  + Objects.hash(null));
        TreeSet ts =  new TreeSet(); // Using default ordering
        MyCustomClass mcc2 = new MyCustomClass("C");
        MyCustomClass mcc1 = new MyCustomClass("B");
        MyCustomClass mcc = new MyCustomClass("A");
        MyCustomClass mcc3 = new MyCustomClass("A");
        ts.add(mcc2);
        System.out.println("Insert mcc2");
        ts.add(mcc1);
        System.out.println("Insert mcc1");
        ts.add(mcc);
        System.out.println("Insert mcc");
        ts.add(mcc3);
        System.out.println("Insert mcc3");
        System.out.println(ts);
    }
}


class MyCustomClass implements Comparable{
    private String name;

    public MyCustomClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        System.out.println("Called compareTo from Comparable");
        MyCustomClass obj = (MyCustomClass) o;
        return obj.getName().compareTo(this.getName());
    }

    @Override
    public String toString(){
        return this.getName() + " - " + hashCode() + " - " +  Objects.hash(name);
    }
}

class MyCustomClass2{
    private String name;

    public MyCustomClass2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return this.getName() + " - " + hashCode() + " - " +  Objects.hash(name);
    }
}
class TreeSetDemo2{
    public static void main(String[] args) {
        Comparator c = new MyComparator();
        TreeSet ts =  new TreeSet(c); // Using custom ordering
        MyCustomClass2 mcc2 = new MyCustomClass2("C");
        MyCustomClass2 mcc1 = new MyCustomClass2("B");
        MyCustomClass2 mcc = new MyCustomClass2("A");
        MyCustomClass2 mcc3 = new MyCustomClass2("A");
        ts.add(mcc2);
        System.out.println("Insert mcc2");
        ts.add(mcc1);
        System.out.println("Insert mcc1");
        ts.add(mcc);
        System.out.println("Insert mcc");
        ts.add(mcc3);
        System.out.println("Insert mcc3");
        System.out.println(ts);
    }
}
class MyComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        System.out.println("Called compare form Comparator");
        return ((MyCustomClass2) o1).getName().compareTo(((MyCustomClass2) o2).getName());
    }
}

class LinkedHashSetDemo{
    public static void main(String[] args) {
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add("a");
        lhs.add("b");
        lhs.add("a");
        lhs.add("c");
        System.out.println(lhs);

    }
}
//
class TreeSetDemo3{
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add("A");
        ts.add("a");
        ts.add("B");
        ts.add("Z");
        ts.add("L");
        System.out.println(ts);
        System.out.println("Passing null or Some other type will \n" +
                "give Null pointer and class cast exception resp.");
        System.out.println();
//        ts.add(null);
//        ts.add(new Integer(10));
    }
}


class TestInteger{
    public static void main(String[] args) {
        Mycomparator2 mc = new Mycomparator2("Ascending");
        TreeSet t = new TreeSet(mc);
        t.add(5);
        t.add(2);
        t.add(10);
        t.add(6);
        t.add(11);
        t.add(5);
        t.add(4);
        System.out.println(t);
        mc.setVal("Ascending");
//        t.add(1);
//        System.out.println(t);
    }
}

class Mycomparator2 implements Comparator{

    private String val;

    public void setVal(String val) {
        this.val = val;
    }

    Mycomparator2(String val){
        this.val = val;
    }
    Mycomparator2() {
        this("Ascending");
    }
        @Override
    public int compare(Object o1, Object o2) {
        if(val.equalsIgnoreCase("Ascending")){
            return this.AscendingOrder(o1, o2);
        }
        else{
            return this.DescendingOrder(o1, o2);
        }
    }

    private int DescendingOrder(Object o1, Object o2){
        if(o1 instanceof Integer && o2 instanceof Integer) {
            Integer i1 =  (Integer)o1;
            Integer i2 =  (Integer)o2;
            System.out.println("i1: "+ i1);
            System.out.println("i2: "+ i2);
            System.out.println("==============");
            if(i1< i2){
//                When +ve is passed it means that we consider the new element
//                which we want to insert (o1) is bigger than (o2)
//                as per our custom logic and hence want the new element AFTER
//                the element we are comparing (o2) it from
                return +1;
            }
            else if(i1 > i2){
//                When -ve is passed it means that we consider the new element
//                which we want to insert (o1) is smaller than (o2)
//                as per our custom logic and hence want the new element BEFORE
//                the element we are comparing (o2) it from
                return -1;
            }
            else {
                return 0;
            }
        }
        throw new ClassCastException();
    }

    private int AscendingOrder(Object o1, Object o2){
        if(o1 instanceof Integer && o2 instanceof Integer) {
            Integer i1 =  (Integer)o1;
            Integer i2 =  (Integer)o2;
//            return 0; // => [5] only inserts 1st node and considers others as duplicates
//            return +1; // => [5, 2, 10, 6, 11, 5, 4] considers everything bigger hence appends AFTER
//            return -1; // => [4, 5, 11, 6, 10, 2, 5] considers everything smaller hence appends BEFORE
//
            System.out.println("i1: "+ i1);
            System.out.println("i2: "+ i2);
            System.out.println("==============");
            if(i1< i2){
//                When -ve is passed it means that we consider the new element
//                which we want to insert (o1) is smaller than (o2)
//                as per our custom logic and hence want the new element BEFORE
//                the element we are comparing (o2) it from
                return -1;
            }
            else if(i1 > i2){
//                When +ve is passed it means that we consider the new element
//                which we want to insert (o1) is bigger than (o2)
//                as per our custom logic and hence want the new element AFTER
//                the element we are comparing (o2) it from
                return +1;
            }
            else {
                return 0;
            }
        }
        throw new ClassCastException();
    }
}




