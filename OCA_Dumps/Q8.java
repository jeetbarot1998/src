package OCA_Dumps;

import OCA_Dumps.Q6.foo.A;

public class Q8 {
    public static void main(String[] args) {
        if(args[0].equals("open"))
            if(args[1].equals("Someone"))
                System.out.println("Hello");
        else System.out.println("Go Away " + args[1]);
    }
}

class B extends A {
    B(){}
    public void print(){
        System.out.println(this.x);
        System.out.println("B");
    }

    public static void main(String[] args) {
        B b = new B();
        b.print();
    }
}

class JustLooping{
    private int j;
    void showJ(){
        while (j<=5){
            for (int j = 1; j<=5;){
                System.out.println(j+" ");
                j++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        new JustLooping().showJ();

        boolean b1 = false;
        boolean b2 = false;
        System.out.println("Assignment operator has the least\n" +
                "priority. ");
//        if(b2 != b1 = !b2){
//            System.out.println("True");
//        }
//        else {
//            System.out.println("False");
//        }

        if(b2 = b1 = !b2){
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}


class T81{
    static int i;

    public static void main(String[] args) {
        try{
            getArray()[i=2] = 3;
        }
        catch (NullPointerException nle){
            System.out.println(i);
        }
    }

    static int[] getArray(){
        throw new NullPointerException();
    }
}


class T82{
    int x = 5;

    public int getX() {
        return x;
    }

    public static void main(String[] args) throws Exception {
        T82 t = new T82();
        t.looper();
    }

    void looper(){
        System.out.println("ASSIGNMENT GETS THE LAST PREFERENCE");
        int x = 0;
    // Required type: int
    // Provided: boolean
//        while (x = getX() !=0){
//            for (int m = 10; m >= 0; m--){
//                x=m;
//            }
//        }


//        Infinite Loop
//        while ( (x = getX() !=0){
//            for (int m = 10; m >= 0; m--){
//                x=m;
//            }
//        }
    }
}

class T83{
    private int id;
    T83(int id){
        this.id = id;
    }

    public boolean equals(Object o){
        T83 t  = (T83) o;
        return t.id == id;
    }

    public static void main(String[] args) {
        T83 a = new T83(1);
        T83 b = new T83(1);
        T83 c = b;
        String res = "-";
        if(a==b) res +="1";
        if(a==c) res +="2";
        b=c;
        if(a.equals(b)) res +="3";
        if(b.equals(c)) res +="4";
        System.out.println(res);

        int i = 1;
        Integer i1 = 1;
        System.out.println(i==i1); // true
        Double d1 = 1D;
        System.out.println(d1 == i); // true
//        System.out.println(d1 == i1); // CE
    }
}


class T84{
    public static void main(String[] args) {
        try{
            hello();
        }
        catch (MyException8 m){
            System.out.println(m);
        }
    }

    static void hello() throws MyException8{
        int [] dear = new int[7];
        dear[0] = 747;
        foo();
    }

    static void foo() throws MyException8{
        throw new MyException8("Exception from foo");
    }
}

class MyException8 extends Exception{
    public MyException8(String msg){
        super(msg);
    }
}

class T85{
    static char ch;
    static float f;
    static boolean bool;

    public static void main(String[] args) {
        System.out.println(f);
        System.out.println(ch);
        System.out.println((int)ch);
        System.out.println(bool);
//        System.out.println(m1()); // CE.
    }
    static void m1(){}
}

class T86{
    static void m1(Integer obj, int var){
        obj = var++;
        obj++;
    }

    public static void main(String[] args) {
        Integer val1 = new Integer(5);
        int val = 9;
        m1(val1,val);
        System.out.println(val1 + " " + val);
    }
}




