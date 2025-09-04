package week4;

import static java.lang.Thread.sleep;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class w4e2 {
    public static void main(String[] args) {
        // ========== Exercise 1 ==========
        // TODO: Create a FixedThreadPool of size 2
        // Submit 5 tasks
        // Each task should print numbers from 1–5 with a small delay
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 5;i++){
            final int taskid = i;
            executor.execute(() -> {
                    System.out.println("Executing " + taskid + " with thread - " + Thread.currentThread().getName() );
                    try {
                        sleep(1000*taskid);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
    
            });
        }
        

        // ========== Exercise 2 ==========
        // TODO: Create a CachedThreadPool
        // Submit 10 tasks
        // Each task should sleep for 2 seconds and then print the thread name
        executor.close();
        System.out.println("After closing active threads -> " + Thread.activeCount());
        executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            final int id = i;
            executor.execute(
                ()->{
                    System.out.println("For i -> " + id + ", thread id -> [" + Thread.currentThread().getName() + "]\ntotal threads - " + Thread.activeCount());
                    System.out.println();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                
            );
        }
        executor.close();
        

        // ========== Exercise 3 ==========
        // TODO: Create a SingleThreadExecutor
        // Submit 3 tasks
        // Each task should print its task number

        System.out.println("After closing active threads -> " + Thread.activeCount());
        executor = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 3; i++){
            final int id = i;
            executor.execute(
                ()->{
                    System.out.println("For i -> " + id + ", thread id -> [" + Thread.currentThread().getName() + "]\ntotal threads - " + Thread.activeCount());
                    System.out.println();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                
            );
        }
        executor.close();

        // NOTE: Remember to shutdown executors after use
    }
}
