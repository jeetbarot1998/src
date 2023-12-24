package Chap5_6;

public class Lect12_StringBuilder {
    StringBuilder b1;
    StringBuilder b2;
    public static void main(String[] args) {
        Lect12_StringBuilder l = new Lect12_StringBuilder();
        System.out.println("called m1");
        l.m1();
        System.out.println("called m2");
        l.m2();
        System.out.println("called m3");
        l.m3();
    }

    void m1(){
        reInitializeStringBuilder();
        System.out.println(b1);
        b1.append(b2.substring(2,5).toUpperCase());
        System.out.println(b1);
        System.out.println(b2);
    }

    void reInitializeStringBuilder(){
        this.b1 = new StringBuilder("snorkler");
        this.b2 = new StringBuilder("yoodler");
    }

    void m2(){
        reInitializeStringBuilder();
        b2.insert(3,b1.append('a'));
        System.out.println(b1);
        System.out.println(b2);
    }


    void m3(){
        reInitializeStringBuilder();
        b1.replace(3,4,b2.substring(4)).append(b2.append(false));
        System.out.println(b1);
        System.out.println(b2);
    }
}
