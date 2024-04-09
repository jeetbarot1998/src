package OCP.Concurrency_2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Concurrency_2_6 {
}

class MultiThreadedFutureExample {
    public static void main(String[] args) {
        int numberOfTasks = 5;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < numberOfTasks; i++) {
            int taskId = i + 1;
            Callable<Integer> task = () -> {
                // Simulate some time-consuming task
                TimeUnit.SECONDS.sleep(3);
                return taskId * 10; // Return a result
            };
            tasks.add(task);
        }

        try {
            List<Future<Integer>> futures = executor.invokeAll(tasks);

            for (Future<Integer> future : futures) {
                Integer result = future.get(); // Blocking call to get the result
                System.out.println("Result: " + result);
            }

            System.out.printf("Main thread");

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}


class ExecutorLifeCycleMethods{
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" Main Thread started.");
        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.shutdown();
        // This will give a runtime Exception
        exec.submit(new LoopClass());
        System.out.println(" If you try to submit a job after you have\n" +
                " shutdown the executor then it will\n" +
                " throw RejectedExecutionException");

        System.out.println("Main thread ends here");
    }
}

class LoopClass implements Runnable{
    private int id;
    private static int count = 0;

    public LoopClass() {
        this.id = ++count;
    }

    @Override
    public void run() {
        System.out.println("### Task " + id + " Starting ###");
        for (int i = 10 ;i > 0; i--){
            System.out.println("### Task " + id + " TIC-TIC " + i +" ###");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("### Task " + id + " Done ###");
    }
}


class CachedExecutorLifeCycleMethodsDemo{
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" Main Thread started.");
        System.out.println("Technically newCachedThreadPool will \n" +
                "check if thread is available\n" +
                "If not then it will make a new thread pool for the same");
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.shutdown();
        // This will give a runtime Exception
//        exec.submit(new LoopClass());
        System.out.println(" If you try to submit a job after you have\n" +
                " shutdown the executor then it will\n" +
                " throw RejectedExecutionException");

        System.out.println("Main thread ends here");
    }
}

class SingleExecutorLifeCycleMethodsDemo{
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" Main Thread started.");
        System.out.println("Only one thread will be executed at a time \n" +
                "");
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.submit(new LoopClass());
        exec.shutdown();
        // This will give a runtime Exception
//        exec.submit(new LoopClass());
        System.out.println(" If you try to submit a job after you have\n" +
                " shutdown the executor then it will\n" +
                " throw RejectedExecutionException");

        System.out.println("Main thread ends here");
    }
}


class ExecutorServiceJoinExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit tasks to the executor
        executorService.submit(() -> {
            try {
                Thread.sleep(2000); // Simulating some task
                System.out.println("Task 1 completed");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task 1 interrupted");
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(1000); // Simulating some task
                System.out.println("Task 2 completed");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task 2 interrupted");
            }
        });

        // Shutdown the executor after all tasks are submitted
//        executorService.shutdown();

        // Wait for the tasks to complete or a timeout of 5 seconds
        if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Some tasks took too long to complete");
            // Optionally, you can force shutdown if tasks are taking too long
            executorService.shutdownNow();
        }

        System.out.println("All tasks completed");
    }
}

class TaskDivisionDemo{
    public static void main(String[] args) {
        System.out.println("Ideal pool size depends on 3 major factors\n" +
                "1. type of task\n" +
                "2. CPU Intensive task (Like algorithm to generate a hash or image processing) \n" +
                "3. IO intensive task");
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("No of cores = " + coreCount);
        ExecutorService exec = Executors.newFixedThreadPool(coreCount);
        for(int i = 0; i<50; i++){
            exec.execute(new TaskDivisionDemo.Task());
        }
        System.out.println("Thread.currentThread().getName(): "+ Thread.currentThread().getName());
        exec.shutdown();
    }
    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Completed task by " + Thread.currentThread().getName());
        }
    }
}


class MyCallable implements Callable, Runnable{
    int num;

    public MyCallable(int num) {
        this.num = num;
    }

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i=0; i<=num; i++){

            Thread.sleep(5000/(num*10));
            sum = sum + i;
        }
        System.out.println("Completed task by " + Thread.currentThread().getName());
        return sum;
    }

    @Override
    public void run() {
        System.out.println(" Runnable task by " + Thread.currentThread().getName());
    }
}

class CallableExecutorExample{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        MyCallable[] callable_arr = {
                new MyCallable(10), new MyCallable(20),
                new MyCallable(30), new MyCallable(40),
                new MyCallable(50),new MyCallable(60) };
        for (MyCallable mc : callable_arr){
            Future f = exec.submit((Callable<Object>) mc);
            System.out.println("THIS IS BLOCKING IN NATURE from " + mc.num);
//            Future f1 = exec.submit((Runnable)  mc);
            System.out.println(f.get());
        }
        System.out.println("MAIN THREAD COMPLETES");
        exec.shutdown();
    }
}


class FutureWaitAndJoinExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit a task to the executor and get a Future object
        Future<Integer> future = executorService.submit(() -> {
            Thread.sleep(2000); // Simulating some long-running task
            return 42;
        });

        try {
            // Wait for the future to complete with a timeout
            Integer result = future.get(3, TimeUnit.SECONDS);
            System.out.println("Task result: " + result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("Task did not complete within the specified timeout.");
            // Optionally, you can cancel the task if it takes too long
            future.cancel(true);
        }

        executorService.shutdown();
    }
}





