package Chap5_6;

import java.util.*;

public class String_Array_SB {
    public static void main(String[] args) {
        String s = new String("abcdef");
        String s3 = "abcdef";
        String s2 = s; // refer s2 to the same String as s
        s = s.concat(" more stuff"); // the concat() method 'appends' a literal to the end
        System.out.println(s);
        String_Array_SB sb = new String_Array_SB();
        sb.CharAt();
        sb.Concat();
        sb.p260();
        sb.p261();
        sb.p262();
        sb.p263();
        sb.p264();
        sb.p267();
        sb.Length();
        sb.Replace();
        sb.substring();
        sb.toLowerCase();
        sb.Trim();
        sb.toUpperCase();
    }

    void p260(){
        String s = "abcdef"; // create a new String object, with value "abcdef", refer s to it
        String s2 = s; // create a 2nd reference variable referring to the same String
        // create a new String object, with value "abcdef more stuff",
        // refer s to it. (Change s's reference from the old String
        // to the new String.) (Remember s2 is still referring to
        // the original "abcdef" String.)
        s = s.concat(" more stuff");
    }

    void p261(){
        String x = "Java";
        x.concat(" Rules!");
        System.out.println("x = " + x); // the output is: x = Java
        x.replace('a', 'X');
        System.out.println("x = " + x);
    }

    void p262(){
        String x = "Java";
        x = x.concat(" Rules!"); // Now we're assigning the
        // new String to x
        System.out.println("x = " + x); // the output will be:
        // x = Java Rules!
    }

    void p263(){
        String x = "Java";
        x = x.concat(" Rules!");
        System.out.println("x = " + x); // the output is:
        // x = Java Rules!
        x.toLowerCase(); // no assignment, create a new, abandoned String
        System.out.println("x = " + x); // no assignment, the output is still: x = Java Rules!
        x = x.toLowerCase(); // create a new String, assigned to x
        System.out.println("x = " + x); // the assignment causes the output: x = java rules!
    }

    void p264(){
        String s1 = "spring ";
        String s2 = s1 + "summer ";
        s1.concat("fall ");
        s2.concat(s1);
        s1 += "winter ";
        System.out.println(s1 + " " + s2);
    }

    void CharAt(){
        String x = "airplane";
        System.out.println( x.charAt(2) ); // output is 'r'
    }

    void Concat(){
        String x = "taxi";
        System.out.println( x.concat(" cab") ); // output is "taxi cab"
        String x1 = "library";
        System.out.println( x1 + " card"); // output is "library card"
        String x2 = "Atlantic";
        x2+= " ocean";
        System.out.println( x2 ); // output is "Atlantic ocean"
    }

    void p267(){
        String x = "Exit";
        System.out.println( x.equalsIgnoreCase("EXIT")); // is "true"
        System.out.println( x.equalsIgnoreCase("tixe")); // is "false"
    }

    void Length(){
        String x = "01234567";
        System.out.println( x.length() ); // returns "8"
    }

    void Replace(){
        String x = "oxoxoxox";
        System.out.println( x.replace('x', 'X') ); // output is "oXoXoXoX"
    }

    void substring(){
        String x = "0123456789"; // as if by magic, the value of each char is the same as its index!
        System.out.println( x.substring(5) ); // output is "56789"
        System.out.println( x.substring(5, 8)); // output is "567"
    }

    void toLowerCase(){
        String x = "A New Moon";
        System.out.println( x.toLowerCase() ); // output is "a new moon"
    }

    void ToString(){
        String x = "big surprise";
        System.out.println( x.toString() ); // output? [reader's exercise :-) ]
    }

    void toUpperCase(){
        String x = "A New Moon";
        System.out.println( x.toUpperCase() ); // output is "A NEW MOON"
    }

    void Trim(){
        String x = " hi ";
        System.out.println( x + "t" ); // output is " hi t"
        System.out.println( x.trim() + "t"); // output is "hit"
    }
}


class StringBuilders{
    public static void main(String[] args) {
        String x = "abc";
        x.concat("def");
        System.out.println("x = " + x); // output is "x = abc"
        StringBuilders sbs = new StringBuilders();
        sbs.Append();
        sbs.delete();
        sbs.insert();
        sbs.p269();
        sbs.p270();
        sbs.ToString();
        sbs.p270p2();
        sbs.reverse();
        sbs.P273();
    }

