package OCP.Concurrency_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class MyCallable3 implements Callable<Integer> {
    private int num;

    public MyCallable3(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i=0; i<=num; i++){
            sum = sum + i;
        }
        System.out.println("Completed task by " + Thread.currentThread().getName());
        return sum;
    }
}

class CallableExecutorExampleWithoutBlocking {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        MyCallable3[] callableArr = {
                new MyCallable3(10), new MyCallable3(20),
                new MyCallable3(30), new MyCallable3(40),
                new MyCallable3(50), new MyCallable3(60)
        };

        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (MyCallable3 mc : callableArr) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                try {
                    return exec.submit(mc).get(); // Blocking call, but executed asynchronously
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    return null;
                }
            });
            futures.add(future);
        }

        CompletableFuture<Void> allOfFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0]));

        allOfFutures.thenRun(() -> {
            System.out.println("All tasks completed asynchronously");
            for (CompletableFuture<Integer> future : futures) {
                try {
                    Integer result = future.get(); // Non-blocking call to get the result
                    System.out.println("Result from Future: " + result);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            exec.shutdown();
        });

        System.out.println("MAIN THREAD CONTINUES WITHOUT BLOCKING");
    }
}
