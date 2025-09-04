package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class ClickTracker{
    private int count;
    ReentrantLock lock;

    public ClickTracker() {
        count = 0;
        lock = new ReentrantLock();
        // lock.unlock();
    }

    public void click(int id){
        lock.lock();
        try{
            System.out.println("Clicked from -> " + id);
            count++;
        }
        finally{
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

}

public class w4e5 {
    public static void main(String[] args) {
        ClickTracker myTracker = new ClickTracker();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            final int clickId = i;
            threads.add(new Thread(
                ()->{
                    myTracker.click(clickId);
                }
            ));
        }
        for(Thread thread : threads){
            thread.start();
        }
        for(Thread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Total Clicks: " + myTracker.getCount());
    }
}
