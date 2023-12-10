package Chap5_6;

public class Lect5_Switch_While_Do_While {
    public static void main(String[] args) {
        if(true);
        else;

//      =====================================
        int x = 4;
        int y = 4;

        System.out.println("You cannot use a variable and compare. \n" +
                "The case statement must have a constant to compare.");
        switch (x){
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
//          invalid.
//            case y:
//                System.out.println(y);
//                break;
            default:
                System.out.println("default");
                break;
        }

//      =====================================

        System.out.println(" Expression 'x+2' is being evaluated. ");

        switch (x + 2) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
            case 5:
                System.out.println(6);
                break;

//          default is not compulsory.
//            default:
//                System.out.println("default");
//                break;
        }

//      =====================================

        System.out.println("x++ \n Here post increment is used hence," +
                " value '4' is passed.");
        switch (x++){
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
            case 5:
                System.out.println(6);
                break;
        }

//      =====================================

        System.out.println("cannot have any statement between cases.");
        System.out.println("The constants Must be of same type as the 'expression'. ");

        byte b = 10;
        switch (b){
//            case "a":
//                System.out.println("a");
//                break;
            case 120:
                System.out.println(120);
                break;

            case 'a':
                System.out.println("used character");
                break;

//            System.out.println("Here");
//            case 1200:
//                System.out.println("1200");
//                break;
//          This is fine
            case (byte)1200:
                System.out.println("1200");
                break;
        }

//      =====================================

        System.out.println("Byte data type + 1 will give an int type");
        switch (b+1){
            case 11:
                System.out.println("11");
                break;
            case 1200:
                System.out.println("1200");
                break;
        }


//      =====================================
        System.out.println("You cannot have 2 matching cases");

        int i = 10;
        switch (i){
//            case 97:
//                System.out.println("97");
//                break;
            case 100:
                System.out.println(100);
                break;
//            case 'a':
//                System.out.println("97");
//                break;
            default:
                System.out.println("default");
        }

//      =====================================

        System.out.println("Fall through case");

        int num = 2;
        switch (num) {
            case 1:
                System.out.println("One");
                // No break, so it falls through to the next case
            case 2:
                System.out.println("Two");
                // No break, so it falls through to the next case
            case 3:
                System.out.println("Three");
                break; // Break statement to end the switch block
            default:
                System.out.println("Default");
        }


        System.out.println("Fall through case example 2");

        num = -1;
        switch (num) {
            default:
                System.out.println("Default");
            case 1:
                System.out.println("One");
                // No break, so it falls through to the next case
            case 2:
                System.out.println("Two");
                // No break, so it falls through to the next case
            case 3:
                System.out.println("Three");
                break; // Break statement to end the switch block

        }
//      =====================================

        System.out.println("Comparing with 'FINAL' access modifier" +
                "At run time all the 'final' variables are converted to constant");

        num = 10;
        final int q = 10;

        switch (num){
            case 1:
            case 2:
                System.out.println(2);
                break;
            case q:
                System.out.println("Using a constant variable to compare in switch.");
                break;
        }
    }
}

class WhileIteration{
    public static void main(String[] args) {

//      =================

        System.out.println("while w/o curly braces");


//      ================

//        System.out.println("");


    }

    void WhileEx1(){
        while (true)
            ;
    }

    void UnreachableWhileEx(){
//================= Loop condition is always false making the loop body unreachable
//        while (false)
//            ;
    }



    void WhileEx2(boolean b){
//====================      might result in stack overflow error
        while (b)
            System.out.println("hi");
        System.out.println("hello");
    }

    void InvalidWhileEx1(){
//====================
        System.out.println("Declaration not allowed here wo curly braces");
//        while (true)
//            int x=0;
    }

    void InvalidWhileEx2(){
        while (true){
            int x = 0;
        }
    }
    void InvalidWhileEx3(){
//====================      Cannot provide non-boolean as expression. Provided: int
//        while (1){
//            int x = 0;
//        }
    }

