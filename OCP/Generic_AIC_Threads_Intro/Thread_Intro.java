package OCP.Generic_AIC_Threads_Intro;

public class Thread_Intro {
    
}

class MyThreadIntro1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println("Child Thread : " + i);
        }
    }
}

class ThreadExtendApproachIntro1{
    public static void main(String[] args) {
        System.out.println("USING Start");
        MyThreadIntro1 mt = new MyThreadIntro1();
        mt.start();
        for (int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
        }
    }
}


class ThreadExtendApproachIntro2{
    public static void main(String[] args) {
        System.out.println("USING Run");
        MyThreadIntro1 mt = new MyThreadIntro1();
        mt.run();
        for (int i = 0; i<10; i++){
            System.out.println("Main Thread : " + i);
        }
    }
}