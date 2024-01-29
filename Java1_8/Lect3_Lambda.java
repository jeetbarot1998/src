package Java1_8;
import java.util.*;

public class Lect3_Lambda {
}

class TreeMapDemo{
    public static void main(String[] args) {
//        TreeMap<Integer, String> tm = new TreeMap<>(new MyComparator());
        TreeMap<Integer, String> tm = new TreeMap<>((o1,o2) -> (o1<o2? 1 : o1>o2 ? -1 : 0));
        tm.put(1,"E");
        tm.put(2,"D");
        tm.put(3,"C");
        tm.put(4,"B");
        tm.put(5,"A");
        System.out.println(tm);
    }
}

class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
//        if(o1<o2){
//            return +1;
//        } else if (o1 > o2) {
//            return -1;
//        }
//        else {
//            return 0;
//        }
        return (o1<o2? 1 : o1>o2 ? -1 : 0);
    }
}


class Emp31{
    int eno;
    String name;

    public Emp31(int eno, String name) {
        this.eno = eno;
        this.name = name;
    }

    public String toString(){
        return this.eno + " : " + this.name;
    }
}

class Test31{
    public static void main(String[] args) {
        ArrayList<Emp31> al = new ArrayList<Emp31>();
        al.add(new Emp31(4,"ABC"));
        al.add(new Emp31(3,"DEF"));
        al.add(new Emp31(2,"GHI"));
        al.add(new Emp31(1,"JKL"));
        System.out.println("Before sorting" + al);
        Collections.sort(al,(Emp31 e1,Emp31 e2) -> (e1.eno <e2.eno) ? -1 : (e1.eno > e2.eno) ? 1 : 0);
        System.out.println("After sorting" + al);

    }
}

interface TestI3{
    void m1();
}

class Test32{
    public static void main(String[] args) {
        TestI3 t = new TestI3() {
            @Override
            public void m1() {
                System.out.println("Implemented. ");
            }
        };


        TestI3 t2 = () -> {
            System.out.println("Implemented using lambda. ");
        };
    }
}


interface intrf{
    void m1();
}

class Test33{
    int x = 888;

    void m2(){
        intrf i = new intrf() {
            int x = 999; // Local variable of anonymous Inner class
            @Override
            public void m1() {
                System.out.println("Anonymous Inner Class: " + Test33.this.x);
                System.out.println("Anonymous Inner Class: " + this.x);
            }
        };

        i.m1();
    }


    void m3(){
        intrf i = () -> {
            int x = 999; // Local variable of anonymous Inner class
            System.out.println("From Lambda : " + Test33.this.x);
            System.out.println("As there is no concept of the Object inside Lambda \n" +
                    " 'this' Keyword refers to the instance by default : " + this.x);
        };

        i.m1();
    }

    public static void main(String[] args) {
        Test33 t = new Test33();
        t.m2();
        t.m3();
    }
}









