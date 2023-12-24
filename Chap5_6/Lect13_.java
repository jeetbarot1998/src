package Chap5_6;

public class Lect13_ {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = "HelloWorld";
        System.out.println("s1 + s2 is a runtime execution and hence \n" +
                "It will make at the s1+s2 on the heap.");
        System.out.println(s1+s2 == "HelloWorld"); // false
        System.out.println(s1+s2 == s1+s2); // false
        System.out.println(s1+s2 == s3); // false

        final String s4 = "Hello";
        final String s5 = "World";
        System.out.println("s4 + s5 is a compile time execution as they \n" +
                "are final in nature and hence constants. \n" +
                "It will make at the s4+s5 on the String constant pool as a \n" +
                "new constant on the SCP 'HelloWorld'.");
        System.out.println(s4+s5 == "HelloWorld"); // true
    }
}

class Test13{
    public static void main(String[] args) {
        System.out.println("Creates 2 objects on the SCP.");
        String hello = "Hello", lo = "lo";
        System.out.println(OtherTest.hello == "Hello");

        System.out.println(Chap5_6.OtherTest.hello == "Hello");
        System.out.println(hello == "Hello");
        System.out.println(hello == ("Hel" + "lo"));
        System.out.println(hello == ("Hel" + lo));
        System.out.println(hello == ("Hel" + lo).intern());
    }
}

class OtherTest{
    static String hello = "Hello";
}


class TestStringHell{
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + s2;
        String s_ = "HelloWorld";
        System.out.println("Comparing s3(heap) and s_(SCP)");
        System.out.println((s3 == s_)); // false
        final String s4 = "Hello";
        final String s5 = "World";
        String s6 = "HelloWorld";
        String s7 = s4+s5;
        System.out.println("Comparing s6(SCP) and s7(SCP)");
        System.out.println(s6 == s7); // true
        System.out.println("Comparing s3(heap) and s7(SCP)");
        System.out.println(s3 == s7); // false


        String s8 = "HELLO";
        String s9 = s8.toUpperCase();
        System.out.println("Comparing s8(SCP) with s9(SCP) as there is no change in the object");
        System.out.println(s9 == s8); // true
        String s91 = s8.toLowerCase();
        System.out.println("Comparing s8(SCP) with s91(heap)");
        System.out.println(s91 == s8); // false
        String s10 =  new String("Winter");
        String s11 = "Winter";
        System.out.println("Comparing s10(heap) with s11(SCP)");
        System.out.println(s10 == s11); // false
        System.out.println("Comparing s10(heap).intern() ie. the SCP instance\n" +
                " with s11(SCP)");
        System.out.println(s10.intern() == s11); // true
        String s12 = "hello   ";
        String s13 = "hello";
        String s14 = s12.trim();
        System.out.println("Comparing s14(heap) with s13(SCP)");
        System.out.println(s14 == s13); // false
        String s15 = "hello   ".trim();
        System.out.println("Comparing s15(heap) as it is a runtime operation \n" +
                " with s13(SCP)");
        System.out.println(s15 == s13); // false
        String s16 = "Hello".concat("World");
        System.out.println("Comparing s16(heap) with s6(SCP)");
        System.out.println(s6 == s16); // false
    }
}
