package Chap5_6;

import com.sun.corba.se.impl.legacy.connection.USLPort;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class Lect7_ {
}

class This{
    int i = 5;
    void m1(){
        This ref  = this;
        System.out.println("ref : " + ref);
        System.out.println("i : " + i );
        This ref2 = m2(this);
        System.out.println("ref2 :" + ref2);
        System.out.println("'this' keyword gives the fully qualified name \n" +
                "ie. Which object has been used to call current method.");
        System.out.println(this);
        System.out.println("i : " + i );
    }
    private This m2(This o) {
        System.out.println("o :" + o);
        System.out.println("If you pass a reference var as an argument to a \n" +
                "method, any modifications made using that ref variable \n" +
                "will be visible everywhere.");
        o.i = 7;
        return this;
    }
}

class ThisDemo extends This{

    public static void main(String[] args) {
        new This().m1();
        System.out.println("You can access static members from anywhere within the class \n" +
                "You need Instance to access the instance member");
    }

    void m2(){
//        super(); // => You cannot do this.
        super.m1();
    }
}


class Arrays{
    public static void main(String[] args) {
//        int [] a = new int[]; // invalid
        int [] a1 = new int[4]; // valid
        int [] a2 = new int[0]; // valid
        int [] a4 = new int['a']; // valid as we can store char inside int. It will pass ascii value of 'a' ie 97.
//        int [] a5 = new int[777777777777777777]; // invalid, as n Java, the array size
//        must be a non-negative integer, and it cannot exceed the maximum positive integer
//        value that can be represented in the int data type. The maximum positive value that
//        can be stored in an int in Java is 2,147,483,647. Any array size larger than this
//        value will result in a compilation error
//        int [] a6 = new int[50L]; // invalid as we are trying to save long type into int.
//        int [] a7 = new int[40f]; // invalid as we are trying to save float type into int
        int x[] = new int[5];
        System.out.println(x[0]);
        System.out.println(x[1]);
        System.out.println("You can only have integer in the length parameter of homogenous array.");
//        float p [] = new float[10f];
        float p [] = new float[10];
        System.out.println(p[0]);
        try{
            int [] a3 = new int[-10]; // valid
            System.out.println(a3[0]);
        }
        catch (NegativeArraySizeException NASE){
            System.out.println("NegativeArraySizeException as we tried to access an element of \n" +
                    "negative sized array.");
        System.out.println("when you declare an array with negative size and try to access it \n" +
                "it gives a run time exception as Negative Array Exception");
        }

        try{
            int [] a3 = new int[10]; // valid
            System.out.println(a3[-1]);
        }
        catch (ArrayIndexOutOfBoundsException AIOB){
            System.out.println("Array out of index exception");
        }

        System.out.println("Even if we have an array of primitive type, \n" +
                "the resultant is an array and hence it will be passed \n" +
                "by reference as an argument");
        System.out.println("x :" + java.util.Arrays.toString(x));
        m1(x);
        System.out.println("x :" + java.util.Arrays.toString(x));

        System.out.println("=========== Here 'x' is an anonymous array as int is not a class.");
        System.out.println("Invoking the toString() method of the anonymous class : \n" +
                "The '[' is for array and 'I' is for indicating it is an int array. " + x);

        System.out.println("=========== Here 'p' is an anonymous array as float is not a class.");
        System.out.println("Invoking the toString() method of the anonymous class : \n" +
                "The '[' is for array and 'F' is for indicating it is an float array. " + p);
    }

    static void m1(int [] x){
        x[2] = 5;
    }
}


class Test07{
    public static void main(String[] args) {
        int i = 0;
        int[] iA = {10,20};
        iA[i] = i = 30;
//        iA[i] = (i+=30);
        System.out.println(" " + iA[0] + " " + iA[1] + " " + i);
        System.out.println("Operand is always executed before operator");
        System.out.println("Here '[]' is an operand and hence we first get \n" +
                "Hence the left side of the operand is calculated first" +
                "iA[0] = i = 30; then \n" +
                "right side is calculated then \n" +
                "iA[0] = i; wherein 'i' is 30");
        System.out.println("If you have multiple operands then it gets executed from left to right");

        int [] a = new int ['a'];
        long [] a1 = new long [(byte) 24];
        float [] a2 = new float [(short) 22];
//        double [] a3 = new double [23f]; // invalid

        int x [][] = new int[2][];
        System.out.println("default value of an array is : " + x[0]);
        System.out.println(x.length);
//        System.out.println(x[0].length);
//        System.out.println(x[0][1]);
        System.out.println("the 1st index is referring to an array of len 2 and");
        System.out.println("the 2nd index is referring to an array of len 3");
        x[0] = new int[2];
        x[1] = new int[3];
        System.out.println(java.util.Arrays.toString(x[0]));
        System.out.println(x.length);
        System.out.println(x[0].length);
        System.out.println(x[0][1]);
        Integer  ii = 5;
        System.out.println(ii);

        String q = "a";
        String qq = "a";

        System.out.println(q == qq);
        System.out.println(q.equalsIgnoreCase(qq));
        System.out.println(q.equals("a"));
        System.out.println(q.equals('a'));

        Test07 t = new Test07();
        Test07 t2 = new Test07();
        System.out.println(t.equals(t2));
    }
}








