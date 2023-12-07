package Chap5_6;

public class Lect3 {
}

class Test30{
    public static void main(String[] args) throws Throwable {
        Test30 t = new Test30();
        throw new MyException3();
    }
}

class MyException3 extends Exception{}


// will not work as we are throwing child of throwable as per hierarchy in the caller method
//class Test31{
//    public static void main(String[] args) throws Exception {
//        Test30 t = new Test30();
//        throw new MyException31();
//    }
//}
//class MyException31 extends Throwable{}

class Test32{
    public static void main(String[] args) {
        Test32 t = new Test32();

        try {
            t.m1();
        }
        catch (Throwable e){ // generic capturing all the exceptions.
            System.out.println("Exception of age");
        }
    }

    void m1(){
        throw new MyException4();
    }
}

class MyException4 extends RuntimeException{}

interface Managerial{}
class Person implements Managerial{
    public static void main(String[] args) {
        Person p = new Person();
        if (p instanceof Managerial){
            System.out.println("Access Granted");
        }
        else {
            throw new AuthorizationError();
        }

        String a = null;
        System.out.println(a.length());
    }

    static { int x =7/0; }
}

class AuthorizationError extends RuntimeException{}


class ThreadExample{
    public static void main(String[] args) {
        Thread th =  new Thread();
        th.setPriority(20);
    }
}

class NumberParseError{
    public static void main(String[] args) {
        try{
            Integer.parseInt("abc");
        }
        catch (NumberFormatException tho){
            System.out.println("Runtime exception");
        }
    }
}

class IllegalStateExcept{
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
//      You cannot start the thread twice.
        t.start();
    }
}

class Plane {
    static String s = "-";

    public static void main(String[] args) {
        new Plane().s1();
        System.out.println(s);
    }

    void s1() {
        try {
            s2();
        } catch (Exception e) {
            s += "c";
        }
    }


    void s2() throws Exception {
        s3();
        s += "2";
        s3();
        s += "2b";
    }


    void s3() throws Exception {
        throw new Exception();
    }
}


class Boeing extends Plane{
    void s3() throws RuntimeException{

    }
}


/*
{
    fname: string,
    sname: string,
    id: number,
    phone: number,
    address: string,
    pin_code: number,
    card_details: string,
}
https://api.endpoint/get_name =>
https://api.endpoint/get_add =>
https://api.endpoint/get_add_name =>
https://api.endpoint/get_add_pincode =>
https://api.endpoint/get_add_phone =>
https://api.endpoint/all => fn,sn,id,pn,ad,pnc,cd






 */


