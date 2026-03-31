public class WithFacade {
    public static void main(String[] args) {
        System.out.println("ranjan");

        OrderFacade order = new PlaceOrder();
        order.checkout();
    }
}

interface OrderFacade {
    void checkout();
}

class PlaceOrder implements OrderFacade {
    
    InventoryService inventory;
    PaymentService payment;
    ShippingService shipping;
    NotificationService notification;

    public PlaceOrder() {
        inventory = new InventoryService();
        payment = new PaymentService();
        shipping = new ShippingService();
        notification = new NotificationService();
    }

    @Override
    public void checkout() {
        inventory.check();
        payment.process();
        shipping.ship();
        notification.send();
    }
}


class InventoryService {
    public void check() {
        System.out.println("checking product in our inventory");
    }
}

class PaymentService {
    public void process() {
        System.out.println("payment is in processing...");
    }
}

class ShippingService {
    public void ship() {
        System.out.println("your product is dispatch");
    }
}

class NotificationService {
    public void send() {
        System.out.println("your product delivered: notification");
    }
}

/*
Core Components
Facade: The friendly face, it knows which sub-system classes are responsible for a request and delegates the work.
Sub-systems: The complex classes that do the actual work. They have no knowledge of the Facade; they operate independently.
Client: Interacts only with the Facade to get the job done.
*/