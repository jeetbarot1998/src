package OCA_Dumps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) throws Exception{
        int a = Integer.MIN_VALUE;
        int b = -a;
        System.out.println( a+ "   "+b);
        Boolean b1 = Boolean.FALSE;
        Boolean b2 = Boolean.parseBoolean("false");
        Boolean b3 = Boolean.valueOf(true);
        Q63();
    }


    static void Q63(){
        int i = 1234567890;
        float f = i;
        System.out.println(i - (int)f);
    }
}

class T11{
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("snorkler");
        StringBuilder sb2 = new StringBuilder("yoodler");
        System.out.println(" 1============ ");
        sb1.append(sb2.substring(2,5).toUpperCase());
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(" 2============ ");
        sb1 = new StringBuilder("snorkler");
        sb2 = new StringBuilder("yoodler");
        sb2.insert(3,sb1.append("a"));
        System.out.println(sb1);
        System.out.println(sb2);

        System.out.println(" 3============ ");
        sb1 = new StringBuilder("snorkler");
        sb2 = new StringBuilder("yoodler");
        sb1.replace(3,4,sb2.substring(4)).append(sb2.append(false));
        System.out.println(sb1);
        System.out.println(sb2);
    }
}

class T12{

//    static {
//        throw new NullPointerException();
//    }

    public static void main(String[] args) {
        try{
            String s = null;
            System.out.println(s.length());
        }
        catch (NullPointerException nle){
            System.out.println(nle);
        }

        try {

            int[] ia = new int[]{1, 2, 3};
            System.out.println(ia[3]);
        }
        catch (ArrayIndexOutOfBoundsException nle){
            System.out.println(nle);
        }
//        Unhandled exception: java.lang.ClassNotFoundException
//        Class.forName("java.lang.String");
    }
}

class T13{
    public static void main(String[] args) {
//        Short k = 9;
//        Integer i =9;
//        Boolean b = false;
//        char c = 'a';
//        String str = "123";
//        i = (int) k.shortValue();
//        str += b;
//        c *= i;
//
//        Double d = new Double(10);
//        Double d2 = 10.0;
//        Double d1 = 10D;
//        int s = new Integer(10);
        Integer ii =  10;
        System.out.println(ii);
        m1(ii);
        System.out.println(ii);
    }

    static void m1(Integer i){
        i = 15;
        System.out.println(i);
    }
}


class T14{
    public static void main(String[] args) {
        Integer x = 10;
        Integer y = x;
        x++;
        System.out.println(x);
        System.out.println(y);
        System.out.println(x==y);
    }
}


class T15{
    public static void main(String[] args) {
        Integer x = 10;
        Integer y = 10;
        System.out.println(x==y); // true
    }
}


class T16{
    public static void main(String[] args) {
        Integer x = new Integer(10);
        Integer y = 10;
        System.out.println(x==y); // false
    }
}

class T17{
    public static void main(String[] args) {
        Integer x = new Integer(10);
        Integer y = new Integer(10);
        System.out.println(x==y); // false
    }
}

class T18{
    public static void main(String[] args) {
        System.out.println("For Wrapper objects \n" +
                "java has a constant pool of memory \n" +
                "which has values from \n" +
                "-128 to + 128 for Byte, Short, Integer, Long. \n" +
                "Hence if the value is between the above range \n" +
                "then it will point to the same object\n" +
                "But if you have a value more or less than the range \n" +
                "then it will refer to that.");
        Integer x = 120;
        Integer y = 120;
        System.out.println(x==y); // true
        x = 1000;
        y = 1000;
        System.out.println(x==y); // false

    }
}


class AA11{
    int m1(int a){ return a;}
    int m1(int a, int b){ return a;}
    int m1(float a, int b){ return b;}
}

