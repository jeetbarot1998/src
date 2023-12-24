package Chap5_6;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class WrapperClass {
}


class OuterClass {
    private int outerVar = 10;

    class InnerClass {
        void display() {
            System.out.println("Value of outerVar: " + outerVar);
        }
    }
}

class ForLooop{
    public static void main(String[] args) {
        for(int i = 0; i<3; i++,System.out.println("Java")){
            System.out.println("Inside");
        }

        int i = 10;
        for (System.out.println("Hello"),System.out.println("Hi"); i<10; System.out.println("Here")){

        }

    }

    void m1(){
        int j,k;
        for(;;j=4,k=4){

        }
    }
}


class TestW{
    private final int sal;
    {
        sal = 10;
    }

    static int Method(){
        System.out.println("Here");
        return 1;
    }

    TestW(){
        this(Method());
        System.out.println("Line 56");
    }

    TestW(int a){
        System.out.println("Line 59");
    }

    public static void main(String[] args) {
        final int a;
        a = 10;

        TestW t = new TestW();

        Boolean b = new Boolean("True");
        System.out.println(b);
        Boolean b1 = new Boolean("TrUe");
        System.out.println(b1);
        Boolean b2 = new Boolean("Yes");
        System.out.println(b2);
        Boolean b3 = new Boolean("Hello");
        System.out.println(b3);
        Boolean b4 = new Boolean("Null");
        System.out.println(b4);

        
    }
}

