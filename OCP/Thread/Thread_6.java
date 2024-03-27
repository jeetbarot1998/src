package OCP.Thread;

public class Thread_6 {
    public static void main(String[] args) throws InterruptedException {
        String s1 = "ABC";
        String s2 = "CDE";
//        synchronized (s1){
//            s2.wait();
//        }
        synchronized (s1){
            s1.wait();
        }
    }
}

// ======= DEADLOCK

class Thread_6A{
    public synchronized void m1(Thread_6B b){
        System.out.println("Executing m1");
        try{
            Thread.sleep(6000);
        }
        catch (Exception e){}
        System.out.println("Calling last on B");
        b.last();
    }
    synchronized void last(){
        System.out.println("Inside A's last method");
    }
}

class Thread_6B{
    public synchronized void m2(Thread_6A a){
        System.out.println("Executing m2");
        try{
            Thread.sleep(600);
        }
        catch (Exception e){}
        System.out.println("Calling last on A");
        a.last();
    }
    synchronized void last(){
        System.out.println("Inside B's last method");
    }
}

class DeadlockThread_6 extends Thread{
    Thread_6A a = new Thread_6A();
    Thread_6B b = new Thread_6B();

    void m1(){
        this.start();
        a.m1(b);
    }
    @Override
    public void run() {
        b.m2(a);
    }

    public static void main(String[] args) {
        DeadlockThread_6 dl =  new DeadlockThread_6();
        dl.m1();
    }
}







