public class singletonClses {}
class singletonClsLazy {
    private int id = 10;
    private singletonClsLazy(){
        System.out.println("called constructor");
    }
    private static singletonClsLazy Instance;

    public static singletonClsLazy getInstance(){
        if(Instance == null){
            Instance = new singletonClsLazy();
        }
        return Instance;
    }
}

class singletonClsNonLazy {
    private int id = 10;
    private singletonClsNonLazy(){
        System.out.println("called constructor");
    }

    private static singletonClsNonLazy Instance =  new singletonClsNonLazy();
    public static singletonClsNonLazy getInstance2(){
        return Instance;
    }
}




class Demo{
    public static void main(String[] args) {
        singletonClsLazy s = singletonClsLazy.getInstance();
        singletonClsLazy s2 = singletonClsLazy.getInstance();
//        singletonCls s3 = new singletonCls();
                System.out.println(s==s2);
    }
    public static void main(String args) {

    }
}

interface IO1{
    double pi = 3.14;
    int add(int a, int b);
    default int sub(int a, int b){
        return a-b;
    }
}

class ImplementerIO1 implements IO1{

    @Override
    public int add(int a, int b) {
        System.out.println(pi);
        return a+b;
    }

    public static void main(String[] args) {
        ImplementerIO1 i = new ImplementerIO1();
        System.out.println(i.add(5,6));
        System.out.println(i.sub(7,2));
    }
}



class Parent1 {
    int i = 10;

    void m1(){
        System.out.println(i);
    }
    static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}

class Child1 extends Parent1 {
    static void staticMethod() {
        System.out.println("Static method in Child");
    }
}

class Child2 extends Parent1 {
}

class Main {
    
    public static void main(String[] args) {
        Parent1.staticMethod(); // Prints "Static method in Parent"
        Child1.staticMethod(); // Prints "Static method in Child"
        Child2.staticMethod(); // Prints "Static method in Parent"
        Child1 c = new Child1();
        c.m1();
    }
}


class chap2{

    void instance(){
        System.out.println("instance");
    }

    static void st(){
        System.out.println("static");
//        instance();
    }

    public static void main(String[] args) {
//        long [2][2] x;
        st();
    }
}

class Object{

}