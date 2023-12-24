package Chap5_6;

public class Rev_Lect5 {
    public static void main(String[] args) {

    }

    static void DoWhile(){
        do
            System.out.println("hi");
        while (true);
    }

    static void InvalidWhile(){
        System.out.println("Required type:  boolean, Provided: int");
//        while(1){
//
//        }
    }

    static void NonReachable(){
        System.out.println("Unreachable statement");
//        while(true)
//            System.out.println("HI");
//        System.out.println("Hello");
    }

    static void ReachableWhile1(){
        boolean b = true;
        while(b)
            System.out.println("HI");
        System.out.println("Hello");
    }

    static void NonReachableWhile2(){
        System.out.println("Unreachable statement");
        final boolean b = true;
        while(b)
            System.out.println("HI");
//        System.out.println("Hello");

    }

    static void NonReachableWhile3(){
        System.out.println("Unreachable statement");
//        while(true);
//            System.out.println("HI");
//        System.out.println("Hello");
    }

    static void NonReachableWhile4(){
        System.out.println("Loop condition is always false making the loop body unreachable");
//        while(false);
//        System.out.println("HI");
//        System.out.println("Hello");
    }


    static void ReachableWhile2(){
        System.out.println("Will be in the while loop infinite times and will not print anything");
        boolean b = true;
        while(b);
        System.out.println("HI");
        System.out.println("Hello");
    }

    static void NonReachableWhile5(){
        final int a = 10, b =20;
        System.out.println("Loop condition is always false making the loop body unreachable");
//        while(a>b);
//        System.out.println("HI");
//        System.out.println("Hello");
    }

     static void NonReachableWhile6() {
         final int a = 10, b = 20;
         System.out.println("Unreachable statement");
//        while(a<b);
//        System.out.println("HI");
//        System.out.println("Hello");
     }
}



class DoWhile2{
    public static void main(String[] args) {

        DOwhile25();
        DOwhile();
    }

    void DoWhile(){
        do
            ;
        while (true);
    }

    void NonReachableDoWhile(){
        System.out.println("Non Reachable code");
//        do
//            ;
//        while (true);
//        System.out.println("Hello");
    }


    void InvalidDoWhileEx1(){
//        do
//            int x = 10;
//        while (true);
    }

    void DoWhileEx1(){
        do {
            int x = 10;
        }
        while (true);
    }

    void DoWhileEx2(){
        do while(true)
            System.out.println("Hii");
        while (false);
    }

    void InvalidDoWhile(){
        System.out.println("Expects a while after 'do'");
//        do
//        while (true);
    }


    void DoWhile3(){
        int a = 10 , b =20;
        do{
            System.out.println("Hi");
        }
        while (a<b);
    }


    void DoWhile4(){
        int a = 10 , b =20;
        do{
            System.out.println("Hi");
        }
        while (a>b);
        System.out.println("Hello");
    }

    void DoWhileUnreachable(){
        System.out.println("Unreachable statement");
        final int a = 10, b = 20;
//        do{
//            System.out.println("HI");
//        }
//        while (a<b);
//        System.out.println("Hello");
    }

    static void DoWhile5() {
        final int a = 10, b = 20;
        do{
            System.out.println("HI");
        }
        while (a>b);
        System.out.println("Hello");
    }

    static void DOwhile(){
        int i = 10;
        do
            while(i++<15)
                i = i + 20;
        while (i < 2);
        System.out.println(i);
    }


    static void DOwhile25(){
        int i = 10;
        do
            while(i<15)
                i = i + 20;
        while (i < 2);
        System.out.println(i);
    }


}














