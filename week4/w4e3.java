package week4;
import java.util.concurrent.*;

public class w4e3 {
    static Callable<Integer> sumOfN(int n){
        return ()->{
            Thread.sleep(5000*n);
            return ((n)*(n+1))/2;
        };
    }   
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);
        for(int i = 1; i <= 3; i++){
            final int num = i;
            completionService.submit(sumOfN(num));
        }
        for(int i = 0; i < 3;i++){
            try {
                Future<Integer> result = completionService.take();
                System.out.println(result.get() );
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }
        executor.shutdown();
    }
     
}
