package Chap2;

class Test3 {

    void display(){
        System.out.println("Display");
//        A.main();
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        t.display();
    }
}


class A{

    public static void main(String[] args) {
        System.out.println("inside A");
    }
}