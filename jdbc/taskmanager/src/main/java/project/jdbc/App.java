package project.jdbc;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

import project.jdbc.database.DBConnection;
import project.jdbc.database.dao.TaskDao;
import project.jdbc.database.models.Task;
import project.jdbc.database.models.Task.Priority;
import project.jdbc.database.models.Task.Status;

public class App {
    public static void main(String[] args) {
        // 1️⃣ Connect to the database
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            System.out.println("Database connection successful!");
        } else {
            System.out.println("Database connection failed!");
            return;
        }

        // 2️⃣ Create DAO
        TaskDao taskDao = new TaskDao();

        // 3️⃣ CREATE - Add new tasks
        Task task1 = new Task("Finish project", "Complete DAO module",
                LocalDateTime.now().plusDays(2), Priority.HIGH);
        Task task2 = new Task("Read book", "Read Java book",
                LocalDateTime.now().plusDays(5), Priority.MEDIUM);

        taskDao.insertTask(task1);
        taskDao.insertTask(task2);
        System.out.println("Tasks inserted!");

        // 4️⃣ READ - Get all tasks
        List<Task> tasks = taskDao.getAllTasks();
        System.out.println("\nAll Tasks:");
        tasks.forEach(System.out::println);

        // 5️⃣ UPDATE - Update the first task's status
        if (!tasks.isEmpty()) {
            Task firstTask = tasks.get(0);
            firstTask.setStatus(Status.IN_PROGRESS);
            boolean updated = taskDao.updateTask(firstTask);
            System.out.println("\nUpdate task: " + (updated ? "Success" : "Failed"));
        }

        // 6️⃣ DELETE - Delete the second task
        if (tasks.size() > 1) {
            Task secondTask = tasks.get(1);
            boolean deleted = taskDao.deleteTask(secondTask.getId());
            System.out.println("Delete task: " + (deleted ? "Success" : "Failed"));
        }

        // 7️⃣ READ AGAIN - Show final tasks after update & delete
        List<Task> finalTasks = taskDao.getAllTasks();
        System.out.println("\nTasks after Update & Delete:");
        finalTasks.forEach(System.out::println);

        // 8️⃣ Disconnect
        DBConnection.disconnect();
    }
}