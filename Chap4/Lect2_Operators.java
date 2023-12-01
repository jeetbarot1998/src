package Chap4;

public class Lect2_Operators {
}

class IncrementAndDecrementOperator{
    public static void main(String[] args) {
        int a = 5;
        System.out.println(a++);
        System.out.println(a);
        System.out.println(++a);
        System.out.println(a);

//      Whenever you add any 2 numbers resultant will be
//      Max of (int, type of 1st, type of 2nd)
        char c = 'a';
        float b = 10.5f;
        float p = c + b;
//      Max of (int, type of 1st [char], type of 2nd[float]) =  float


        System.out.println("a" + "b");
        System.out.println('a' + 'b');
    }
}

class Dummy{}

class RelationalOperators{
    public static void main(String[] args) {
        Dummy d1 = new Dummy();
        Dummy d2 = new Dummy();

//      Relational operators do not apply on objects
//        System.out.println(d1 == d2);

        int x = 10;
        int y = x++;
        System.out.println(x + ", " + y);
        x = 10;
        y = ++x;
        System.out.println(x + ", " + y);
        x = 10;
        y = --x;
        System.out.println(x + ", " + y);
        x = 10;
        y = x--;
        System.out.println(x + ", " + y);

//      invalid
//        y = ++10;
//        y = ++(++x);
        char c = 'a';
        System.out.println(++c);

        double d = 10.5;
        System.out.println(++d);

    }
}

class DivideByZero{
    public static void main(String[] args) {

//        System.out.println(10/0); => Integer output. As no infinite .arithmetic exception
        System.out.println(10/0.0); // +Infinity. As the result is of type Double thus infinity
        System.out.println(10/-0.0); // -Infinity. As the result is of type Double thus infinity
//        System.out.println(0/0); => arithmetic exception
        System.out.println(0/0.0); // Not defined. As the result is Double thus NAN
        System.out.println(-0/0.0); // Not defined. As the result is Double thus NAN

//        System.out.println(10/0); => Integer output. As no infinite .arithmetic exception
        System.out.println(10/0.0F); // +Infinity. As the result is of type Float thus infinity
        System.out.println(10/-0.0F); // -Infinity. As the result is of type Float thus infinity
//        System.out.println(0/0); => arithmetic exception
        System.out.println(0/0.0F); // Not defined. As the result is Float thus NAN
        System.out.println(-0/0.0F); // Not defined. As the result is Float thus NAN
    }
}

class Compare{
    public static void main(String[] args) {
        System.out.println(10>Float.NaN);
        System.out.println(10<Float.NaN);
        System.out.println(10==Float.NaN);
        System.out.println(Float.NaN==Float.NaN);
        System.out.println(Float.NaN!=Float.NaN);
        System.out.println(Float.NaN/Float.NaN);
        System.out.println(Float.NaN+Float.NaN);
        System.out.println(Float.NaN/0);
        System.out.println(Float.POSITIVE_INFINITY/Float.POSITIVE_INFINITY);
        System.out.println(Float.POSITIVE_INFINITY/Float.NEGATIVE_INFINITY);
        System.out.println(Float.POSITIVE_INFINITY/0);

    }
}

class StringConcatenation {
    public static void main(String[] args) {
        String a = "ABC";
        int b= 1;
        int c= 2;
        int d= 3;

        System.out.println(a+b+c+d);
        System.out.println(b+c+d+a);
        System.out.println(b+a+c+d);
        System.out.println(b+c+a+d);

        a = b + c + a; // valid as due to "a" the result has changed
        // into String type
//        a = b + c + d; => error as we are trying to save int in String
    }
}

class Comparing{
    public static void main(String[] args) {
//        System.out.println(5<10<20); First the first 2 are evaluated
//        , then it looks like (true,20) which is invalid.
        System.out.println('a'<10);
        System.out.println('a'<97.6);
        System.out.println('a'<'A');
//        System.out.println(true<false); cannot compare 2 booleans
//        System.out.println("ABC" < "BCD");

//      Comparing of Objects is not possible.
    }
}


class EqualityOperator{
    public static void main(String[] args) {
        System.out.println('a'=='b');
        System.out.println('a'==97);
        System.out.println(false == false);

//      Comparing Objects
        Dummy d1 = new Dummy();
        Dummy d2 = new Dummy();

//      Relational operators do not apply on objects
        System.out.println(d1 == d2);

        d1 = d2;
        System.out.println(d1 == d2);

        String a = "ABC"; // gets created on string constant pool
        String a1 = new String("ABC"); // gets created on Heap

        System.out.println("a == a1" + a == a1);

        Thread t = new Thread();
        System.out.println("t == s" + t == a);

        String s = "ABC"; // gets created on string constant pool
        String s1 = new String("ABC"); // gets created on Heap
        String s2 = new String("ABC"); // gets created on Heap

        System.out.println(s == s1);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2)); // reference/value comparison
        System.out.println(s.equals(s2)); // reference/value comparison

        Integer i = new Integer("10");
        Integer i1 = new Integer("10");

        System.out.println(i == i1);
        System.out.println(i.equals(i1)); // reference/value comparison

        System.out.println(s == null);
    }
}



