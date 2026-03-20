import java.util.*;

public class Exercise {
    public static void main(String[] args) {

        System.out.println("Oops practice: Vehicle Rental System");
        Vehicle bike1 = new Bike("123", "honda", true);
        Vehicle car1 = new Car("324", "BMW", true);

        List<Vehicle> list = new ArrayList<>();
        list.add(bike1);
        list.add(car1);

        for (Vehicle ele: list)
            ele.performSafetyCheck();
    }
}

class Vehicle {
    private String vehicleId;
    private String brand;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String brand, boolean isAvailable) {
        setVehicleId(vehicleId);
        this.brand = brand;
        this.isAvailable = isAvailable;
    }

    public void calculateRent(int days) {
        System.out.println("Final price for " + days + " days is " + days * 500);
    }

    public void calculateRent(int days, double discount) {
        double total = days * 500;
        double finalPrice = total - (total * discount / 100.0);

        System.out.println("Final price after discount of " + discount + " Rs. " + finalPrice);
    }

    public String getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.vehicleId = id;
            System.out.println("Vehicle id saved successfully!");
        } else {
            System.out.println("Wrong vehicle id :(");
        }
    }

    public void performSafetyCheck() {
        System.out.println("Vehicle performing safety check");
    }
}

class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String vehicleId, String brand, boolean isAvailable, boolean hasCarrier) {
        super(vehicleId, brand, isAvailable);
        this.hasCarrier = hasCarrier;
    }

    public Bike(String vehicleId, String brand, boolean isAvailable) {
        super(vehicleId, brand, isAvailable);
    }

    public void sethasCarrier(boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
        System.out.println("Now has carrier is: " + hasCarrier);
    }


    @Override
    public void performSafetyCheck() {
        System.out.println("Checking helmet and chain tension...");
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String vehicleId, String brand, boolean isAvailable, int numberOfDoors) {
        super(vehicleId, brand, isAvailable);
        this.numberOfDoors = numberOfDoors;
    }

    public Car(String vehicleId, String brand, boolean isAvailable) {
        super(vehicleId, brand, isAvailable);
    }

    public void setnumberOfDoors(int numberOfDoors) {
        if (numberOfDoors > 0) {
            this.numberOfDoors = numberOfDoors;

            System.out.println("Now number of doors is: " + numberOfDoors);
        } else {
            System.out.println("Invalid number of doors");
        }
    }

    public int getnumberOfDoors() {
        return this.numberOfDoors;
    }

    @Override
    public void performSafetyCheck() {
        System.out.println("Checking airbags and seatbelts...");
    }
}