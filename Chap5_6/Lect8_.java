package Chap5_6;

public class Lect8_ {
    static int []x , y;
    static int [][]u , v[];
//    static int [][]u1 , []v1; //invalid
    float f = 2_5; // valid way to declare a float.
    float f1 = 25; // valid way to declare a float.
    float f2 = 2_5.0f; // valid way to declare a float.
//    float f3 = 25.0; // invalid
    public static void main(String[] args) {
//        float f1 = 25.0;
        float f2 = 025; // this becomes octal.
        System.out.println("======= BOTH x and y are 1 dimensional arrays.===========");
        System.out.println("======= BOTH 'u' is single 2 dimension and 'v' is 3 dimensional array.===========");

//        int arr [][][]= new int [3][][5]; // invalid. CE
        Object [] a = new Object[10];
        a[0] = new Object();
        a[1] = new String("anc");
        a[2] = 10;
        a[3] = new int[5];

        System.out.println(a[3]);
        System.out.println("We can save anything of type object inside an array of Object");
    }

    void m1(){
        String [] a = {"A", "AA", "AAA"};
        System.out.println(a.length);
        a[-4] = "Aa";
//        int x = 2,y;
        int x ,y = 30;
        int []o,b;
    }
}

class StringNStBufferNdStBuilder{
    public static void main(String[] args) {
        String s = "hello";
        s.concat("World");
        System.out.println("Immutability : "+ s);
        String sNew = s.concat("World");
        System.out.println("Making a new object : "+ sNew);
        s = "New String";
        System.out.println("New reference for the String 's' " + s);

        System.out.println("'String s1 = new String(\"Hello\");' \n" +
                "Whenever we use the keyword 'new' it creates an object on the heap. \n" +
                "Another object will be created on the String constant pool. \n" +
                "Makes 2 objects.");
        String s1 = new String("Hello");
        System.out.println("'String s2 = \"Hello\";' \n" +
                "creates the object on string constant pool. \n" +
                "Makes 1 objects.");
        String s2 = "Hello";

        StringBuffer sb = new StringBuffer("ABC");
        StringBuffer sb1 = new StringBuffer("ABC");
//        sb.append("CDE");
//        sb.append(sb1);
        StringBuilder sd = new StringBuilder("AB");
        StringBuilder sd1 = new StringBuilder("AB");

        System.out.println("String Buffer Does not over rides the equals method.");
        System.out.println("String Builder Does not over rides the equals method.");
        System.out.println("String Buffer '==' : " + (sb == sb1));
        System.out.println("String Buffer 'equals' : " + sb.equals(sb1));
        System.out.println("String Builder '==' : " + (sd == sd1));
        System.out.println("String Builder 'equals' : " + sd.equals(sd1));

    }
}


class Str{
    public static void main(String[] args) {
        String s1= new String("ABC");
        String s2= new String("ABC");
        String s3 = "ABC";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1==s3);

        System.out.println("Operator '==' cannot be applied to 'java.lang.Double', 'java.lang.Long'");
        Double d = 10d;
        Long l = 10l;
//        System.out.println(d==l);

        String s = "ABC";
        Integer i = 10;
        Integer j = 10;
        int i1 = 10;
        byte b = 10;
        System.out.println(b ==i1);
        System.out.println(i == j);
        System.out.println(i.equals(j));
//        System.out.println(s == i); //compilation error

        System.out.println("calling m7");
        m7();
    }

    void m1(){
        String s = "ABC";
        Integer i = 10;
//        System.out.println(s == i); //compilation error.
    }

    void m2(){
        Integer i = 10;
        int i1 = 10;
        System.out.println(i == i1); // This will give true.
    }

    void m3(){
        Double d = 10d;
        Long l = 10l;
//        System.out.println(d==l); //cannot compare as different types.
    }

    void m4(){
        int i1 = 10;
        byte b = 10;
        System.out.println(b ==i1); //true
    }

    void m5(){
        Integer i1 = 10;
        Byte b = 10;
//        System.out.println(b ==i1); // compilation error.
        System.out.println(i1.equals(b)); // false
    }

    void m6(){
        float f = 2_5; // valid way to declare a float.
        float f1 = 25; // valid way to declare a float.
        float f2 = 2_5.0f; // valid way to declare a float.
//        float f3 = 25.0; // invalid
    }

    static void m7(){
        Number n = 7;
        Integer i = 7;
        float ii = 7;
        int i1 = 7;
        System.out.println(i == n); //true
        System.out.println(i.equals(n)); //true
        System.out.println(i.equals(n)); //true
        System.out.println(n.equals(i)); //true
        System.out.println(n == i); //true
        System.out.println(i.equals(ii)); //false
        System.out.println(i == ii); //true
        System.out.println(i == i1); //true
        System.out.println(i.equals(i1)); //true
        System.out.println(i1 ==ii); //true
    }
}


class Student5680{
    String name = "ABC";
}

class Test5681{
    public static void main(String[] args) {
        Test5681 t = new Test5681();
        String s = "ABC";
        Student5680 st =  new Student5680();
        System.out.println(s.equals(st)); // goes to String class and false
        System.out.println(st.equals(s)); // goes to Object class and false
//        System.out.println(st == s); // error
        System.out.println(t.compare(st,s));
    }


    boolean compare(Object obj1, Object obj2){
        return (obj1 == obj2);
    }
}

class test5682{
    public static void main(String[] args) {
        String s1 = new String("ABC");
        String s2 = new String("ABC");
        String s3 = "ABC";
        String s4 = "ABC";

        System.out.println(" The Above code makes 3 objects, 1 On SCP and 2 on heap \n" +
                "- s1 creates an object on SCP and Heap.\n" +
                "- As s1 has already created  a string in SCP ‘ABC’, s2 will only create object on Heap.\n" +
                "- s3 refers to the ‘ABC’ on SCP.\n" +
                "- s4 refers to the ‘ABC’ on SCP.");
    }
}

class Test5683{
    public static void main(String[] args) {
        String s1 = new String("ABC");
        s1.concat("CDE");
        String s2 =  s1.concat("DEF");
        s1 = s1.concat("GEF");
        System.out.println(s1);
        System.out.println(s2);
    }
}


class Parent568{
    public static void main(String[] args) {
        if (args == null){
            System.out.println("No arguments");
        }
        else{
            System.out.println("Invisible");
        }
    }
}


class Child568 extends Parent568{}



