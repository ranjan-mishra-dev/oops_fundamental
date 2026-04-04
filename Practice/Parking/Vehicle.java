import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class ParkingManager {
    public static void main(String[] args) {
        System.out.println("ranjan parking LLC.");
        // ranjan in this design two problem is their guess? every time when u see this code 

        ParkingLotSystem parkingLotSystem = ParkingLotSystem.getInstance();

        Floors f1 = new Floors(1);

        ParkingSpot spot1 = new ParkingSpot("F1S1", VehicleSize.SMALL);
        ParkingSpot spot2 = new ParkingSpot("F1S2", VehicleSize.LARGE);
        ParkingSpot spot3 = new ParkingSpot("F1S3", VehicleSize.MEDIUM);

        f1.addParkingSpot(spot1);
        f1.addParkingSpot(spot2);
        f1.addParkingSpot(spot3);

        parkingLotSystem.addFloors(f1);

        Vehicle car = new Car("MH021234");
        Vehicle truck = new TataTruck("MH061234");
        Vehicle cycle = new Cycle("MH0912334");

        PaymentStrategy paymentStrategy = new DebitCard();
        FareStrategy fareStrategy = new HourlyRateStrategy();

        PaymentProcessor processor = new PaymentProcessor(paymentStrategy, fareStrategy);
        parkingLotSystem.setPaymentProcessor(processor);


        ParkingResponse response = parkingLotSystem.parkVehicle(cycle);
        System.out.println("RESPONSE MSG: " + response.message + " PARKING STATUS: " + response.status + " YOUR TICKET: " + response.ticket);
        
        parkingLotSystem.leaveVehicle(response.ticket);

        
    }
}

//sol of those problem 1. implment factory method 2. singleton way of creation

class ParkingLotSystem {
    private List<Floors> listOFloors = new ArrayList<>();
    private static ParkingLotSystem instance;

    private PaymentProcessor paymentProcessor;
    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }


    public void addFloors(Floors floor) {
        listOFloors.add(floor);
    }

    public synchronized static ParkingLotSystem getInstance() {
        if (instance == null)
            instance = new ParkingLotSystem();
        
        return instance;
    }

    public ParkingSpot findAvailability(Vehicle vehicle) {
        for (Floors floor: listOFloors) {
            ParkingSpot spot = floor.getAvailableParkingSpot(vehicle);
            if (spot != null) {
                return spot;
            }
        }
        return null;
    }

    public ParkingResponse parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailability(vehicle);
        if (spot == null) {
            return new ParkingResponse(null, "Sorry! no spot left", false);
        }
        Ticket ticket = new Ticket(vehicle.getSize(), vehicle, spot);
        spot.parkVehicle(vehicle);
        return new ParkingResponse(ticket, "Your vehicle ticket generated successfully",true);
    }

    public void leaveVehicle (Ticket ticket) {
        ticket.setExitTime();
        ticket.getVehicleSpot().unParkVehicle();
        if (paymentProcessor.pay(ticket)) {
            System.out.println("Thank you for choosing us!");
        } else {
            System.out.println("Payment failed plz try again");
        }
    }
}

class PaymentProcessor {
    private PaymentStrategy paymentStrategy;
    private FareStrategy fareStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy, FareStrategy fareStrategy) {
        this.paymentStrategy = paymentStrategy;
        this.fareStrategy = fareStrategy;
    }

    public boolean pay(Ticket ticket) {
        double amount = fareStrategy.calculateFare(ticket);
        return paymentStrategy.pay(amount);
    } 
}

class ParkingResponse {
    Ticket ticket;
    String message;
    boolean status;

    public ParkingResponse(Ticket ticket, String message, boolean status) {
        this.ticket = ticket;
        this.message = message;
        this.status = status;
    }
}


class Floors {
    List<ParkingSpot> listOfParkingSpot = new ArrayList<>();
    private int floorNumber;

    ParkingStrategy strategy = new CurrentParkingStrattegy();

