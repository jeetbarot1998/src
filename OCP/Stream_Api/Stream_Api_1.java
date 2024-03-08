package OCP.Stream_Api;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Stream_Api_1 {
    public static void main(String[] args) {
        Function<Integer, Integer> f = i -> i*i;
        System.out.println("Function " + f.apply(5));

        UnaryOperator<Integer> u = i -> i*i;
        System.out.println("UnaryOperator: " + u.apply(5));

        IntUnaryOperator ui = i -> i*i;
        System.out.println("IntUnaryOperator: " + ui.applyAsInt(5));

        BiFunction<String ,String,String> bf = (s1,s2) -> s1 + " " + s2;
        System.out.println("BiFunction: " + bf.apply("ABC", "CDE"));

        BinaryOperator<String> bo = (s1,s2) -> s1 + " " + s2;
        System.out.println("BinaryOperator: " + bo.apply("ABC", "CDE"));

        LongBinaryOperator lbo = (l1,l2) -> l1*l2;
        System.out.println(lbo.applyAsLong(12L,13L));

        IntBinaryOperator ibo = (l1,l2) -> l1*l2;
        System.out.println(ibo.applyAsInt(12,13));

        DoubleBinaryOperator dbo = (l1,l2) -> l1*l2;
        System.out.println(dbo.applyAsDouble(12.8,13.6));
    }
}

interface i1{
    public static void main(String[] args) {

    }

    void m1();
}


class MethodReference1{
    public static void main(String[] args) {
        i1 i = MethodReference1::m2;
        i.m1();
        i1 ii = () -> m2();
        MethodReference1 mr = new MethodReference1();
        i1 iii = mr::m3;
    }

    public void m3(){
        System.out.println("m3");
    }

    static void m2(){
        System.out.println("Implemented m2");
    }
}

class MethodRefDemo{
    public static void main(String[] args) {
        Runnable r = () ->{
            for(int i = 0; i<10; i++){
                System.out.println("Runnable using Lambda. ");
            }
        };

        Runnable r1 = MethodRefDemo::Execute;
        MethodRefDemo mr = new MethodRefDemo();
        Runnable r2 = mr::instanceExecute;
        Thread t = new Thread(r);
        t.start();
        for(int i = 0; i<10; i++){
            System.out.println("Main Thread ");
        }
    }

    public static void Execute(){
        for(int i = 0; i<10; i++){
            System.out.println("Runnable using Method ref. ");
        }
    }

    public void instanceExecute(){
        for(int i = 0; i<10; i++){
            System.out.println("Runnable using Method ref. ");
        }
    }
}

class EmployeeStreamEx{
    public EmployeeStreamEx() {
        System.out.println("Hi");
    }

    public EmployeeStreamEx(String s) {
        System.out.println("Hi from String " + s);
    }
}

interface intrf{
    EmployeeStreamEx getEmp();
}

class ConstructorMethodRes{
    public static void main(String[] args) {
        intrf i = () -> {
            EmployeeStreamEx e = new EmployeeStreamEx();
            return e;
        };
        i.getEmp();

        intrf ii = EmployeeStreamEx::new; // refers to the default constructors.
    }
}

class StreamDemo{
    public static void main(String[] args) {
        List <Integer> l = new ArrayList<>();
        List <Integer> listOfEven = new ArrayList<>();
        List <Integer> listNumbers = new ArrayList<>();
        l.add(0);
        l.add(10);
        l.add(13);
        l.add(7);
        l.add(15);
        l.add(30);

        for (int i: l) {
            if(i%2==0){
                listOfEven.add(i);
            }
        }
        System.out.println(listOfEven);

        System.out.println(l.stream().filter(i -> (i%2 ==0)).collect(Collectors.toList()));
        System.out.println(l.stream().map(i -> i*2).collect(Collectors.toList()));

    }
}



