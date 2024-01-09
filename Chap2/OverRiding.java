package Chap2;

public class OverRiding {
}


// ======================= Over riding and over loading with example ===========================
class A {
    static int p = 11;
    int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    void m1() {
        System.out.println("calling from A" + i);
    }

    static void m2() {
        System.out.println("static m2 A");
    }

}

class B extends A{
//    static int p = 12;
//    private int i = 15;

    @Override
    public int getI() {
        return i;
    }

    @Override
    public void setI(int i) {
        this.i = i;
    }

    void m1(){
        System.out.println("calling from B" + i);
    }
//    static void m2(){
//        System.out.println("static m2 B");
//    }
}


class Driver{
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        A a = new A();
        A ab = new B();
        a.m2();
        ab.m2();
        b.m2();
        System.out.println(a.p);
        System.out.println(ab.p);
        System.out.println(b.p);
    }
}

