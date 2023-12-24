package Chap5_6;

public class Lect9_ {
    static int balance = 1000;

    public static void main(String[] args) {
        new Lect9_().m1();
        System.out.println("Here we are making an array which is of type Object and\n" +
                "populating the array with primitive long values and assigning the array to an object type.");
        Object c = new long[4];
        System.out.println("Here we are making an array which is of type Object and" +
                " populating the array with Wrapper long values and assigning the array to an object type.");
        Object c1 = new Long[4];
        System.out.println("'Object c2 [] = new long[4];'\n" +
                "Here we are declaring an an array which will have objects inside, \n" +
                "but while assignment, the values are of type long which is primitive, hence error.");
//        Object c2 [] = new long[4]; // error
        System.out.println("Here we are declaring an an array which will have objects inside, \n" +
                "while assignment, the values are of type Long which is wrapper class \n" +
                "and of type Object.");
        Object c3 [] = new Long[4];
    }


    void modifyBalance(int balance){
        balance = balance - 100;
        System.out.println(balance);
        System.out.println(this.balance);
    }

    void modifyBalance(Lect9_ acc){
        acc.balance = 500;
        System.out.println(balance);
    }

    void m1(){
        modifyBalance(500);
        System.out.println(balance);
        modifyBalance(this);
        System.out.println(balance);
    }
}

class Child890 extends Lect9_{
    public static void main(String[] args) {
        Lect9_ [] l9 = new Lect9_[10];
        Child890 [] c9 = new Child890[20];
        Lect9_ [] cl9 = new Child890[10];
        l9 = c9;
    }
}


class Test090{
        static char c;
    public static void main(String[] args) {
        String s = new String();
//        System.out.println(s.charAt(0));
        System.out.println(s.length());
        System.out.println("s : " + s);
        String s1 = new String(new StringBuffer("ABC"));
        System.out.println(c); // u0000
        char ch [] = {'a','e','i','o','u'};
        String s2= new String(ch);
        System.out.println(s2);
        byte b [] = {100,101,102,103};
        System.out.println("byte type to String constructor");
        String s3 = new String(b);
        System.out.println(s3);
        Byte b1 [] = {100,101,102,103};
        System.out.println("Cannot pass Byte type to String constructor");
//        String s4 = new String(b1);
//        System.out.println(s4);
        System.out.println("Cannot pass int type to String constructor");
//        int i1 [] = {100,101,102,103};
//        String s4 = new String(i1);
        System.out.println("String constructor can only take \n" +
                "either array of char of byte or String.");

        String ss = "abcdef";
//        s.substring(<start>, <end>(optional)) ⇒ start index to end index-1
        System.out.println("ss.substring(2,2) : " + ss.substring(2,2));
        System.out.println("ss.substring(0) : " + ss.substring(0));
        System.out.println("ss.substring(1,4) : " + ss.substring(1,4));
        System.out.println("ss.substring(ss.length()) : " + ss.substring(ss.length()));
        System.out.println("ss.substring(0,ss.length()) : " + ss.substring(0,ss.length()));

        String s0 = ss.replace("a","c");
        System.out.println(ss); // abcdef
        System.out.println(s0); // cbcdef

        String s01 = "java";
//        s01.toUpperCase();
//        System.out.println(s01);
//        s01 = s01.toUpperCase();
        System.out.println(s01.indexOf("a")); // 1
        System.out.println(s01.lastIndexOf("a")); // 3
        System.out.println(s01.lastIndexOf("p")); // -1
    }
}


class Test092{
    public static void main(String[] args) {
        String s1 = new String("java");
        String s2 = s1.toUpperCase();
        String s3 = s1.toLowerCase();
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        String s4 = s2.toLowerCase();
        String s5 = s4.toUpperCase();
    }
}

class Test093{
    public static void main(String[] args) {
        String s1 = new String("java");
        String s2 = s1.toString();
        String s3 = s1.toLowerCase();
        System.out.println(s1 == s2);
        String s4 = s2.toLowerCase();
        String s5 = s4.toUpperCase();
        String s6 = s4.toLowerCase();
        System.out.println(s1 == s6);
        System.out.println(s1.equals(s6));
    }
}

final class ImmutableCustomClass{
    int i = 5;
    public final ImmutableCustomClass modify(int i){
        if(this.i == i){
            return this;
        }
        return new ImmutableCustomClass();
    }
}

class Demo90{
    public static void main(String[] args) {
        ImmutableCustomClass i1 = new ImmutableCustomClass();
        ImmutableCustomClass i2 = i1.modify(5);
        ImmutableCustomClass i3 = i1.modify(100);
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);

    }
}
