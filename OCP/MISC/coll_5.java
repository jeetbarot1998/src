package OCP.MISC;

import java.util.*;

public class coll_5 {
}

class TreeSetTutorial{
    public static void main(String[] args) {
        System.out.println("Objects.hash(null) : "  + Objects.hash(null));
        TreeSet ts =  new TreeSet(); // Using default ordering
        MyCustomEmpClass mcc2 = new MyCustomEmpClass("C");
        MyCustomEmpClass mcc1 = new MyCustomEmpClass("B");
        MyCustomEmpClass mcc = new MyCustomEmpClass("A");
        MyCustomEmpClass mcc3 = new MyCustomEmpClass("A");
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


class MyCustomEmpClass implements Comparable{
    private String name;

    public MyCustomEmpClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        System.out.println("Called compareTo from Comparable");
        MyCustomEmpClass obj = (MyCustomEmpClass) o;
        System.out.println("HERE : " + obj.getName().compareTo(this.getName()));
        return obj.getName().compareTo(this.getName());
    }

    @Override
    public String toString(){
        return this.getName() + " - " + hashCode() + " - " +  Objects.hash(name);
    }
}


class mySB {
    public static void main(String[] args) {
        TreeSet <StringBuffer> hs = new TreeSet<StringBuffer>(new MyComparator50());
        hs.add(new StringBuffer("ABC"));
        hs.add(new StringBuffer("CDE"));
        hs.add(new StringBuffer("CDE"));
        hs.add(new StringBuffer("EFG"));
        System.out.println(hs);
    }
}


class MyComparator50 implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof StringBuffer && o2 instanceof StringBuffer){
            StringBuffer sb1 = (StringBuffer) o1;
            StringBuffer sb2 = (StringBuffer) o2;
            return - sb1.toString().compareTo(sb2.toString());
        }
        throw new ClassCastException();
    }
}


class coll50{
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(new StringBuffer("A"));
        al.add(new StringBuffer("B"));
        al.add(new StringBuffer("C"));
//        al.add("A");
//        al.add("B");
//        al.add("C");

        System.out.println("As we do not have an object ins Array list which \n" +
                "is comparable, hence \n" +
                "cannot be cast to java.lang.Comparable");
        TreeSet ts = new TreeSet<>(al);
        System.out.println(ts);
    }
}

class HashSet50{
    public static void main(String[] args) {

    }
}

