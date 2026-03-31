public class WithoutFacade {
    public static void main(String[] args) {
        System.out.println("ranjan");

        System.out.println("making e commerce order");
        InventoryService inventory = new InventoryService();
        PaymentService payment = new PaymentService();
        ShippingService shipping = new ShippingService();
        NotificationService notification = new NotificationService();

        inventory.check();
        payment.process();
        shipping.ship();
        notification.send();

        //checkout exercise, this is layman code to understand facade
    }
}

/*
this is most easiest pattern i found

what its need: you can see as a client you have to deal with muliple subsystem but what if i can achieve all this in one click this is what facade does
Facade provides a simplified interface to a complex system.

Client sees only one interface, client doesn’t know internal details, subsystem changes don’t affect client
*/

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
Added by AI

| Problem                 | Solution              |
| ----------------------- | --------------------- |
| Complex subsystem usage | Single entry point    |
| Too many dependencies   | Hide internal classes |
| Hard-to-use APIs        | Simplified interface  |
| Tight coupling          | Loose coupling        |

*/