package OCP.Concurrency_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitForAllThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Task completed by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Submit tasks to the executor
        executor.submit(task);
        executor.submit(task);
        executor.submit(task);

        executor.shutdown(); // Shutdown the executor to stop accepting new tasks

        // Wait until all threads complete
        while (!executor.isTerminated()) {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        }

        System.out.println("All tasks completed successfully");
    }
}