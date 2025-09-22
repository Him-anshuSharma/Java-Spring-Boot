import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

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

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

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

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Streams {
    public static void main(String[] args) {

        // ================= 1. Students =================
        List<Student> students = Arrays.asList(
                new Student("Bob", 65),
                new Student("Charlie", 90),
                new Student("Alice", 80),
                new Student("David", 72));

        // Q1: Students with grade < 70
        List<Student> below70 = students.stream().filter(s -> s.getGrade() < 70).toList();
        System.out.println(below70);

        // Q2: Sort students by name alphabetically
        List<Student> sortedByName = students.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .toList();
        System.out.println(sortedByName);

        // Q3: Names of students above 75
        List<String> namesAbove75 = students.stream().filter(student -> student.getGrade() > 75)
                .map(student -> student.getName()).toList();
        System.out.println(namesAbove75);

        // Q5: Names of students above 75 in descending order
        List<String> namesAbove75Desc = students.stream().filter(student -> student.getGrade() > 75)
                .map(student -> student.getName()).sorted((s1, s2) -> s2.compareTo(s1)).toList();
        System.out.println(namesAbove75Desc); // TODO: fill stream

        // ================= 2. Employees =================
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 60000),
                new Employee("Bob", 45000),
                new Employee("Charlie", 70000));

        // Q6: Employees with salary between 50,000 and 70,000
        List<Employee> midEarners = employees.stream().filter(emp -> emp.getSalary() > 50000 && emp.getSalary() < 70000)
                .toList(); // TODO
        System.out.println(midEarners);

        // Q7: Sum of all salaries
        double totalSalary = employees.stream().collect(Collectors.summingDouble(Employee::getSalary)); // TODO
        System.out.println(totalSalary);

        // Q9: Average salary
        double avgSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary)); // TODO
        System.out.println(avgSalary);

        // ================= 3. Products =================
        List<Product> products = Arrays.asList(
                new Product("iPhone", "Electronics"),
                new Product("Laptop", "Electronics"),
                new Product("Shirt", "Clothing"),
                new Product("Pants", "Clothing"));

        // Q11: Group products by category
        Map<String, List<Product>> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory)); // TODO
        System.out.println(groupedProducts);

        // Q12: Count products in each category
        Map<String, Long> productCounts = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        ; // TODO
        System.out.println(productCounts);

        // ================= 4. Flatten =================
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8));

        // Q16: Flatten nested list
        List<Integer> flatList = nested.stream().flatMap(arr -> arr.stream()).toList(); // TODO
        System.out.println(flatList);

        // Q18: Filter even numbers after flattening
        List<Integer> evenNumbers = nested.stream().flatMap(arr -> arr.stream()).filter(n -> n % 2 == 0).toList(); // TODO
        System.out.println(evenNumbers);

        // ================= 5. Statistics =================
        List<Double> temps = Arrays.asList(32.5, 28.4, 40.2, 36.7);

        // Q21: Sum of temperatures
        double sumTemps = temps.stream().collect(Collectors.summingDouble(n -> n)); // TODO
        System.out.println(sumTemps);

        // Q22: Count temperatures above 35
        long countAbove35 = temps.stream().filter(n -> n > 35).collect(Collectors.counting());// TODO
        System.out.println(countAbove35);

        // Q23: Average temperature
        double avgTemp = temps.stream().collect(Collectors.averagingDouble(n -> n)); // TODO
        System.out.println(avgTemp);

        // ================= Bonus / Conceptual =================
        // Q30: Flatten multiple classes’ student grades and return distinct grades
        // ascending

        // Class A students
        List<Student> classA = Arrays.asList(
                new Student("Alice", 80),
                new Student("Bob", 65),
                new Student("Frank", 65),
                new Student("Charlie", 90));

        // Class B students
        List<Student> classB = Arrays.asList(
                new Student("David", 72),
                new Student("Eve", 90),
                new Student("Frank", 65),
                new Student("Charlie", 90));

        List<String> distinctNames = Stream.of(classA, classB).flatMap(
                List::stream).map(s -> s.getName()).distinct().toList();
        System.out.println(distinctNames);
    }
}