    void p269(){
        String x = "abc";
        x = x.concat("def");
        System.out.println("x = " + x); // output is "x = abcdef"
    }

    void p270(){
        StringBuilder sb = new StringBuilder("abc");
        sb.append("def");
        System.out.println("sb = " + sb); // output is "sb = abcdef"
    }

    void p270p2(){
        StringBuilder sb = new StringBuilder("abc");
        sb.append("def").reverse().insert(3, "---");
        System.out.println( sb ); // output is "fed---cba"
    }

    void Append(){
        StringBuilder sb = new StringBuilder("set ");
        sb.append("point");
        System.out.println(sb); // output is "set point"
        StringBuilder sb2 = new StringBuilder("pi = ");
        sb2.append(3.14159f);
        System.out.println(sb2); // output is "pi = 3.14159"
    }

    void delete(){
        StringBuilder sb = new StringBuilder("0123456789");
        System.out.println(sb.delete(4,6)); // output is "01236789"
    }

    void insert(){
        StringBuilder sb = new StringBuilder("01234567");
        sb.insert(4, "---");
        System.out.println( sb ); // output is "0123---4567"
    }

    void reverse(){
        StringBuilder sb = new StringBuilder("A man a plan a canal Panama");
        sb.reverse();
        System.out.println(sb); // output: "amanaP lanac a nalp a nam A"
    }

    void ToString(){
        StringBuilder sb = new StringBuilder("test string");
        System.out.println( sb.toString() ); // output is "test string
    }

    void P273(){
        String x = "abc";
        String y = x.concat("def").toUpperCase().replace('C','x'); //chained methods
        System.out.println("y = " + y); // result is "y = ABxDEF"
    }
}

class Array{
    public static void main(String[] args) {
        Thread[] threads = new Thread[5]; // no Thread objects created!
        int[][] myArray = new int[3][];
        Array ar = new Array();
        ar.p278();
        ar.p279();
        ar.p280();
        ar.p281();
        ar.p280p2();
        ar.p281p2();
        ar.p282();
    }

    void p278(){
        int[ ][ ] myArray = new int[3][ ];
        myArray[0] = new int[2];
        myArray[0][0] = 6;
        myArray[0][1] = 7;
        myArray[1] = new int[3];
        myArray[1][0] = 9;
        myArray[1][1] = 8;
        myArray[1][2] = 5;
    }

    void p279(){
        int[][] scores = new int[3][];// Declare and create an array (scores) holding three references to int arrays
        scores[0] = new int[4]; // the first element in the scores array is an int array of four int elements
        scores[1] = new int[6]; // the second element is an int array of six int elements
        scores[2] = new int[1]; // the third element is an int array of one int element
    }

    void p280(){
        Dog[] myDogs = new Dog[6]; // creates an array of 6 Dog references
        for(int x = 0; x < myDogs.length; x++) {
            myDogs[x] = new Dog(); // assign a new Dog to index position x
        }
    }

    void p280p2(){
        int[] dots;
        dots = new int[3];
        int x = 9;
        dots[0] = 6;
        dots[1] = x;
        dots[2] = 8;
    }

    void p281(){
        Dog puppy = new Dog("Frodo");
        Dog[] myDogs = {puppy, new Dog("Clover"), new Dog("Aiko")};
    }

    void p281p2(){
        Dog puppy = new Dog ("Frodo");
        Dog[ ] myDogs = {puppy, new Dog("Clover"), new Dog("Aiko")};
        // Four objects are created:
        // 1 Dog object referenced by puppy and by myDogs[0]
        // 2 Dog[ ] array referenced by myDogs
        // 3 Dog object referenced by myDogs[1]and myDogs[2]
    }

    void p282(){
        int[][] scores = {{5,2,4,7}, {9,2}, {3,4}}; // an array of 4 ints
        System.out.println(scores[0]); // an array of 2 ints
        System.out.println(scores[1]); // an array of 2 ints
        System.out.println(scores[2][0]);
        System.out.println(scores[0][1]); // the int value 2
        System.out.println(scores[2][1]); // the int value 4);
    }
}

class Dog{
    String name;
    Dog(){}
    Dog(String name){
        this.name = name;
    }
}

