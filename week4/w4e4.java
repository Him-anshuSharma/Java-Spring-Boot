package week4;

import java.util.concurrent.CompletableFuture;

public class w4e4 {
    public static void main(String[] args) {
        CompletableFuture<String> getKey1 = CompletableFuture.supplyAsync(()->{
            String key;

            System.out.println("Getting key1 ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            key = "amiH";
            return key;
        }).thenApply(s-> new StringBuffer(s).reverse().toString());
        CompletableFuture<String> getKey2 = CompletableFuture.supplyAsync(()->{
            String key;
            System.out.println("Getting key2 ...");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            key = "uhsn";
            return key;
        }).thenApply(s->new StringBuilder(s).reverse().toString());
        CompletableFuture<String> fullkey = getKey1.thenCombine(getKey2, (a,b) -> a+b);
        System.out.println(fullkey.join());
    }
}