    void UnreachableWhileEx3(){
//====================        The while loop will run unlimited times and hence the "hi" code is unreachable.
//        while (true){
//            System.out.println("Hello");
//        }

//        System.out.println("hi");
    }

    void InvalidWhile3(){
//====================      Loop condition is always false making the loop body unreachable.
//        while (false) {
//            System.out.println("hi");
//        }

//        System.out.println("hello");
    }

    void RuntimeInvalidWhile4(){
//===================      Runtime Stack overflow error.
        int x = 10;
        int y = 20;
        while (x<y){
            System.out.println("hi");
        }
        System.out.println("Hello");
    }


    void InvalidWhile5(){
//=================== Unreachable statement outside the while loop as x and y are final.
//        final int x = 10;
//        final int y = 20;
//        while (x<y){
//            System.out.println("hi");
//            }
//        System.out.println("Hello");
    }

    void InvalidWhile6(){
//=================== Loop condition is always false making the loop body unreachable as x and y are final.
//        final int x = 10;
//        final int y = 20;
//        while (x>y){
//            System.out.println("hi");
//            }
//        System.out.println("Hello");
    }

}



class DoWhile{

    void doWhile(){
        do
            ;
        while (true);

    }

    void doWhile2(){
        do
            ;
        while (false);
    }

    void IllegaldoWhile3(){
//============== Declaration not allowed here wo curly braces
//        do
//            int x = 5;
//        while (true);
    }


    void IllegaldoWhile4(){
// ============= Cannot have any other line between 'do' and 'while'. 'while' expected.
//        do{
//            int x = 5;
//        }
//        System.out.println("Hello");
//        while (true);
    }


    void IllegaldoWhile6(){
//============== Illegal start of expression.
//        do
//            while(true);
//        while (true);
    }

    void doWhile5(){
//================= Infinite 'hello'.
        do
            while(true)
                System.out.println("hello");
        while (true);
    }

    void IllegaldoWhile7(){
//================= Unreachable statement.
//        do {
//            System.out.println("hello");
//        }
//        while (true);
//        System.out.println("Hello");
    }

    void IllegaldoWhile8(){
        boolean x = true;
        do {
            System.out.println("hello");
        }
        while (x);
        System.out.println("Hello");
    }

    void IllegaldoWhile9(){
//================= Unreachable statement.
//        final boolean x = true;
//        do {
//            System.out.println("hello");
//        }
//        while (x);
//        System.out.println("Hello");
    }

    void doWhile7(){
        do {
            System.out.println("hello");
        }
        while (false);
        System.out.println("Hi");
    }

    void RuntimedoWhile8(){
//===================       Stack overflow error at runtime.

        int x = 10;
        int y = 20;
        do {
            System.out.println("hello");
        }
        while (x<y);
        System.out.println("Hi");
    }


    void doWhile9(){
//=================== Loop condition is always false making the loop body unreachable as x and y are final.
//        final int x = 10;
//        final int y = 20;
//        do {
//            System.out.println("hello");
//        }
//        while (x<y);
//        System.out.println("Hi");
    }

    void doWhile10(){
        final int x = 10;
        final int y = 20;
        do {
            System.out.println("hello");
        }
        while (x>y);
        System.out.println("Hi");
    }
}

class ForLoop{

    public static void main(String[] args) {
        for(int i =0; true|false ; i++){
            if(--i ==0 || i==2){
                System.out.println("YES: " + i + " ");
                break;
            }
            else if (i++ %2 ==0){
                System.out.println("NO: " + i + " ");
            }
        }
    }

    void UnreachableForLoop(){
//=================== Loop condition is always true making the code outside for loop Unreachable.
//        for(int x = 5;5<7; x++){
//            System.out.println("hi");
//        }
//        System.out.println("hello");
    }

