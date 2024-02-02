package OCA_Dumps;

import java.io.IOException;

public class Q2 {
}
interface DebitCard {
    abstract void withdraw();
    public void deposit();
}

class HSBCDebitCard implements DebitCard {

    @Override
    public void withdraw() {
        System.out.println("HSBCDebitCard Withdraw Money");
    }

    @Override
    public void deposit() {
        System.out.println("HSBCDebitCard deposit Money");
    }
}

// Programming to interface ensures loose coupling b/w end
// client and implementation client


class tc21{
    public static void main(String[] args) {
        DebitCard dc = new HSBCDebitCard();
        dc.deposit();
        dc.withdraw();

    }
}

class Base{
    void m1() throws IOException, NullPointerException{
        someMethod("argument");
        System.out.println("Hello");
    }

    int someMethod(String s){
        if (s==null) throw new NullPointerException();
        else return s.length();
    }
}


class Newbase extends Base{
    void m1(){
        someMethod("argument");
        System.out.println("Hi");
    }

    public static void main(String[] args) {
        Base b = new Newbase();
        try{
            System.out.println("Even if at runtime, the child object \n" +
                    "is called still, the method signature mentions , \n" +
                    "a checked exception, hence we need to handle that.");
            b.m1();
        }
        catch (IOException e){
            System.out.println("Exception caught");
        }
        Newbase b1 = new Newbase();
        b1.m1();
        System.out.println("============== ");
        Base b2 = new Newbase();
        ((Newbase) b2).m1(); // Hi

        System.out.println("============== ");
//        (Newbase)b2.m1(); // CE as this triggers the m1 of Base which
//        Throws a checked exception

    }
}
class MyException extends Exception{}
class Noobs{
    Noobs(){
        try{
            throw new MyException();
        }
        catch (Exception e){
            System.out.println("Here");
        }
    }
    public static void main(String[] args) {
        Noobs n = new Noobs();
        Noobs n1 = new Noobs();
        Noobs n2 = n;
        System.out.println("4 Objects are created and 3 references.");

    }
}

class tc22{
    public static void main(String[] args) {
        double d = Double.parseDouble("-0.8");
//        int i = Integer.parseInt("0.2"); => Error; NumberFormatException
        int x = (int)d;
        switch (x){
            case 1:
                System.out.println("Hello");
            case 2:
                System.out.println("World"); break;
            default:
                System.out.println("Bye");

        String a  ="abcdef";
        System.out.println(a.length());
        System.out.println(a.substring(1,a.length()));
//        System.out.println(a.charAt(a.length()));
        }
    }
}








