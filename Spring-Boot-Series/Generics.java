class Fuel {

}

class Petrol extends Fuel {
    @Override
    public String toString() {
        return "Petrol";
    }
}

class Diesel extends Fuel {
    @Override
    public String toString() {
        return "Diesel";
    }
}

// T -> idk what am i, but i will know once u mention it
// placeholder for different datatypes : petrol diesel

class FuelTank<T extends Fuel> {
    T fuelType;

    FuelTank(T fueltype) {
        this.fuelType = fueltype;
    }

    @Override
    public String toString() {
        return "Tank of type: " + fuelType;
    }

}

class Car<T extends Fuel> {
    T fuelType;

    FuelTank<T> tank;

    public void installTank(FuelTank<T> tank) {
        this.tank = tank;
    }

    Car(T fuelType) {
        this.fuelType = fuelType;
    }

}

public class Generics {
    public static void main(String[] args) {
        Car<Petrol> alto = new Car(new Petrol());
        FuelTank<Petrol> tank = new FuelTank(new Diesel());
        alto.installTank(tank);
    }
}