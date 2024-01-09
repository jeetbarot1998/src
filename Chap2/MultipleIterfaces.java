package Chap2;

public class MultipleIterfaces {
}



// =================== Implementing multiple interfaces having same method name ====================

interface I1{
    void m1();
}

interface I2{
    void m1();
}
class P1 implements I1,I2{
    public void m1(){
        System.out.println("P1");
    }

    public static void main(String[] args) {
        I1 i1 = new P1();
        I2 i2 = new P1();
        i1.m1();
        i2.m1();
    }

}