    public Floors(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void addParkingSpot(ParkingSpot spot) {
        this.listOfParkingSpot.add(spot);
    }

    public ParkingSpot getAvailableParkingSpot(Vehicle vehicle) {
        for (ParkingSpot spot: listOfParkingSpot) {
            if (strategy.getFitVehicle(vehicle, spot)) {
                return spot;
            }
        }

        return null;
    }

    public void displaySpotAvailability() {
        for (ParkingSpot spot: listOfParkingSpot) {
            if (spot.isAvailable()) {
                System.out.println("Spot id: " + spot.getSpotId() + " is empty!");
            }
         }
    }
}

class ParkingSpot {
    private String spotId;
    private VehicleSize spotType;
    private boolean isOccupied;
    private Vehicle parkVehicle;
    
    public ParkingSpot(String spotId, VehicleSize spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return isOccupied;
    }

    public String getSpotId() {
        return spotId;
    }

    public VehicleSize getSpotType() {
        return spotType;
    }

    public void parkVehicle(Vehicle vehicle) {
        isOccupied = true;
        this.parkVehicle = vehicle;
    }

    public void unParkVehicle() {
        isOccupied = false;
        this.parkVehicle = null;
    }
}

interface ParkingStrategy {
    boolean getFitVehicle(Vehicle vehicle, ParkingSpot spot);
}

class CurrentParkingStrattegy implements ParkingStrategy {
    @Override
    public boolean getFitVehicle(Vehicle vehicle, ParkingSpot spot) {
        if (!spot.isAvailable())
                return false;

        VehicleSize spotType = spot.getSpotType();
        VehicleSize vehicleType = vehicle.getSize();

        switch (vehicleType) {
            case SMALL:
                return spotType == VehicleSize.SMALL;
            case MEDIUM:
                return spotType == VehicleSize.MEDIUM;
            case LARGE:
                return spotType == VehicleSize.LARGE;
            default:
                return false;
        }

    }
}

public abstract class Vehicle {
    private final String licenseNumber;
    private final VehicleSize size;

    public Vehicle(String licenseNumber, VehicleSize size) {
        this.licenseNumber = licenseNumber;
        this.size = size;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleSize getSize() {
        return size;
    }
}

class Car extends Vehicle {
    public Car(String numberplate) {
        super(numberplate, VehicleSize.MEDIUM);
    }
}

class Cycle extends Vehicle {
    public Cycle(String numberplate) {
        super(numberplate, VehicleSize.SMALL);
    }
}

class TataTruck extends Vehicle {
    public TataTruck(String numberplate) {
        super(numberplate, VehicleSize.LARGE);
    }
}

class Ticket {
    private final String ticketId;
    private final VehicleSize spotType;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private long entryTime;
    private long exitTime;

    public Ticket(VehicleSize vehicleSize, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.spotType = vehicleSize;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = System.currentTimeMillis();
    }

    public ParkingSpot getVehicleSpot() {
        return parkingSpot;
    }

    public VehicleSize getVehicleSize() {
        return spotType;
    }

    public Vehicle vehicleType() {
        return vehicle;
    }
    
    public void setExitTime() {
        this.exitTime = System.currentTimeMillis();
    }   

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }   
}

interface PaymentStrategy {
    boolean pay(double amount);
}

class UPI implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Payment of Rs. " + amount + " processed successfully using UPI");
        return true;
    }
}

class DebitCard implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Payment of Rs. " + amount + " processed successfully using DebitCard");
        return true; 
    }
 
}


interface FareStrategy {
    double calculateFare(Ticket ticker);
}

class FixedRateStrategy implements FareStrategy {
    @Override
    public double calculateFare(Ticket ticket) {
        return ticket.getVehicleSize().calculateFare();
    }
}

class HourlyRateStrategy implements FareStrategy {
    @Override
    public double calculateFare(Ticket ticket) {

        long entryTime = ticket.getEntryTime();        
        long exitTime = ticket.getExitTime(); 

        double hours = ((exitTime - entryTime) / (1000 * 60 * 60)) + 1;
        return hours * 45;

    }
}

enum VehicleSize {
    SMALL(100),
    MEDIUM(200),
    LARGE(500);

    private final double fare;

    private VehicleSize(double fare) {
        this.fare = fare;
    }

    public double calculateFare() {
        return fare;
    }   
}