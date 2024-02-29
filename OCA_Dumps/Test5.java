package OCA_Dumps;

public class Test5 {
}



class TestClass51 implements T1, T2{
    public void m1(){}

    public static void main(String[] args) {
        TestClass51 t =  new TestClass51();
    }
}
interface T1{
    int VALUE = 1;
    void m1();
}
interface T2{
    int VALUE = 2;
    void m1();
}



//class XXX{
//    public void m() {
//        throw new RuntimeException();
//    }
//}
//class YYY extends XXX{
//    public void m() throws Exception{
//        throw new Exception();
//    }
//}


class CorbaComponent{
    String ior;
    CorbaComponent(){ startUp("IOR"); }
    void startUp(String s){ ior  =  s; }
    void print(){ System.out.println(ior); }
}

class OrderManager extends CorbaComponent{
    OrderManager(){  }
    void startUp(String s){  ior = getIORFromURL(s);   }
    String getIORFromURL(String s){  return "URL://"+s; }
}

class Application {
    public static void main(String args[]) {
        start(new OrderManager());
    }

    static void start(CorbaComponent cc) {
        cc.print();
    }
}

class TestClass52 {

    public static int m1(int i){
        return ++i;
    }

    public static void main(String[] args) {

        int k = m1(args.length);
        k += 3 + ++k;
        System.out.println(k);
    }

}


class Noobs5 {
    public void m(int a){
        System.out.println("In int ");
    }
    public void m(char c){
        System.out.println("In char ");
    }

    public static void main(String[] args) {
        Noobs5 n = new Noobs5();
        int a = 'a';
        char c = 6;
        n.m(a);
        n.m(c);
    }
}





class Test52{
    public static void main(String args[]){
        int c = 0;
        A: for(int i = 0; i < 2; i++){
            B: for(int j = 0; j < 2; j++){
                C: for(int k = 0; k < 3; k++){
                    c++;
                    if(k>j) break;
                }
            }
        }
        System.out.println(c);
    }
}


class Super { static String ID = "QBANK"; }

class Sub extends Super{
    static { System.out.print("In Sub"); }
}
class Test53{
    public static void main(String[] args){
        System.out.println(Sub.ID);
        String s ="ABC";
//        System.out.println(s*5);
    }
}


class LoopTest {
    int k = 5;
    public boolean checkIt(int k){
        return this.k-->0?true:false;
    }
    public void printThem(){
        while(checkIt(k)){
            System.out.print(k);
        }
    }
    public static void main(String[] args) {
        new LoopTest().printThem();
    }
}




class Test54{
        static char i;
        static int c;
    public static void main(String[] args) {
//        char c = 0;
//        int i = 0;
//        c = i;
//        System.out.println(i==c);

        System.out.println(i==c);
        LOOP: for (i=0;i<5;i++){
            switch(i++){
                case '0': System.out.println("A");
                case 1: System.out.println("B"); break LOOP;
                case 2: System.out.println("C"); break;
                case 3: System.out.println("D"); break;
                case 4: System.out.println("E");
                case 'E' : System.out.println("F");
            }
        }
    }
}