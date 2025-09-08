package project.hibernate;

import project.hibernate.jpa.entities.Task;
import project.hibernate.jpa.entities.Task.Priority;
import project.hibernate.jpa.entities.Task.Status;
import project.hibernate.jpa.helpers.EmfProvider;
import project.hibernate.jpa.entities.User;
import project.hibernate.service.UserService;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserService();

        try {
            // 1️⃣ Create user
            User user = new User("Himanshu");

            // 2️⃣ Create tasks
            Task task1 = new Task("Finish project", "Complete DAO module",
                    LocalDateTime.now().plusDays(2), Priority.HIGH);
            Task task2 = new Task("Read book", "Read Java Hibernate book",
                    LocalDateTime.now().plusDays(5), Priority.MEDIUM);

            // 3️⃣ Assign tasks to user
            user.addTask(task1);
            user.addTask(task2);

            // 4️⃣ Persist user (tasks will be saved automatically via cascade)
            userService.addUser(user);
            System.out.println("✅ User and tasks inserted!\n");

            // 5️⃣ Fetch user back
            User fetched = userService.getUser(user.getId());
            System.out.println("📌 User: " + fetched);
            System.out.println("📌 Tasks for user:");
            for (Task t : fetched.getTasks()) {
                System.out.println(t);
            }

            // 6️⃣ Update one task
            Task t1 = fetched.getTasks().get(0);
            t1.setStatus(Status.IN_PROGRESS);
            userService.updateUser(fetched); // cascade will update tasks too
            System.out.println("\n✅ Task updated via user update!\n");

            // 7️⃣ Delete user → tasks also deleted (orphanRemoval = true)
            userService.deleteUser(user.getId());
            System.out.println("\n✅ User and all tasks deleted!\n");

        } finally {
            EmfProvider.close();
        }
    }
}