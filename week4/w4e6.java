package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class w4e6 {
    public static void main(String[] args) {
        List<String> files = Arrays.asList("file1", "file2", "file3", "file4");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        List<Callable<String>> tasks = new ArrayList<>();
        for(String file : files){
            tasks.add(() -> {
                // simulate download
                Thread.sleep(new Random().nextInt(3000));
                return file + " downloaded";
            });
        }

        for(Callable<String> task : tasks){
            completionService.submit(task);
        }

        int downloaded = 0;
        while(downloaded != tasks.size()){
            try {
                Future<String> file = completionService.take();
                if(file.isDone()){
                    System.out.println(file.get());
                    downloaded++;
                }
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }
        executor.shutdown();
    }
}
