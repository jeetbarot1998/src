package OCA_Dumps;

import OCA_Dumps.Q6.foo.A;

public class Q8 {
    public static void main(String[] args) {
        if(args[0].equals("open"))
            if(args[1].equals("Someone"))
                System.out.println("Hello");
        else System.out.println("Go Away " + args[1]);
    }
}

class B extends A {
    B(){}
    public void print(){
        System.out.println(this.x);
        System.out.println("B");
    }

    public static void main(String[] args) {
        B b = new B();
        b.print();
    }
}

class JustLooping{
    private int j;
    void showJ(){
        while (j<=5){
            for (int j = 1; j<=5;){
                System.out.println(j+" ");
                j++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        new JustLooping().showJ();

        boolean b1 = false;
        boolean b2 = false;
        System.out.println("Assignment operator has the least\n" +
                "priority. ");
//        if(b2 != b1 = !b2){
//            System.out.println("True");
//        }
//        else {
//            System.out.println("False");
//        }

        if(b2 = b1 = !b2){
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}


