public class TravelBooking {
    public static void main(String[] args) {
        System.out.println("ranjan");

        TravelFacade travelBooking = new TravelService(new FlightService(), new HotelService(), new CabService(), new PaymentService(), new NotificationService());
        BookingResponse response = travelBooking.bookMyDestination("Ranjan", "Singapore", 5);
        System.out.println("response message: " + response.message);
        System.out.println("response status: " + response.status);
    }
}

interface TravelFacade {
    BookingResponse bookMyDestination(String user, String destination, int days);
}

class BookingResponse {
    String message;
    boolean status;

    public BookingResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
}

class TravelService implements TravelFacade {
    FlightService flightService;
    HotelService hotelService;
    CabService cabService;
    PaymentService paymentService;
    NotificationService notificationService;

    public TravelService(FlightService flightService, HotelService hotelService, CabService cabService, PaymentService paymentService, NotificationService notificationService) {
        this.flightService = flightService;
        this.hotelService = hotelService;
        this.cabService = cabService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    @Override
    public BookingResponse bookMyDestination(String user, String destination, int days) {

        if (!flightService.flightBooking(destination)) {
            return new BookingResponse("flight booking failed", false);
        }
        
        if (!hotelService.hotelBooking(destination, days)) {
            return new BookingResponse("hotel booking failed", false);
        }

        if (!cabService.cabBooking(destination))
            return new BookingResponse("cab booking failed", false);
        
        double amount = 5000 * days;
        if (!paymentService.payment(user, amount))
            return new BookingResponse("payment failed", false);
    
        notificationService.send(user, destination, days);

        return new BookingResponse(destination + " for " + days + " booked successfully, Rs. " + amount , true);
    }
}

class FlightService {
    public boolean flightBooking(String destination) {
        System.out.println("Flight to " + destination + " booked successfully");
        return true;
    }
}

class HotelService {
    public boolean hotelBooking(String destination, int days) {
        System.out.println("Hotel in " + destination + " booked for " + days + " days !");
        return true;
    }
}

class CabService {
    public boolean cabBooking(String destination) {
        System.out.println("Cab to " + destination + " booked, thank you for choosing us");
        return true;
    }
}

class PaymentService {
    public boolean payment(String user, double amount) {
        System.out.println(user + " your payment of amount " + amount + " processed successfully!");
        return true;
    } 
}

class NotificationService {
    public void send(String user, String destination, int days) {
        System.out.println("Thank you for choosing flyTravel Mr. " + user + " destination " + destination + " booked for " + days + " days, ENJOY :)");
    }
}