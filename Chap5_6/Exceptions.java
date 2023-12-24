package Chap5_6;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Exceptions {

    public static void main(String[] args) {

    }
    static void IfStatement(){
        int x = 1;
        if ( x == 3 ) { }
        else if (x < 4) {System.out.println("<4"); }
        else if (x < 2) {System.out.println("<2"); }
        else { System.out.println("else"); }
    }

    static void IfStatement1(){
        int y = 5;
        int x = 2;
        if (((x > 3) && (y < 2)) | doStuff()) {
            System.out.println("true");
        }
    }

    static void IfStatement2() {
        int y = 5;
        int x = 2;
        if ((x > 3) && (y < 2) | doStuff()) {
            System.out.println("true");
        }
    }

    static void p312(){
        int trueInt = 1;
        int falseInt = 0;
//        if (trueInt) // illegal
//        if (trueInt == true) // illegal
//        if (1) // illegal
//        if (falseInt == false) // illegal
//        if (trueInt == 1) // legal
//        if (falseInt == 0) // legal
    }

    static void Switch(){
        int x = 3;
        if(x == 1) {
            System.out.println("x equals 1");
        }
        else if(x == 2) {
            System.out.println("x equals 2");
        }
        else {
            System.out.println("No idea what x is");
        }
    }

    static void Switch1(){
        int x = 3;
        switch (x) {
            case 1:
                System.out.println("x equals 1");
                break;
            case 2:
                System.out.println("x equals 2");
                break;
            default:
                System.out.println("No idea what x is");
        }
    }

    static void Switch2() {
        final int a = 1;
        final int b;
        b = 2;
        int x = 0;
        switch (x) {
            case a: // ok
//            case b: // compiler error
        }
    }

    static void Switch3(){
        String s = "xyz";
        switch (s.length()) {
            case 1:
                System.out.println("length is one");
                break;
            case 2:
                System.out.println("length is two");
                break;
            case 3:
                System.out.println("length is three");
                break;
            default:
                System.out.println("no match");
        }
    }

    static void Switch4(){
        System.out.println("Test.java:6: possible loss of precision");
        byte g = 2;
        switch(g) {
            case 23:
//            case 128:
        }
    }

    static void Switch5(){
        System.out.println("Duplicate label '80'");
        int temp = 90;
        switch(temp) {
            case 80 : System.out.println("80");
//            case 80 : System.out.println("80"); // won't compile!
            case 90 : System.out.println("90");
            default : System.out.println("default");
        }
    }

    static void Switch6(){
        int x = 1;
        switch(x) {
            case 1: {
                System.out.println("x is one"); break;
            }
            case 2: {
                System.out.println("x is two"); break;
            }
            case 3: {
                System.out.println("x is two"); break;
            }
        }
        System.out.println("out of the switch");
    }

    static void Switch7(){
        int x = 7;
        switch (x) {
            case 2:
            case 4:
            case 6:
            case 8:
            case 10: {
                System.out.println("x is an even number");
                break;
            }
            default: System.out.println("x is an odd number");
        }
    }

    static void Switch8(){
        int x = 2;
        switch (x) {
            case 2: System.out.println("2");
            default: System.out.println("default");
            case 3: System.out.println("3");
            case 4: System.out.println("4");
        }
    }

    static void Switch9(){
        int x = 7;
        switch (x) {
            case 2: System.out.println("2");
            default: System.out.println("default");
            case 3: System.out.println("3");
            case 4: System.out.println("4");
        }
    }

    static void InvalidSwitch6(){
        int x = 10;
        int y;
//        switch(x) {
//            case 0 {
//                y = 7;
//            }
//        }
//        switch(x) {
//            0: { }
//            1: { }
//        }
    }


    static boolean doStuff(){
        return true;
    }
}


class SwitchString {
    public static void main(String [] args) {
        String s = "green";
        switch(s) {
            case "red": System.out.print("red ");
            case "green": System.out.print("green ");
            case "blue": System.out.print("blue ");
            default: System.out.println("done");
        }
    }
}


class LoopsConstructs{

    public static void main(String[] args) {

//        for (/*Initialization*/ ; /*Condition*/ ; /* Iteration */) {
//            /* loop body */
//        }
    }


    static void WhileLoop(){
        int x = 2;
        while(x == 2) {
            System.out.println(x);
            ++x;
        }
    }

    static void DoWhile(){
        do {
            System.out.println("Inside loop");
        } while(false);
    }

    static void ForLoop(){
        for (int i = 0; i<10; i++) {
            System.out.println("i is " + i);
        }
    }

    static void ForLoop1(){
        for (int x = 10, y = 3; y > 3; y++) { }
    }

    static void ForLoop2(){
        for (int x = 1; x < 2; x++) {
            System.out.println(x); // Legal
        }
//      System.out.println(x); // Not Legal! x is now out of scope and can't be accessed.
    }

