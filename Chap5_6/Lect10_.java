package Chap5_6;

import java.util.ArrayList;

public class Lect10_ {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(); // default capacity is 16
        System.out.println("default capacity ==== capacity()[16] : "  + sb.capacity());
        sb.ensureCapacity(100);
        StringBuffer sb1 = new StringBuffer((short) 1000); // setting capacity is 1000
//        StringBuffer sb2 = new StringBuffer((long) 1000); // error because 'int' is req
        StringBuffer sb2 = new StringBuffer(new StringBuffer("ABC"));
        StringBuffer sb3 = new StringBuffer("ABC");


        System.out.println("===================== SB.CAPACITY EXPLAINED WITH EXAMPLE =====================");
        StringBuffer sb4 = new StringBuffer("java");
        System.out.println(sb4.length());
        System.out.println("default capacity ==== capacity()[16] : "  + sb4.capacity());
        System.out.println("==== capacity()[16] = capacity()[16] + length()[4] ==== : " + sb4.capacity());

        try {
            System.out.println(sb3.charAt(sb3.length()));
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println(e);
        }
        System.out.println(sb3.charAt(sb3.length()-1));
        sb3.setCharAt(1,'O');

    }

    void infiniteLoop(){
        ArrayList al = new ArrayList();
        boolean b = true;
        while (b){
            al.add("hi");
        }
        System.out.println(al.size());
    }

    void unreachableCode0(){
//        ArrayList al = new ArrayList();
//        boolean b = true;
//        while (true){
//            al.add("hi");
//        }
//        System.out.println(al.size());
    }


    void unreachableCode(){
//        ArrayList al = new ArrayList();
//        final boolean b = true;
//        while (b){
//            al.add("hi");
//        }
//        System.out.println(al.size());
    }
}

class Test010{
    public static void main(String[] args) {
//        System.out.println(m11());
        System.out.println("println Can take null but in a certain way");
        String s = null;
        System.out.println(s);

        System.out.println("String buffer .appneds() method \n" +
                "is over loaded and takes multiple types of inputs");
        StringBuffer sb = new StringBuffer();
        sb.append("Area of circle is ");
        sb.append(3.14);
        sb.append(true);
        sb.append('a');
        sb.append(new Object());
        sb.append(new Test010());
        System.out.println(sb);


        System.out.println("SB.INSERT()");
        StringBuffer sb1 = new StringBuffer("My sb");
        sb1.insert(2," dummy string");
        System.out.println(sb1);
        sb1.append(" 2 ").append("3 ").append("4 ");
        System.out.println("SB.DELETE()");
        StringBuffer sb2 = new StringBuffer("My sb ");
        sb2.append("ABC").append(" CDE");
        System.out.println(sb2);
        sb2 = sb2.delete(3,5);
        System.out.println(sb2);
        sb2  = sb2.deleteCharAt(6);
        System.out.println(sb2);
        System.out.println("SB.REVERSE()");
        StringBuffer sb3 = new StringBuffer("ABC");
        System.out.println(sb3.reverse());
        System.out.println("SB.SETLENGTH()");
        sb3.setLength(20);
        System.out.println(sb3);
        System.out.println(sb3.capacity());

    }

    static void m11(){}
}


class Test101{
    public static void main(String[] args) {
        String s1 = new String("ABC");
        System.out.println("create a new object on heap and SCP as it does not already exists");
        String s2 = new String("ABC");
        System.out.println("create a new object on heap not on SCP bcz it already exists");
        System.out.println(s1 == s2); // false
        System.out.println("different locations");
        String s3 = "ABC";
        System.out.println("Points to the SCP object");
        System.out.println(s1 == s3); // false
        String s4 = "ABC";
        System.out.println("Points to the heap object");
        System.out.println(s1 == s4); // false
        String s5 = "AB" + "C";
        System.out.println("Makes 2 new object in SCP 'AB' and 'C' \n" +
                "There are 2 constants and hence makes an object on SCP \n" +
                "Then at runtime it compares and then as the resultant already exists \n" +
                "hence points to the 'ABC' on the SCP ");
        System.out.println(s4 == s5); // true

        String s6 = "AB";
        System.out.println("here s6 is a constant and hence not a runtime operation \n" +
                "hence it makes an object on SCP");
        String s7 = s6 + "C";
        System.out.println("Here s7 is made on runtime unlike 's5' as we are \n" +
                "having 1 variable and one constant hence the object is made \n" +
                "on the SCP.");
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s7); // false
        String s8 = "AB".concat("C");
        System.out.println("this is a runtime operation hence s8 created on heap");
        System.out.println(s8 == s7);// false

    }
}