    void UnreachableForLoop2(){
//=================== Loop condition is always false making the loop body unreachable.
//        for(int x = 5;5>7; x++){
//            System.out.println("hi");
//        }
//        System.out.println("hello");
    }

    void ForLoop3(){
//=================== Loop condition is always false making the loop body unreachable.
        int a = 10;
        int b = 20;
        for(int x = 5;a>b; x++){
            System.out.println("hi");
        }
        System.out.println("hello");
    }

    void UnreachableForLoop4(){
//=================== Loop condition is always false making the loop body unreachable as a and b are final.
//        final int a = 10;
//        final int b = 20;
//        for(int x = 5;a>b; x++){
//            System.out.println("hi");
//        }
//        System.out.println("hello");
    }

    void UnreachableForLoop5(){
//=================== Loop condition is always true making the code outside for loop Unreachable as a and b are final.
//        final int a = 10;
//        final int b = 20;
//        for(int x = 5;a<b; x++){
//            System.out.println("hi");
//        }
//        System.out.println("hello");
    }


    void UnreachableForLoop6(){
//=================== Loop condition is always false making the loop body unreachable as a and b are final.
//        final int a = 10;
//        final int b = 20;
    //        for(int x = 5;false; x++){
    //            System.out.println("hi");
    //        }
    //        System.out.println("hello");
    }


    void UnreachableForLoop7(){
//=================== Loop condition is always true making the code outside for loop Unreachable as a and b are final.
//        final int a = 10;
//        final int b = 20;
//        for(int x = 5;true; x++){
//            System.out.println("hi");
//        }
//        System.out.println("hello");
    }

    void CEForLoop7(){
//        for(int x = 5;int x<10; x++){
//            System.out.println("hi");
//        }
//        System.out.println("hello");
    }

    void CEForLoop8(){
//        for(int x = 5;x<10; x++)
//            int i =10;

    }


    void ForLoop9(){
        for(int x = 5;x<10; x++){
            ;
        }
    }

    void ForLoop10(){
        for(int x = 5;x<10; x++);
    }

    void CEForLoop11(){
//        for(int x = 5, int j = 0;x<10; x++);
    }

    void ForLoop12(){
        for(int x = 5, j=10;x<10; x++){
            System.out.println("hi");
        }
    }

    void CEForLoop13(){
//      Cannot have multiple Data types
//        for(String p = "", int x = 5, j=10;x<10; x++){
//            System.out.println("hi");
//        }
    }

    void ForLoop14(){
        int i = 0;
        for (System.out.println("Hello");i < 10; i ++)
            System.out.println("hi");

//      Will print "Hello" once and "hi" 10 times
    }

    void ForLoop15(){
//      Infinite
        for (System.out.println("Hello");;)
            System.out.println("hi");
    }

    void ForLoop16(){
//      Infinite
        for (;;)
            System.out.println("hi");
    }

    void ForLoop17(){
//      Infinite
        for (;true; System.out.println("hi"))
            System.out.println("A");

//      Infinite 'A' 'hi' 'A' 'hi' .....
    }


    void ForLoop18() {
//      Infinite
        for (; ; ) ;
    }

    void CEForLoop19() {
//================ Unreachable statement
//        for (int i = 0; ;i++ ){
//            System.out.println("hello");
//        }
//        System.out.println("hi");
    }
}

//  Order should be the same
//interface i{}
//class A{}
//class B implements i extends A{}


class Test05{
    public static void main(String[] args) {
        Integer i = 6;
        int i1 = 6;
        System.out.println(i==i1);
        byte b = 6;
        Byte b1 = 6;
        System.out.println("b==i : " +(b==i));
        System.out.println("b==i1 :" +(b==i1));
        System.out.println(b==b1);
        System.out.println("b1.equals(i1) : " + (b1.equals(i1)));
        System.out.println(" b1.equals(i) : " + (b1.equals(i)));
    }
}

