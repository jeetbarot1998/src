package OCP.Thread;

public class Thread_4 {
}

class Display{
    synchronized void wish(String name){
        for(int i=0; i<5;i++){
            System.out.println("Good morning " + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class MyThread41 extends Thread{
    Display d;
    String name;
    MyThread41(Display d, String name){
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}

class SyncDemo{
    public static void main(String[] args) throws InterruptedException {
        Display d = new Display();
        Display d1 = new Display();
        MyThread41 t1 = new MyThread41(d1, "ABC");
        MyThread41 t2 = new MyThread41(d1, "DEF");
        MyThread41 t3 = new MyThread41(d1, "HIJ");
        t1.start();
//        t1.join();
        t2.start();
        t3.start();
    }
}

class XT41{
    synchronized static void m1(){}
    synchronized static void m2(){}
    static void m3(){}
    void m4(){}
}

// ============================
class DisplayT4{
    synchronized void displayN() throws Exception{
        for (int i = 0; i<5;i++){
            System.out.println(i);
            Thread.sleep(500);
        }
    }
    synchronized void displayC() throws Exception{
        for (int i = 65; i<70;i++){
            System.out.println((char)i);
            Thread.sleep(500);
        }
    }
}

class MyThreadN extends Thread{
    DisplayT4 d;
    MyThreadN(DisplayT4 d){
        this.d = d;
    }
    public void run(){
        try {
            d.displayN();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
class MyThreadC extends Thread{
    DisplayT4 d;
    MyThreadC(DisplayT4 d){
        this.d = d;
    }
    public void run(){
        try {
            d.displayC();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class SyncDemoT4{
    public static void main(String[] args) {
        DisplayT4 d = new DisplayT4();
        MyThreadC mc = new MyThreadC(d);
        MyThreadN mt = new MyThreadN(d);
        mc.start();
        mt.start();
    }
}
