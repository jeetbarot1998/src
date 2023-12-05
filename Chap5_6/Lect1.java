package Chap5_6;

import java.io.*;

public class Lect1 {
}

class TestExeption{
    public static void main(String ...args) {
        System.out.println("Inside main");
        m1();
        System.out.println("after m1");
    }

    static void m1(){
        System.out.println("m1");
        m2();
        System.out.println("After m2");

    }

    static void m2(){
        System.out.println("Inside m2");
        System.out.println(20/0);
        System.out.println("After illegal Division in m2");
        System.out.println("Hello");
    }
}
// ===== If you are creating an object of runtime object then the
// compiler will not force you to handle it
// ===== If you are creating an object of compile time object then the compiler
// will force you to handle the exception using either
// try catch or ‘throws’ keyword.

class ImplicitException{
    public static void main(String[] args) {
        System.out.println("" +
                "1. Implicit exception is executed \n" +
                "2. Exception object is passed to the JVM \n" +
                "3. JVM calls the default Handler \n");
        System.out.println(10/0);
    }
}

class ExplicitException{
    public static void main(String[] args) {
        System.out.println("" +
                "1. Programmatically create exception object \n" +
                "2. Pass the exception to JVM using ''throw'' ");
        throw new ArithmeticException("Programmatically custom Runtime time ArithmeticException");

    }
}

class TestReadFile{
//      This way you have implemented the exception on the whole method
    public static void main(String ...args) throws FileNotFoundException {
//      The compiler forces us to implement the "FileNotFoundException" as
//      there might not be such a file and hence handle the checked exception.
        PrintWriter pw = new PrintWriter("abc.txt");
        pw.write("hi");
        System.out.println("Hello");
    }
}

class TestReadFileTryCatch{
    public static void main(String ...args) {
//      The compiler forces us to implement the "FileNotFoundException" as
//      there might not be such a file and hence handle the checked exception.
        PrintWriter pw = null;
//      This way you have implemented the exception only on the part of the code
//      which can have checked exception.
        try {
            pw = new PrintWriter("abc.txt");
            System.out.println("Will not reach here if the error comes");
        } catch (Exception e){
            System.out.println("error" + e);
//            throw new RuntimeException(e);
        }

        pw.write("hi");
        System.out.println("Hello");
    }
}

class TestArithmeticException{
//  You can have nested try catch block.
    public static void main(String[] args) {
        try {
            int i = 10/0;
            System.out.println("Will not reach here if the error comes");
        }
        catch (ArithmeticException AE){
            System.out.println("divide by zero error");
            System.out.println("Divide by zero of 10/0");
//                int i = 20/0; // unhandled exception
            try{
                int i = 20/0; // unhandled exception
            }
            catch (ArithmeticException AE2){
                System.out.println("Divide by zero of 20/0");
            }
        }
        System.out.println("After Catch");
    }
}


class RuntimeExc{
    //  Will be compiled as it is a runtime exception thus we need not handle it necessarily
    public static void main(String[] args) {
        throw new ArithmeticException("Arithmetic exception");
    }
}

class CompileExc{
//  Will not even be compiled if exception is not handled
//  as it's compile time, thus it's mandatory to handle it.
    public static void main(String[] args) throws IOException {
        System.out.println("Here we have handled a compile time exception \n" +
                "using the 'throws' keyword.\n " +
                " 'throws' in method definition does not actually handles the exception \n" +
                ", Rather it delegates the responsibility of handling \n" +
                " the exception to the caller of the method. \n" +
                " Inside the method we have used 'throw' to throw a \n " +
                " certain type of exception \n" +
                " and the method has been defined to delegate the responsibility \n" +
                " of handling this certain type of exception to the caller  \n" +
                " of the method using the keyword 'throws' \n." +
                " Then we will have to handle this certain exception \n" +
                " using try catch in the parent method. \n");
        throw new IOException("Programmatically custom Compile time IOException");
    }
}


class TestArithmeticException2{
    public static void main(String[] args) throws ArithmeticException {
//        int i = 10/0;
        System.out.println("Will not reach here if the error comes");
        System.out.println("divide by zero error");
        int s = 20/0; // unhandled exception
        System.out.println("After Catch");
    }
}


// Over-riding methods which throws exception
//- You can narrow the exception type (covariant return types).
//- You cannot throw new or broader checked exceptions.
//- You can throw unchecked exceptions without restrictions.

class Parent {
    void method() throws IOException {
        // Some code that throws IOException
    }
}

class Child extends Parent {
    // OK: Throwing narrow scoped exception
    // @Override
    // void method() throws FileNotFoundException { // OK: FileNotFoundException is a subclass of IOException
    //  // Some code that throws FileNotFoundException
    //  }

    // NOT OK: Throwing broader checked exception
    // @Override
    // void method() throws Exception { ... }

    // OK: Throwing unchecked exception
    @Override
    void method() throws NullPointerException { // OK: NullPointerException is unchecked
        // Some code that throws NullPointerException
    }

    // OK: No exception declaration
    // @Override
    // void method() { ... }
}







