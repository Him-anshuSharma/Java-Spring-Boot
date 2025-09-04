package week3;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class Employee {
    String name;
    double salary;
    String dept;
    
    Employee(String name, double salary, String dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }
    
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDept() { return dept; }
    
    @Override
    public String toString() {
        return name + " (" + dept + ") - " + salary;
    }
}

public class w3d8 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 60000, "IT"),
            new Employee("Bob", 40000, "HR"),
            new Employee("Charlie", 70000, "Finance")
        );
        
        // TODO: filter salary > 50000
        List<Employee> employeeWithSalaryGreaterThan50K = employees.stream().filter(e->e.getSalary() > 50000).collect(Collectors.toList());
        Consumer<Employee> printName = (e)->System.out.println(e.getName());
        // TODO: print names
        for(Employee e : employeeWithSalaryGreaterThan50K){
            printName.accept(e);
        }
        // TODO: sort by salary descending
        Collections.sort(employeeWithSalaryGreaterThan50K,Comparator.comparing(Employee::getSalary).reversed());
        System.out.println(employeeWithSalaryGreaterThan50K);
    }
}

