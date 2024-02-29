package OCA_Dumps;

import java.util.ArrayList;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        List s1 = new ArrayList( );
        s1.add("a");
        s1.add("b");
        s1.add("c");
        s1.add("a");
//        System.out.println(s1.remove(1));
        if(s1.remove("a")){
            if(s1.remove("a")){
                s1.remove("b");
            }else{
                s1.remove("c");
            }
        } System.out.println(s1); // [c]
    }
}

class Test61{
    public static void main(String[] args) {
        boolean b1 = false;
        boolean b2  = false;
        if (b2 = b1 == false){
            System.out.println("true"); // true
        }
        else{
            System.out.println("false");
        }
    }
}


class TestClass62{
    public static Integer wiggler(Integer x){
        Integer y = x + 10;
        x++;
        System.out.println(x);
        return y;
    }

    public static void main(String[] args){
        Integer dataWrapper = new Integer(5);
        Integer value = wiggler(dataWrapper);
        System.out.println(dataWrapper+value); // 6,20
    }
}

class TestClass63{
    public static void main(String args[]){
        int i;
        int j;
        for (i = 0, j = 0 ; j < 1 ; ++j , i++){
            System.out.println( i + " " + j );
        }
        System.out.println( i + " " + j );
    }
}


interface Pow{
    static void wow(){
        System.out.println("In Pow.wow");
    }
}
abstract class Wow{
    static void wow(){
        System.out.println("In Wow.wow");
    }
}
class Powwow extends Wow implements Pow {
    public static void main(String[] args) {
        Powwow f = new Powwow();
        f.wow();
//        ((Pow)f).wow();
        Pow f2 = new Powwow();
//        f2.wow();

    }
}


class Test64{
    public void m1() {   }
}
class Test65 extends Test64{
    public void m1() {   }
}
class Test66 extends Test65{
    public void m1(){
//      super.super.m1();
    }
}




class SomeThrowable extends Throwable { }
class MyThrowable extends SomeThrowable { }
class TestClass66{
    public static void main(String args[]) throws SomeThrowable{
        try{
            m1();
        }
        catch(SomeThrowable e){
            throw e;
        }
        finally{
            System.out.println("Done");
        }
    }
    public static void m1() throws MyThrowable{
        throw new MyThrowable();
    }
}

class TestClass67{
    public static void main(String args[ ] ){
        StringBuilder sb = new StringBuilder("12345678");
        sb.setLength(5);
        System.out.println(sb);
        System.out.println(sb.length());
        sb.setLength(10);
        System.out.println(sb);
        System.out.println(sb.length());
    }
}

interface Bar6{
    default void bar(){};
}
abstract class FooBase{
//    public static void bar(){
//        System.out.println("In static bar");
//    }
}
class Foo extends FooBase implements Bar6 {
    public static void main(String[] args) {
        Foo f=  new Foo();
    }
}




