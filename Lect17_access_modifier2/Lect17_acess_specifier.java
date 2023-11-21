package Lect17_access_modifier2;

// Every class in java extends from "object" class.
public class Lect17_acess_specifier {

}

class Test17{
    void m1(){
        System.out.println("Called m1");
    }

    @Override
    protected void finalize(){
        System.out.println("Called finalize ");
    }

    public static void main(String[] args) {
        Test17 t17 = new Test17();
        t17.finalize();
    }

}


class A1{
    public int x = 7;
    private int y = 9;
}

class B1 extends A1{
//    When inheriting it's as good as the same code exists in the child class as well. Like given below
//    public int x = 7

    public static void main(String[] args) {
/** Accessing using Inheritance => We will create the instance of the child class as we re accessing the method via
 * Inheritance. As the method is available by the virtue of Inheritance, it is the method of accessing using Inheritance.
 * This is denoted as capital "I".
*/
        B1 b = new B1();
        System.out.println(b.x);
/**
 * Accessing using reference operator => We will create member of the class we are trying to access directly.
 * So here we are trying to access method of th parent class hence we are making an instance of the parent class
 * "A1". Here "a" is the reference operator. This is denoted by capital "R".
*/
        A1 a = new A1();
        System.out.println(a.x);

    }
}
