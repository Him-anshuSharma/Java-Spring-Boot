package spring.boot.spring_boot_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import spring.boot.spring_boot_jpa.services.UserService;

@SpringBootApplication
public class SpringBootJpaApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);
		UserService userService = context.getBean(UserService.class);

		// Demo: Paging
		System.out.println("===== First 10 Users =====");
		userService.getUsersWithPaging(0, 10).getContent()
				.forEach(u -> System.out.println(u.getName()));

		// Demo: Paging + Sorting (sort by 'name' or 'id')
		System.out.println("===== First 10 Users Sorted by Name =====");
		userService.getUsersWithPagingAndSorting(0, 10, "name").getContent()
				.forEach(u -> System.out.println(u.getName()));

		// Demo: Derived query
		System.out.println("===== Users named 'John' =====");
		userService.getUsersByName("John").forEach(u -> System.out.println(u.getName()));

		// Demo: Limiting
		System.out.println("===== First user =====");
		System.out.println(userService.getFirstUser().getName());

		System.out.println("===== Last user =====");
		System.out.println(userService.getLastUser().getName());

		System.out.println("===== Top 3 users by name =====");
		userService.getTop3UsersByName().forEach(u -> System.out.println(u.getName()));
	}
}