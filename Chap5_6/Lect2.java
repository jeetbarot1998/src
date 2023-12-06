package Chap5_6;

import java.io.IOException;

public class Lect2 {
}

class ExceptionDemo{
    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        System.out.println("Hello");

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        for (StackTraceElement element : stackTrace) {
            System.out.println("Class: " + element.getClassName() +
                    ", Method: " + element.getMethodName() +
                    ", Line Number: " + element.getLineNumber());
        }

        try{
            System.out.println(10/0);
        }
        catch (Exception E){
            E.printStackTrace();
//            System.out.println(E.toString());
//            System.out.println(E.getMessage());
        }
    }
}


class Test22{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ASDFGHJKL");
        Thread.sleep(1000);
        throw new InterruptedException();
    }
}
class Test221{
    public static void main(String[] args) {
        System.out.println("ASDFGHJKL");
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println("exception occurred as " + e);
        }
    }
}

class TestExeption23{
    public static void main(String ...args) {
//      Really Handling the exception.
        try{
            m1();
        }
        catch (Exception e){
            System.out.println(e);
        }
        m3();
        m4();
//        m5();// will not work
//      We need to handle compile time exceptions specifically.
//      Either by delegating or by using try catch.
        try{
            m5();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static void m3() throws ArithmeticException{
//      This works because we need not handle the runtime exception specifically and the
//      caller function need not specifically delegate or use try catch.
        throw new ArithmeticException();
//        System.out.println("Here"); // unreachable statement
    }

    static void m4(){
//      This works because we need not handle the runtime exception specifically and the
//      caller function need not specifically delegate or use try catch.
        throw new ArithmeticException();
//      System.out.println("Inside m4"); // unreachable statement
    }

    static void m5() throws InterruptedException{
//      This works because we need not handle the runtime exception specifically
//      But we need to handle compile time exceptions specifically in the caller method
//      Either by delegating or by using try catch.
        throw new ArithmeticException();
//        System.out.println("Inside m5"); // unreachable statement
    }

    static void m6() throws ArithmeticException{
//      This will not work because we need to handle compile time exception specifically and
//      the method signature defines that it only returns a runtime exception.
//        throw new InterruptedException();
//        System.out.println("Inside m5"); // unreachable statement
    }
    static void m1() throws InterruptedException {
//      We need to handle compile time exceptions specifically.
        System.out.println("using 'throws' to delegate " +
                "the handling to the main method");
        m2();
    }

    static void m2() throws InterruptedException{
        System.out.println("using 'throws' to delegate " +
                "the handling to the m1 method");
        Thread.sleep(10001);
//        throw new InterruptedException();
    }
}

class Demo{
    public static void main(String[] args) {
        foo();
        bar();
    }
    static void foo() throws DemoRunTime{
        System.out.println("Hello");
    }

    static void bar(){
//      As class DemoRunTime is of type
//      'RuntimeException' which is Runtime exception we
//      need not handle it exclusively
      System.out.println("Hello");
      throw new DemoRunTime();
    }


}

class DemoRunTime extends RuntimeException{}
//class DemoCompileTime extends{}

class Demo2 extends RuntimeException{
    public static void main(String[] args) {
        foo();
    }
    static void foo() throws Demo2{
        System.out.println("Hello");
    }

}

class Test23{
    public static void main(String[] args) {
        foo();
    }

    static void foo(){
//      As class MyException is of type
//      'Exception' which is partially checked exception thus it will not compile
//        throw new MyException();
    }
}

class MyException extends Exception{}



class TestErrorException{
    void m1(){
        throw new Error();
    }
}

class TestIOException{
    public static void main(String[] args) {
//      If you are not doing any operation which can throw
//      checked exception then you cannot catch checked exception.
//        try{
//            System.out.println("HELLO");
//        }
//        catch (IOException IO){
//        }
//        ==================================
//        try{
//            System.out.println("HELLO");
//        }
//        catch (InterruptedException IO){
//        }
//        ===================================

//      you can catch unchecked even if you are not doing any such operation.
        try{
            System.out.println("HELLO");
        }
        catch (Error E){
        }

        try{
            System.out.println("HELLO");
        }
        catch (ArithmeticException E){
        }

        try{
            System.out.println("HELLO");
        }
        catch (Exception E){
        }
    }
}





