package OCA_Dumps;

import java.util.Arrays;

public class Q21 {
    Q21(){
        System.out.println("Q21 Constructor");
    }
    static String s = "Hello";
    {
        System.out.println("Instance block1 "+ s);
    }

    static {
        System.out.println("static block1 "+ s);
    }

    public static void main(String[] args) {
        System.out.println(s);
        new Q21();
    }

    {
        System.out.println("Instance block2 "+ s);
    }

    static {
        System.out.println("static block2 "+ s);
    }
}

class T extends Q21{
    T(){
        System.out.println("T Constructor");
    }
    public static void main(String[] args) {
        T q =  new T();
    }
}

class T21{
    static String s = "-";
    public static void main(String[] args) {
        go();
        System.out.println(s);
    }
//    void go(){}
    static{go();}
    static void go(){
        s+="s";
    }
}

class Punt1{
    public static void main(String[] args) {
        Punt1 p = new Punt1();
        Object o = p.go(new Punt1());
//        Object o = p.go(p);
        Punt1[] p2 =((Punt1[])o);
        System.out.println(Arrays.toString(p2));
        System.out.println(p.equals(p2[0]) + " " + (p == p2[0]));
    }

    Punt1[] go(Punt1 p){
        Punt1[] p1 = {p};
//        Punt1[] p1 = null;

        return p1;
    }
}


