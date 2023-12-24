package Chap5_6;

import java.util.*;

public class Lect11_ArrayList{
    public static void main(String[] args) {
        System.out.println("Inheritance of Arrays");
        List al = new ArrayList();
        List ll = new LinkedList();
        polymorphismInAction(al);
        polymorphismInAction(ll);
        System.out.println(".add()");
        System.out.println("al.add(\"ABC\") response : " + (al.add("ABC")));
        System.out.println(al);
        System.out.println(".remove() removes the first occurance of the object");
        System.out.println("al.remove(\"ABC\") response : " + (al.remove("ABC")));
        System.out.println(al);
        try{
            al.add(2, "ABC");
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("IndexOutOfBoundsException");
        }

        al.add(null);
        System.out.println(al);

        al.add('d');
        System.out.println(al);
        System.out.println(al.get(1));
        al.remove((Object) 'd');
        System.out.println(al);

        List<String> al2 = new ArrayList<String>();
        al2.add("String");
        al2.add("New");
        String s1 = al2.get(0);
        String s2 = al2.get(1);
        s1.intern();

        List<Integer> al3 = new ArrayList<Integer>();
        al3.add(1);
        al3.add(2);
        al3.add(new Integer(3));
        System.out.println(al3); //[1, 2, 3]
        al3.remove(2); // remove by index [1, 2]

        System.out.println(al3);
        al3.remove((Object) 2); // remove by element [1]
        System.out.println(al3);
    }

    static void polymorphismInAction(List  l){
        if(l instanceof  ArrayList){
            System.out.println("Array List");
        } else if (l instanceof LinkedList) {
            System.out.println("Linked List");
        }
    }
}

class Test5611{
    public static void main(String[] args) {
        List<Student5611> sal = new ArrayList<Student5611>();
//        List<int> sal2 = new ArrayList<>(); // not allowed
        sal.add(new Student5611("ABC"));
        sal.add(new Student5611("DEF"));
        sal.add(new Student5611("GHI"));
        sal.add(new Student5611("ABC"));
        System.out.println(sal.size());
        System.out.println(sal);
        System.out.println(sal.remove(new Student5611("ABC")));
        System.out.println(sal.size());
        System.out.println(sal);
        System.out.println(sal.remove(new Student5611("ABC")));
        System.out.println(sal);
        System.out.println(sal.contains(new Student5611("ABC")));
    }
}

class Student5611{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Student5611(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.getName();
    }
}


class Test56112{
    public static void main(String[] args) {
        List<Student56112> sal = new ArrayList<Student56112>();
        sal.add(new Student56112("Dummy Name"));
        sal.add(new Student56112("DEF"));
        sal.add(new Student56112("GHI"));
        sal.add(new Student56112("ABC"));
        System.out.println("Student56112 class has over ridden the equals method and hence all the elements match \n" +
                "with any other object \n" +
                "Hence all the objects are removed no matter the name.");
        System.out.println(sal.size());
        System.out.println(sal);
        System.out.println(sal.remove(new Student56112("ABC")));
        System.out.println(sal.size());
        System.out.println(sal);
        System.out.println(sal.remove(new Student56112("ABC")));
        System.out.println(sal);
        System.out.println(sal.contains(new Student56112("ABC")));
    }
}

class Student56112{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Student56112(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    @Override
    public boolean equals(Object o){
        System.out.println("remove method called equals method internally, returning true");
        return true;
    }
}


class Special {
    private StringBuilder s = new StringBuilder("bob");
    StringBuilder getName() { return s; }
    void printName() {
//        this = new Special();
        System.out.println(s); }
}
class TestSpecial {
    public static void main(String[] args) {
        Special sp = new Special();
        StringBuilder s2 = sp.getName();
        s2.append("fred");
        sp.printName();
        StringBuilder t = new StringBuilder("ABC");
        StringBuilder t1 = new StringBuilder(t);
        System.out.println(t == t1); //false
    }
}

class Test11{
    String name;
    Test11(String n){
        this.name = n;
    }

    public static void main(String[] args) {
        List<Test11> t = new ArrayList<>();
        t.add(new Test11("ABC"));
        t.add(new Test11("CDE"));
        if(t.contains("ABC")){
            t.add(new Test11("GEF"));
        }
        System.out.println(t);
    }
}



class WrapperClasses{
    static void m1(Object o){
        System.out.println("Autoboxing first then widening.");
    }
    public static void main(String[] args) {
        int x = 5;
        System.out.println("Here int is autoboxed into Integer \n" +
                "Then widened to Object as it is parent of all the class");
        System.out.println("'Object o = 5' => int 5 is autoboxed \n" +
                "to Integer and widening to Object");
        Object o = 5;
        System.out.println("'Number n = 11' => int 11 is autoboxed \n" +
                "to Integer and widening to Number");
        Number n = 11;
        System.out.println("'Long l = 12; ' => int 12 is Autoboxed into Integer \n" +
                "But Integer and Long are siblings hence not possible");
//        Long l = 12;
        System.out.println("'Long l1 = 12L;' => Hence long 12L is used and Autoboxed \n" +
                "into Long and can be saved into Number or Object");
        Object o1 = 12L;
        Long l1 = 12L;
        Number n1 = 12L;

        double d = 10;
        Double d1 = 10D;
    }
}










