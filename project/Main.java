package project;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter due date (yyyy-MM-dd HH:mm): ");
                    String due = sc.nextLine();
                    System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
                    Priority priority = Priority.valueOf(sc.nextLine().toUpperCase());

                    Task task = new Task(title, desc, due, priority);
                    manager.addTask(task);
                    System.out.println("✅ Task added successfully!");
                    break;

                case 2:
                    List<Task> tasks = manager.viewAllTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        tasks.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();
                    List<Task> results = manager.searchTask(keyword);
                    if (results.isEmpty()) {
                        System.out.println("No matching tasks found.");
                    } else {
                        results.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int id = sc.nextInt();
                    manager.deleteTask(id);
                    System.out.println("✅ Task deleted.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Task Manager. Bye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}