    static void ForLoop3(){
        for (int x = 0; x < 1; x++) {
        // body code that doesn't change the value of x
        }

        for (int i = 0,j = 0; (i<10) && (j<10); i++, j++) {
            System.out.println("i is " + i + " j is " +j);
        }
    }

    static boolean doStuff() {
        for (int x = 0; x < 3; x++) {
            System.out.println("in for loop");
            return true;
        }
        return true;
    }

    static void ForLoop4(){
        int b = 3;
        for (int a = 1; b != 1; System.out.println("iterate")) {
            b = b - a;
        }
    }

    static void EnhancedForLoop(){
        int [] a = {1,2,3,4};
        for(int x = 0; x < a.length; x++) // basic for loop
            System.out.print(a[x]);
        for(int n : a) // enhanced for loop
            System.out.print(n);
    }


    static void ForLoop5(){
        boolean problem = true;
        while (true) {
            if (problem) {
                System.out.println("There was a problem");
                break;
            }
        }
    }

    static void ForLoop6(){
        int y = 10;
        foo:
        for (int x = 3; x < 20; x++) {
            while(y > 7) {
                y--;
            }
        }
    }

    static void ForAndWhile(){
        boolean isTrue = true;
        outer:
        for(int i=0; i<5; i++) {
            while (isTrue) {
                System.out.println("Hello");
                break outer;
            } // end of inner while loop
            System.out.println("Outer loop."); // Won't print
        } // end of outer for loop
        System.out.println("Good-Bye");
    }

    static void LabeledFor(){
        outer:
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                System.out.println("Hello");
                continue outer;
            } // end of inner loop
            System.out.println("outer"); // Never prints
        }
        System.out.println("Good-Bye");
    }
}

class MyFirstException extends IOException {}
class MySecondException extends RuntimeException{}

class ExceptionsExample{
    static void Template(){
        try {
            // This is the first line of the "guarded region".
        }
//        catch(MyFirstException mfe) {
            // Put code here that handles this exception
//        }
        catch(MySecondException mse) {
            // Put code here that handles this exception
        }
        finally {
            // Put code here to release any resource we
            // allocated in the try clause
        }
        // More code here
    }

    static void Ex1(){

    }
}

class ReadData {
    public static void main(String args[]) {
        try {
            RandomAccessFile raf = new RandomAccessFile("myfile.txt", "r");
            byte b[] = new byte[1000];
            raf.readFully(b, 0, 1000);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO Error");
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }
}


class Test08 {
    public int myMethod1() throws EOFException {
        return myMethod2();
    }
    public int myMethod2() throws EOFException {
// code that actually could throw the exception goes here
        return 1;
    }

    int parseInt(String s) throws NumberFormatException {
        boolean parseSuccess = false;
        int result = 0;
// do complicated parsing
        if (!parseSuccess) // if the parsing failed
            throw new NumberFormatException();
        return result;
    }
}


class MyException01 extends Exception {
    void someMethod() throws MyException01 {
        doStuff();
    }

    void doStuff() throws MyException01 {
        try {
            throw new MyException01();
        } catch (MyException01 me) {
            throw me;
        }
    }
}

class TestEx {
    public static void main (String [] args) {
        badMethod();
    }
    static void badMethod() { // No need to declare an Error
        doStuff();
    }
    static void doStuff() { // No need to declare an Error
        try {
            throw new Error();
        }
        catch(Error me) {
            throw me; // We catch it, but then rethrow it
        }
    }
}


class Ex6point1{
    public static void main(String[] args) {
        char c = 'a';
        switch (c){
            default:{
                System.out.println("None matched ");
                break;
            }
            case 'b':{
                System.out.println('b');
                break;
            }
            case 'c':{
                System.out.println('c');
                break;
            }
            case 'a':{
                System.out.println('a');
                break;
            }
        }
    }
}

class AgeChecker {
    public static void main(String[] args) {
        int age = 10;

        outer: while (age <= 21) {
            while (true) {
                if (age == 16) {
                    System.out.println("Get your driver's license");
                    age++;
                    continue outer;
                } else {
                    System.out.println("Another year.");
                    age++;
                    break;
                }
            }
        }
    }
}

class Propagate{
    public static void main(String[] args) {
        try {
            System.out.println(reverse("ABC"));
        }
        catch (IllegalArgumentException eae){
            eae.printStackTrace();
        }
        finally {
            System.out.println("executed successfully");
        }
    }

    static String reverse(String s){
        if(s.length() == 0){
            throw new IllegalArgumentException();
        }
        String revStr = "";
        for (int i = s.length() - 1; i >= 0 ; i-- ){
            revStr += s.charAt(i);
        }
        return revStr;
    }

}

