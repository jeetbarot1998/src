package Chap2;

class Test3 {

    void display(){
        System.out.println("Display");
//        A.main();
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        t.display();
        String s;
        long l = 0b10L;
        System.out.println(l);
//        System.out.println(s);
    }
}


//Watch for methods that declare an abstract class or interface return type,
//and know that any object that passes the IS-A test (in other words, would test true using
//the instanceof operator) can be returned from that method.

abstract class Animal2 { }
class Bear extends Animal2 { }
class Test5 {
    public Animal2 go() {
        return new Bear(); // OK, Bear "is-a" Animal
    }
}


class T{
    public static void main(String[] args) {
        int x = 073; // octal.
        System.out.println(x);
    }
}



