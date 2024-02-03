package OCA_Dumps;

public class Q10 {
}

class TQ101{
    static int s;
    public static void main(String[] args) {
        try{
            m();
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println(s);
    }

    static void m(){
        m0(1,2);
        m1(3);
    }

    static void m1(int i){ s+=1;}
    static void m0(int a,int b){
        s+=a;
        m2();
        m1(b);
    }
    static void m2(){
        throw new NullPointerException("aa");
    }
}