class InitTest{
    public InitTest(){
        s1 = sM1("1");
    }
    static String s1 = sM1("a");
    String s3 = sM1("2");
    {
        s1 = sM1("3");
    }
    static{
        s1 = sM1("b");
    }
    static String s2 = sM1("c");
    String s4 = sM1("4");
    public static void main(String args[]){
        InitTest it = new InitTest();
    }
    private static String sM1(String s){
        System.out.println(s);  return s;
    }
}
 class ListTest{
    public static void main(String args[]){
        List s1 = new ArrayList( );
        s1.add("a");
        s1.add("b");
        s1.add(1, "c");
        List s2 = new ArrayList(  s1.subList(1, 1) );
        System.out.println(s1.subList(1, 1));
        System.out.println(s2);
        s1.addAll(s2);
        System.out.println(s1);
    }
}

class StringFromChar {
    public static void main(String[] args) {
        String myStr = "good";
        char[] myCharArr = {'g', 'o', 'o', 'd' };
        String newStr = null;
        for(char ch : myCharArr){
            newStr = newStr + ch;
        }
        System.out.println(newStr);
        System.out.println((newStr == myStr)+ " " + (newStr.equals(myStr))+ " " + (newStr.equals(myStr.intern())));
    }
}
class Sample implements IInt{
    public static void main(String[] args){
        Sample s = new Sample();  //1
        int j = s.thevalue;       //2
        int k = IInt.thevalue;    //3
        int l = thevalue;         //4
        }
    }
interface IInt{
    int thevalue = 0;
}


class TestClass21{
    int x = 5;
    int getX(){ return x; }

    public static void main(String args[]) throws Exception{
        TestClass21 tc = new TestClass21();
        tc.looper();
        System.out.println(tc.x);
    }

    public void looper(){
        int x = 0;
        while( (x = getX()) != 0 ){
            for(int m = 10; m>=0; m--){
                x = m;
            }
        }
    }


//    void method1(int i){
//        int j = (i*30 - 2)/100;
//
//        POINT1 : for(;j<10; j++){
//            boolean flag  = false;
//            while(!flag){
//                if(Math.random()>0.5) break POINT1;
//            }
//        }
//        while(j>0){
//            System.out.println(j--);
//            if(j == 4) break POINT1;
//        }
//    }
}

class TestClass22{    public static void main(String args[] ){       int i = 0 ;       int[] iA = {10, 20} ;       iA[i] = i = 30 ;       System.out.println(""+ iA[ 0 ] + " " + iA[ 1 ] + "  "+i) ;     } }


class TestClass23{

    public static void main(String[] args) {
//        int x = 3;
//        for( int i = 0; i< 0; i++) x = 3;
////        while (false) { x=3; }
//        while (true) {
//            x=3;
//            break;}
//        System.out.println("ABC");
        int i = 7;
        int j = (i*30 - 2)/100;
        System.out.println(j);
        float f = 123;
    }
}



class A21{
    public static void main(String[] args) {
        try{
            m1();
        }
        catch (NullPointerException nle){
            System.out.println("NLE");
        }
        catch (RuntimeException rte){
            System.out.println("RTE");
        }
    }

    static void m1() throws RuntimeException{
        throw new NullPointerException();
    }
}






class Holder{
    int value = 1;
    Holder link;
    public Holder(int val){ this.value = val; }
    public static void main(String[] args){
        final Holder a = new Holder(5);
        Holder b = new Holder(10);
        a.link = b;
        b.link = setIt(a, b);
        System.out.println(a.link.value+" "+b.link.value);
    }

    public static Holder setIt(final Holder x, final Holder y){
        x.link = y.link;
        return x;
    }

}






class A111{
    public static void main(String[] args){
        System.out.println(new A111().main);
        System.out.println(5/4);
        {
            System.out.println("hete");
        }

    }
    int main;
}

class ParamTest {
    public static void printSum(int a, int b){
        System.out.println("In int "+(a+b));
    }
    public static void printSum(Integer a, Integer b){
        System.out.println("In Integer "+(a+b));
    }
    public static void printSum(double a, double b){
        System.out.println("In double "+(a+b));
    }
    public static void main(String[] args) {
        printSum(1, 2);
    }
}

