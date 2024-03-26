package OCP.Thread;
import java.util.Scanner;
public class Thread_5_Inter_Thread_Comms {
}

class Thread_50{
    public static void main(String[] args) throws InterruptedException {
        Thread_51 t = new Thread_51();
        t.start();
//        t.join();
//        Thread.sleep(500); // if we use over-loaded wait method it waits for specific amount of time
        synchronized (t){
            System.out.println("Main thread calling wait method");
            System.out.println("Lock is being released by main thread on object 'b'");
            t.wait(100);
            System.out.println(t.total);
        }
    }
}

class Thread_51 extends Thread{
    int total = 0;

    @Override
    public void run() {
        synchronized (this){
            System.out.println("Child thread starts calculation");
            for(int i = 0; i<5; i++){
                total +=i;
            }
            System.out.println("Child thread trying to give notification");
            System.out.println("Lock is being released by child thread on object 'b'");
            this.notify();
        }

//        More 1000 lines of code

    }
}

/** ============== OUTPUT: When main gets first chance ==============
 * Main thread calling wait method
 * Child thread starts calculation
 * Child thread trying to give notification
 * 10
 */

class ProcessorT5{
    void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer thread running");
            wait();
            System.out.println("resumed...");
        }
    }

    void consume() throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        Thread.sleep(1000);
        synchronized (this){
            System.out.println("Waiting for return key");
            sc.nextLine();
            System.out.println("return key pressed.");
            notify();
            Thread.sleep(2000);
            System.out.println("Consume method");
        }
        System.out.println("Outside the sync");
    }
}

class AppT5{
    public static void main(String[] args) throws InterruptedException {
        ProcessorT5 p =  new ProcessorT5();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    p.produce();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    p.consume();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}

// wait(int milli) waits a minimum of milli time before continuing to
// work on the task again. It will be added to the thread pool again
// and if the thread scheduler gives a chance and the lock is free
// it will execute.
