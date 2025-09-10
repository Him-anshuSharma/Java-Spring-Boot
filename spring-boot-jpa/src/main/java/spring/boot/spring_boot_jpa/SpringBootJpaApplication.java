package spring.boot.spring_boot_jpa;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import spring.boot.spring_boot_jpa.entities.Task;
import spring.boot.spring_boot_jpa.entities.User;
import spring.boot.spring_boot_jpa.services.UserService;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);
		UserService userService = context.getBean(UserService.class);
		Task t1 = new Task("t1", "t1 desc", LocalDateTime.now().plusHours(1), Task.Priority.MEDIUM);
		Task t2 = new Task("t2", "21 desc", LocalDateTime.now().plusHours(1), Task.Priority.HIGH);
		User user = new User("Jethalal");
		user.addTask(t1);
		user.addTask(t2);
		userService.addUser(user);
		userService.getAllUsersWithTasks().stream().forEach(System.out::println);
	}

}
