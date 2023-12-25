package Chap5_6;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class WrapperClass {
    public static void main(String[] args) {


        Double d = 10.5;
//        float f = 10.5; // required float, Provided: double
        Float f1 = new Float(10.5);

        WrapperBoolean();
        WrapperInteger();
    }

    static void WrapperInteger(){
        Integer i = new Integer(5);
        Integer i1 = new Integer("5");
        System.out.println(i.intValue());
        System.out.println(i.byteValue());
        System.out.println(i.shortValue());
        System.out.println(i.longValue());
        System.out.println(i.floatValue());
        System.out.println(i.doubleValue());
        System.out.println(i.toString());
    }

    void CE(){
//        Integer i = new Integer(5.5);
//        Integer i1 = new Integer(5l);
    }

    static void WrapperShort(){
//        Short s = new Short(1); // CE // provided int
        short s = 10;
        Short s1 = new Short(s);
        Short s2 = new Short("10");

    }

    static void WrapperBoolean(){
        Boolean b0 = new Boolean(false);
        System.out.println(b0); //false
        Boolean b = new Boolean("True");
        System.out.println(b); //true
        Boolean b1 = new Boolean("TrUe");
        System.out.println(b1); //true
        Boolean b2 = new Boolean("Yes");
        System.out.println(b2); //false
        Boolean b3 = new Boolean("Hello");
        System.out.println(b3); //false
        Boolean b4 = new Boolean("Null");
        System.out.println(b4); //false

        Boolean bb0 = new Boolean("yes");
        Boolean bb1 = new Boolean("no");
        System.out.println( bb0 + " " + bb1);
        System.out.println(bb0.equals(bb1));
//        Boolean b5 = new Boolean(ABC); // CE

    }

    static void WrapperFloat(){
        Float f = new Float(5);
        Float f1 = new Float("5");
        Float f2 = new Float(5.5);
        try {
            Float f3 =  new Float("ABC"); //NumberFormatException
        }
        catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
    }

    static void WrapperDouble(){
        Double f = new Double(5);
        Double f1 = new Double("5");
        Double f2 = new Double(5.5);
        Double d = new Double(10.5f);
        Double d1 = new Double("10.5f");
    }
    static void WrapperCharacter(){
        Character c = new Character('a');
//        Character c1 = new Character("a");
    }
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
//
    }
}


class WrapperUtilityMethods{
    public static void main(String[] args) {
        ValueOf();
        Prasexx();
        PrimitiveToString();

        Integer i = new Integer(10);
        System.out.println(i.byteValue());
    }

    static void ValueOf(){
        //        Integer i6 = Integer.valueOf("ABC");  // NumberFormatException
//        System.out.println(i6); // NumberFormatException
        Integer i = Integer.valueOf("1111", 2); //15
        System.out.println(i);
        Integer i1 = Integer.valueOf("11", 36); // 37
        System.out.println(i1);
//        Integer i2 = Integer.valueOf("11", 37); // NumberFormatException
//        System.out.println(i2); //NumberFormatException
        Integer i3 = new Integer(5);
        int i4 = i3;
        System.out.println("At compile time i4 looks like \n" +
                "int i4 = i3.intValue();");
    }

    static void Prasexx(){
        int i = Integer.parseInt("1");
//        int i1 = Integer.parseInt("1.5"); // NumberFormatException
        int i3 = Integer.parseInt("1", 36);
        System.out.println(i3);
    }

    static void PrimitiveToString(){
        String s = Integer.toString(10);
        System.out.println(s); // 10
        String s1 = Boolean.toString(true);
        System.out.println(s1); // true
        String withRadixInt = Integer.toString(10,2);
        String withRadixLong = Long.toString(10,2);
        System.out.println(withRadixInt); // 1010
        System.out.println(withRadixLong); // 1010
        String Binary = Integer.toBinaryString(10);
        System.out.println(Binary); // 1010
        String hex = Integer.toHexString(10);
        System.out.println(hex); //a
        String octal = Integer.toOctalString(10);
        System.out.println(octal); // 12
    }
}
