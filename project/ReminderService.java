package project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReminderService {
    private static ExecutorService reminderServiceRunner = Executors.newFixedThreadPool(1);
    private static long oneHour = 3600000;

    public static void schedule(Task task) {
        Runnable reminder = () -> {
            try {
                Thread.sleep(DateParser.toLong(task.getDueDateTime()) - System.currentTimeMillis() - oneHour);
                System.out.println("You have one pending task :\n\n" + task);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
        reminderServiceRunner.submit(reminder);
    }

}
