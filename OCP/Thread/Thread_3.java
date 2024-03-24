package OCP.Thread;


class ThreadJoinExample {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask("Venue fixing"));
        Thread t2 = new Thread(new MyTask("Wedding card"));
        Thread t3 = new Thread(new MyTask("Card distribution"));
        // This is being run by main-thread
        // Start the threads
        t1.start();
        t2.start();
        // This is being run by main-thread
        // main thread waits for t1 to complete
        try {
            // Wait for t1 to finish
            t1.join();
            System.out.println("t1 (Venue fixing) is complete, t2 (Wedding card) can proceed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // main thread waits for t2 to complete
        try {
            // Wait for t2 to finish
            t2.join();
            System.out.println("t2 (Wedding card) is complete, t3 (Card distribution) can proceed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // main thread runs t3 once t1 and t2 are completed
        // Start t3 after t2 is complete
        t3.start();
    }
}

class MyTask implements Runnable {
    private String taskName;

    public MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Executing task: " + taskName);
        try {
            Thread.sleep(2000); // Simulating task execution time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskName + " completed.");
    }
}



class MythreadJoinExample2 extends Thread{
    public void run(){
        for(int i =0; i<5; i++){
            System.out.println("Child thread Working Hard");
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){}
        }
    }
}

class MyThreadJoinEx3{
    public static void main(String ...args) throws Exception{
        MythreadJoinExample2 mt = new MythreadJoinExample2();
        // Main thread is running here
        mt.start();
        // Main thread will only execute after mt thread will complete its execution
        // mt.join(); // Child thread will complete and then Main will followw.
        mt.join(2000); // Wait only 2 seconds for the child thread to complete.
        // If not completed, then continue.
        for(int i =0; i<5; i++){
            System.out.println("Main thread Working Hard");
        }
    }
}



class ChildThreaadJoinOnParent{
    public static void main(String ...args) throws Exception{
        // set the static variable to the main thread reference.
        MyThreadJoin3.mt = Thread.currentThread();
        MyThreadJoin3 t = new MyThreadJoin3();
        t.start();
        // DeadLock
        // t.join(); //  main thread waiting for the child thread to complete
        for(int i = 0 ; i<5; i++){
            System.out.println("Main thread ");
            Thread.sleep(1000);
        }
    }
}

class MyThreadJoin3 extends Thread{
    static Thread mt;
    public void run(){
        try{
            mt.join(); //  child thread waiting for the main thread to complete
            for(int i = 0 ; i<5; i++){
                System.out.println("Child thread ");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class ChildThreadJoinOnParentEx1{
    public static void main(String ...args) throws Exception{
        // set the static variable to the main thread reference.
        DeadLock.mt = Thread.currentThread();
        DeadLock t = new DeadLock();
        t.start();
        // DeadLock
        t.join(); //  main thread waiting for the child thread to complete
        for(int i = 0 ; i<10; i++){
            System.out.println("Main thread ");
            Thread.sleep(2000);
        }
    }
}

class DeadLock extends Thread{
    static Thread mt;
    public void run(){
        try{
            mt.join(); //  child thread waiting for the main thread to complete
        }
        catch(Exception e){
            for(int i = 0 ; i<10; i++){
                System.out.println("Child thread ");
            }
        }
    }
}

class Leader extends Thread{
    public static void main(String ...args) throws Exception{
        Thread t = new Thread(new Leader());
        t.start();
        System.out.println("m1 ");
        t.join();
        System.out.println("m2 ");
    }

    public void run(){
        System.out.println("r1 ");
        System.out.println("r2 ");
    }
}

class MainThreadJoiningItself{
    public static void main(String ...args) throws Exception{
        Thread.currentThread().join();
        System.out.println("I am waiting for main thread to complete ");
    }
}

