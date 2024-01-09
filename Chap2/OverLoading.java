package Chap2;

public class OverLoading {
}

// ================== Polymorphism in action ======================
class c1{
    public void m1(){
        System.out.println("c1 m1");
    }
}

class c2 extends c1{
    public void m1(){
        System.out.println("c2 m1");
    }

    public void m2(){
        System.out.println("c2 m2");
    }
}

class c3{

    void f1(c1 c){
        c.m1();
    }

    void f1(c2 c){
        c.m1();
        c.m2();
    }

    public static void main(String[] args) {
        c1 c = new c1();
        c1 cc = new c2();
        c1 ccc = new c1();
        c3 cx = new c3();
        cx.f1(cc);
    }
}


