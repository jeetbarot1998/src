package OCA_Dumps;

import java.util.Stack;

public class Q7 {
    public static void main(String[] args) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        processStack(s1,s2);
        System.out.println(s1 + " " + s2);
    }
    static void processStack(Stack x1, Stack x2){
        x1.push(new Integer(10));
        x2 = x1;
    }
}

class M{}

class N{
    private M m = new M();

    void makeItNull(M pm){
        pm = null;
    }

    void makeThisNull(){
        makeItNull(m);
    }

    public static void main(String[] args) {
        N n = new N();
        n.makeThisNull(); // after this line 'm' is not
//        available for garbage collection as the local variable has been
//        assigned to null not the instance variable 'm'.
    }
}

//- if(x instanceof y)
//        - if ‘y’ is a class then x and y should have a parent child relationship in order to even compile, and it will give compilation error.
//        - if ‘y’ is an interface then x and y need not have a parent child relationship.

interface Flyer{}
class Bird implements Flyer{}
class Eagle extends Bird{}
class Bat{}

class TestClass71{
    public static void main(String[] args) {
        Flyer f = new Eagle();
        Eagle e = new Eagle();
        Bat b = new Bat();

        String s = "";

//        if (s == b){
//
//        }

        if(f instanceof Flyer){
            System.out.println("f is a Flyer");
        }
        if(e instanceof Bird){
            System.out.println("e is a Bird");
        }
        System.out.println("b instanceof Bird will give CE as they are not having \n" +
                "parent child relationship and Bird is a class");
//        if(b instanceof Bird){
//            System.out.println("b is a Bird");
//        }
        System.out.println("b instanceof Flyer will give false as they are not having \n" +
                "parent child relationship and Flyer is a class");
        if (b instanceof Flyer){
            System.out.println("b is a Bird");
        }

        System.out.println(1 == 1.0); // true
        System.out.println(1 == 1.0f); // true
    }
}

















