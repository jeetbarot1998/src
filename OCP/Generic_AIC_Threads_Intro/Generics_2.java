package OCP.Generic_AIC_Threads_Intro;
import java.util.ArrayList;
import java.util.List;

public class Generics_2 {
}
class TestGen2{
    public static void main(String ...args){
        ArrayList <String> als = new ArrayList<>();
        ArrayList <Integer> ali = new ArrayList<>();
        ArrayList <Object> alo = new ArrayList<>();
        ArrayList <Number> aln = new ArrayList<>();
        ArrayList <Double> ald = new ArrayList<>();
        ArrayList <Comparable> alc = new ArrayList<>();
        // m1(als);
        m2(aln);
        m2(alo);
        // m1(ali);
        // m1(ald);
        // m1(alc);
    }

    static void m1(ArrayList<? extends Number> al){
        System.out.println(al);
    }

    static void m2(ArrayList<? super Number> al){
        System.out.println(al);
        al.add(new Double(10.0));
        al.add(new Float(10.1));
    }
}

class AGen1{}
class BGen1 extends AGen1{}
class CGen1 extends BGen1{}
class DGen1 extends CGen1{}

class EGen1{

    public static void main(String ...args){
        ArrayList <AGen1> ala = new ArrayList<>();
        ArrayList <BGen1> alb = new ArrayList<>();
        ArrayList <CGen1> alc = new ArrayList<>();
        ArrayList <DGen1> ald = new ArrayList<>();
        // m1(ala);
        m1(alb);
        m1(alc);
        m1(ald);
        m2(alb);
    }

    static void m1(ArrayList<? extends BGen1> al){
        System.out.println(al);
        // You cannot add even a child of class 'C'
        // because it might be the case  that the input array
        // is of type  'D' which is a type of 'B'
        // But you are trying to add 'C', which is of type Parent
        // al.add(new CGen1());
        // al.add(new CGen1());
    }

    static void m2(ArrayList<? super BGen1> al){
        al.add(new BGen1());
        al.add(new CGen1());
        System.out.println(al);
        // al.add(new AGen1()); => Cannot pass this.
        // You can add here as everything that will be
        // child can be stored in a parent type reference.
    }
}

class GenericAndNonGen{
    public static void main(String ...args){ // generic area
        ArrayList <String> al = new ArrayList();
        al.add("A");
        al.add("B");
        // al1.add(10); => Type satefy maintained

        m1(al);
        // al1.add(10); => Type satefy maintained
        System.out.println(al);
    }

    static void m1(ArrayList al1){
        System.out.println("Type  safety not maintained");
        al1.add(10);
        al1.add(true);
        System.out.println(al1);
    }
}

class GenericsMethodOverLoading{
    public static void main(String ...args){
        System.out.println("This will lead to compile time error as \n" +
                " type safety is removed after compile time. \n" +
                "So if type information is removed both the over \n" +
                "loaded methods are exactly the same hence error.");
        ArrayList <String> al = new ArrayList();
        al.add("A");
        al.add("B");
        m1(al);
    }

    // static void m1(ArrayList<String> al1){}
    static void m1(ArrayList al1){}
}

