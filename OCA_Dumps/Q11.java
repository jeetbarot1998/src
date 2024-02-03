package OCA_Dumps;

public class Q11 {
}

class Game{
    void play() throws Exception{
        System.out.println("...playing");
    }
}

class Soccer extends Game{
    void play(){
        System.out.println("Playing Soccer");
    }

    public static void main(String[] args) {
        Game g = new Soccer();
//        g.play(); // CE.
        Soccer s = new Soccer();
        s.play();
    }
}


class A{
    int getCode(){
        return 2;
    }
}

class AA extends A{
//    Invalid Overloading
//    long getCode(){
//        return 3;
//    }

    public static void main(String[] args) {
        A a = new A();
        A aa = new AA();
        System.out.println(a.getCode() + " " + aa.getCode());
    }
}


abstract class FooBar{
    static void bar(){
        System.out.println("Bar");
    }
}

interface Bar{
    default void bar(){};
}

//class Foo extends FooBar implements Bar{
//
//}

class Wrapper{
    int w = 10;
}

class TestClass111{
    static Wrapper changeWrapper(Wrapper w){
        w =  new Wrapper();
        w.w += 9;
        return w;
    }

    public static void main(String[] args) {
        Wrapper w = new Wrapper();
        w.w = 20;
        changeWrapper(w);
        w.w+=30;
        System.out.println(w.w); // 50
        w = changeWrapper(w);
        System.out.println(w.w); // 19
    }
}

class ChangeTest{
    private int myValue = 10;
    void showOne(int myValue){
        myValue = myValue;
    }

    void showTwo(int myValue){
        this.myValue = myValue;
    }

    public static void main(String[] args) {
        ChangeTest ct = new ChangeTest();
        ct.showTwo(200);
        System.out.println(ct.myValue); // 200
        ct.showOne(100);
        System.out.println(ct.myValue); // 200
    }
}

abstract class Bang11{
//    abstract void f();
    final void g(){}
    final void h(){}
    protected static int i;
    private int j;
}

class BigBang11 extends Bang11{
    void k(){
        i++;
    }
//    void l(){ j++; }
    int m;

    BigBang11(int n){
        m=n;
    }

    public static void main(String[] args) {
        Bang11 mc = new BigBang11(10);
    }

}