class AnonymousArray{
    void takesAnArray(int[] someArray) {
// use the array parameter
    }
    public static void main (String [] args) {
        AnonymousArray j = new AnonymousArray();
        j.takesAnArray(new int[] {7,7,8,2,5}); // pass an array
        int[] testScores;
        testScores = new int[] {4,7,2};
    }

    void primitiveArray(){
        int[] weightList = new int[5];
        byte b = 4;
        char c = 'c';
        short s = 7;
        weightList[0] = b; // OK, byte is smaller than int
        weightList[1] = c; // OK, char is smaller than int
        weightList[2] = s; // OK, short is smaller than int
    }

    void Assignment(){
        int[] splats;
        int[] dats = new int[4];
        char[] letters = new char[5];
        splats = dats; // OK, dats refers to an int array
//        splats = letters; // NOT OK, letters refers to a char array
    }

    void MultiDimensional(){
        int[] blots;
        int[][] squeegees = new int[3][];
//        blots = squeegees; // NOT OK, squeegees is a two-d array of int arrays
        int[] blocks = new int[6];
        blots = blocks; // OK, blocks is an int array
    }

    void Multi(){
        int[][] books = new int[3][];
        int[] numbers = new int[6];
        int aNumber = 7;
//        books[0] = aNumber; // NO, expecting an int array not an int
        books[0] = numbers; // OK, numbers is an int array
    }
}


interface Sporty {
    void beSporty();
}

class Car{}
class AthleticShoe{}
class Ferrari extends Car implements Sporty {
    public void beSporty() {
// implement cool sporty method in a Ferrari-specific way
    }
}
class RacingFlats extends AthleticShoe implements Sporty {
    public void beSporty() {
// implement cool sporty method in a RacingFlat-specific way
    }
}
class GolfClub { }
class TestSportyThings {
    public static void main (String [] args) {
        Sporty[] sportyThings = new Sporty [3];
        sportyThings[0] = new Ferrari(); // OK, Ferrari
// implements Sporty
        sportyThings[1] = new RacingFlats(); // OK, RacingFlats
// implements Sporty
//        sportyThings[2] = new GolfClub(); // NOT ok..
// Not OK; GolfClub does not implement Sporty
// I don't care what anyone says
    }
}


class Cities {
    public static void main(String[] args) {
        List<String> c = new ArrayList<String>(); // create an ArrayList, c
        c.add("Oslo"); // add original cities
        c.add("Paris");
        c.add("Rome");
        int index = c.indexOf("Paris"); // find Paris' index
        System.out.println(c + " " + index);
        c.add(index, "London"); // add London before Paris
        System.out.println(c); // show the contents of c
    }
}


class Arraylist{
    public static void main(String[] args) {
        List<String> c = new ArrayList<String>();
        c.add("Rome");
        c.add("Naples");
        c.add("Rome");
        System.out.println(c);
    }
}


class TweakLists {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        myList.add("z");
        myList.add("x");
        myList.add(1, "y"); // zero based
        myList.add(0, "w"); // " "
        System.out.println(myList); // [w, z, y, x]
        myList.clear(); // remove everything
        myList.add("b");
        myList.add("a");
        myList.add("c");
        System.out.println(myList); // [b, a, c]
        System.out.println(myList.contains("a") + " " + myList.contains("x"));
        System.out.println("get 1: " + myList.get(1));
        System.out.println("index of c: " + myList.indexOf("c"));
        myList.remove(1); // remove "a"
        System.out.println("size: " + myList.size() + " contents: " + myList);
    }
}


class Special1 {
    private StringBuilder s = new StringBuilder("bob"); // our special data
    StringBuilder getName() { return s; }
    void printName() { System.out.println(s); } // verify our special data
}

class TestSpecial1 {
    public static void main(String[] args) {
        Special1 sp = new Special1();
        StringBuilder s2 = sp.getName();
        s2.append("fred");
        sp.printName();
    }
}



class Dims {
    public static void main(String[] args) {
        int[][] a = {{1,2}, {3,4}};
        int[] b = (int[]) a[1];
        Object o1 = a;
        int[][] a2 = (int[][]) o1;
        int[] b2 = (int[]) o1;
        System.out.println(b[1]);
    }
}










