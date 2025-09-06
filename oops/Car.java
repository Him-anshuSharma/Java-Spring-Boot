package oops;

public class Car extends Vehicle {

    private int topSpeed;
    private int price;
    private String model;

    public Car(String vehicleNumber, String brand, String model, int price, int topSpeed) {
        super(vehicleNumber, brand);
        this.model = model;
        this.price = price;
        this.topSpeed = topSpeed;
    }

    @Override
    public String toString() {
        return "This is " + model + " from " + brand + " with registration number as " + vehicleNumber
                + " and has top speed of " + topSpeed + " with price " + price;
    }

}
