package Java1_8;

@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();
//    void myMethod2();

    default void defaultMethod() {
        System.out.println("Default method");
    }

    public static void staticMethod(){
        System.out.println("Static method");
    }

    public static void main(String[] args) {
        System.out.println("Main inside Interface");
    }
}



public class Lect1 implements MyFunctionalInterface{
    @Override
    public void myMethod() {

    }

    @Override
    public void defaultMethod() {
        MyFunctionalInterface.super.defaultMethod();
    }
}

class c1 implements MyFunctionalInterface{
    @Override
    public void myMethod() {

    }
}

class c2 implements MyFunctionalInterface{
    @Override
    public void myMethod() {
    }
}


class c3{
//  MyFunctionalInterface is the data type to save the lambda expression
    MyFunctionalInterface i = () -> {
        // This automatically gives the implementation for the 'myMethod' in the interface MyInterface
        // As there is only one abstract method and hence its Functional interface
        System.out.println("This automatically gives the implementation for the 'myMethod'\n " +
            " in the interface MyInterface\n" +
            " As there is only one abstract method and hence its Functional interface");
    };
//    If there are more than one abstract method in the interface then an error
//    'Multiple non-overriding abstract methods found in interface Java1_8.MyFunctionalInterface' will come.

    public static void main(String[] args) {
        MyFunctionalInterface i1 = () -> {
            System.out.println("This automatically gives the implementation for the 'myMethod'\n " +
                    " in the interface MyInterface\n" +
                    " As there is only one abstract method and hence its Functional interface");
        };
        i1.myMethod();
        i1.defaultMethod();
        MyFunctionalInterface.staticMethod();
    }
}
