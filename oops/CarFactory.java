package oops;

public class CarFactory {
    public static void main(String[] args) {
        Vehicle baleno = new Car("JK01AA0007", "Maruti", "Baleno", 800000, 180);
        System.out.println(baleno);
    }
}
