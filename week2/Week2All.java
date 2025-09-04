package week2;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() { return name; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return name + " - " + grade;
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " - " + salary;
    }
}

class Product {
    private String name;
    private String category;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getCategory() { return category; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }
}

public class Week2All {
    public static void main(String[] args) {
        // ================= 1. Student Grades =================
        System.out.println("\n=== Student Grades ===");
        List<Student> students = Arrays.asList(
            new Student("Alice", 80),
            new Student("Bob", 65),
            new Student("Charlie", 90),
            new Student("David", 72)
        );

        List<Student> above75 = students.stream()
                                        .filter(s -> s.getGrade() > 75)
                                        .toList();
        System.out.println("Above 75: " + above75);

        List<Student> sorted = students.stream()
                                       .sorted(Comparator.comparing(Student::getGrade).reversed())
                                       .toList();
        System.out.println("Sorted: " + sorted);

        students.forEach(s -> System.out.println(s.getName() + " -> " + s.getGrade()));


        // ================= 2. Employee Filter =================
        System.out.println("\n=== Employee Filter ===");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 60000),
            new Employee("Bob", 45000),
            new Employee("Charlie", 70000)
        );

        List<String> highEarners = employees.stream()
                                            .filter(e -> e.getSalary() > 50000)
                                            .map(Employee::getName)
                                            .toList();
        System.out.println("High earners: " + highEarners);


        // ================= 3. Grouping Example =================
        System.out.println("\n=== Grouping Example ===");
        List<Product> products = Arrays.asList(
            new Product("iPhone", "Electronics"),
            new Product("Laptop", "Electronics"),
            new Product("Shirt", "Clothing"),
            new Product("Pants", "Clothing")
        );

        Map<String, List<Product>> grouped = products.stream()
                                                     .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Grouped: " + grouped);

        Map<String, Long> counts = products.stream()
                                           .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println("Counts: " + counts);


        // ================= 4. Flatten Example =================
        System.out.println("\n=== Flatten Example ===");
        List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8)
        );

        List<Integer> flat = nested.stream()
                                   .flatMap(list -> list.stream())
                                   .distinct()
                                   .sorted()
                                   .collect(Collectors.toList());
        System.out.println("Flattened: " + flat);


        // ================= 5. Statistics Example =================
        System.out.println("\n=== Statistics Example ===");
        List<Double> temps = Arrays.asList(32.5, 28.4, 40.2, 36.7);

        Optional<Double> max = temps.stream().max(Double::compareTo);
        Optional<Double> min = temps.stream().min(Double::compareTo);
        double avg = temps.stream().collect(Collectors.averagingDouble(t -> t));

        System.out.println("Max: " + max.orElse(-1.0));
        System.out.println("Min: " + min.orElse(-1.0));
        System.out.println("Avg: " + avg);
    }
}
