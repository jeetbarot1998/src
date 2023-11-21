package Lect17_access_modifier2.p1;

public class SportCar {
    void goFast(){
        System.out.println("Called goFast 'Default' access");
    }

    protected void protectedMethod(){
        System.out.println("Called protectedMethod");
    }
}

class Convertible extends SportCar{

//  As we have inherited, it's the same as if the same method exists in the child class as well, like mentioned below.
//  void goFast(){
//  System.out.println("Called goFast");
//}
    public void test(){
        System.out.println("Called test");
    }

    public static void main(String[] args) {

//      Using Inheritance ["I"]
        Convertible c = new Convertible();
        c.goFast();
        c.test();
        c.protectedMethod();
//      Using reference variable ["R"]
        SportCar sc = new SportCar();
        sc.goFast();
        sc.protectedMethod();
    }
}

class Driver {
    public static void main(String[] args) {
//      Using reference variable ["R"]
        SportCar sc = new SportCar();
        sc.goFast();
    }
}
