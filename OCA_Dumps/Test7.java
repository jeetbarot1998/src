package OCA_Dumps;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Test7 {
}

class NewException extends Exception {}
class AnotherException extends Exception {}
class ExceptionTest{
    public static void main(String [] args) throws Exception{
        try{          m2();       }
        finally{ m3(); }     }
    public static void m2() throws NewException{  throw new NewException();  }
    public static void m3() throws AnotherException{  throw new AnotherException();
    }
}

class TestClass711 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> al = new ArrayList<String>();
        al.add("111");
        al.add("222");
        System.out.println(al.get(al.size()));
    }

//    void m1() throws Exception{
//        try{
//            throw new IOException();
//            throw new SQLException();
//        }
//        catch (IOException e){
//            throw new SQLException();
//        }
//        catch(SQLException e){
//            throw new InstantiationException();
//        }
//        finally{
//            throw new CloneNotSupportedException(); // this is not a RuntimeException.
//        }
//    }
}


class TestClass72{
    public static void main(String[] args)  {     calculate(100);    }
    public static void calculate(int x){
        String val;
        switch(x){
            case 2:
//                val = "def";
            default:
                val = "def";
        }
        System.out.println(val);
    }
}


class TestClass712{
    public void testRefs(String str, StringBuilder sb){
        str = str + sb.toString();
        sb.append(str);
        str = null;
        sb = null;
    }
    public static void main(String[] args){
        String s = "aaa";
        StringBuilder sb = new StringBuilder("bbb");
        new TestClass712().testRefs(s, sb);
        System.out.println("s="+s+" sb="+sb);
    }
}

class X{
    int val = 10;
}
class Y extends X{
    Y val = null; //1
}
class TestClass713 extends X{
    public static void main(String[] args){
        Y y = new Y();
//        int k = (X) y.val ; //2
//        System.out.println(k);
    }
}

class Data{
    int value;
    Data(int value){
        this.value = value;
    }
    static void printUsefulData(ArrayList<Data> dataList, Predicate<Data> p){
        for(Data d: dataList){
            if(p.test(d)) System.out.println(d.value);
        }
    }



    public static void main(String[] args) {
        ArrayList<Data> al = new ArrayList<Data>();
        al.add(new Data(1));al.add(new Data(2));al.add(new Data(3));
        printUsefulData(al, (Data d)-> { return d.value>2; });
        printUsefulData(al, d-> d.value>2 );
        printUsefulData(al, (d) -> d.value>2);
//        printUsefulData(al, (d)-> return d.value>2;);

    }
}


class TestClass73{
    void probe(int... x) { System.out.println("In ..."); }  //1

//    void probe(Integer x) { System.out.println("In Integer"); } //2

//    void probe(long x) { System.out.println("In long"); } //3

    void probe(Long x) { System.out.println("In LONG"); } //4

    public static void main(String[] args){
//        Integer a = 4; new TestClass73().probe(a); //5
        int b = 4; new TestClass73().probe(b); //6

    }
}

class TestClass74{
    public static void main(String args[]){
        try{
            m1();
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("1");
            throw new NullPointerException();
        }
        catch(NullPointerException e){
            System.out.println("2");
            return;
        }
        catch (Exception e) {
            System.out.println("3");
        }
        finally{
            System.out.println("4");
        }
        System.out.println("END");
    }
    static void m1(){
        System.out.println("m1 Starts");
        throw new IndexOutOfBoundsException( "Big Bang " );
    }
}













