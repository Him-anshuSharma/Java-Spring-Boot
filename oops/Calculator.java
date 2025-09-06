package oops;

class Addition {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Addition addition = new Addition();
        System.out.println(addition.add(10, 10) + "\n" + addition.add(10.2, 11.2));
    }

    @Override
    public String toString() {
        return "Hello from calculator";
    }

}
