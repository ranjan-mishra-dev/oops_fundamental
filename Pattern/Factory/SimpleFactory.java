public class SimpleFactory {
    public static void main(String[] args) {
        System.out.println("ranjan");

        Payment p1 = PaymentService.createPayment("upi");
        p1.pay(500);

        Payment p2 = PaymentService.createPayment("credit card");
        p2.pay(1000);

    }    
}

class PaymentService {
    public static Payment createPayment(String type) {
        if (type.equals("upi")) {
            return new Upi();
        } else if (type.equals("credit card")) {
            return new CreditCard();
        } else if (type.equals("debit card")) {
            return new DebitCard();
        } else {
            throw new IllegalArgumentException("Invalid payment type selected");
        }
    }
}

interface Payment {
    void pay(double amount);
}

class CreditCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Amount of Rs. " + amount + " successfully transfer using your credit card");
    }
}

class Upi implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Amount of Rs. " + amount + " successfully transfer your upi");
    }
}

class DebitCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Amount of Rs. " + amount + " successfully transfer using your debit card");
    }
}

/*
i was thinking why we doing this, even why factory pattern exist later i found: as a developer our main motive is to decouple client from code and also keep things away that are keep changing, to avoid do again and again changing in not chaning code and change only where needed
during business logic if we see new Object creation things get hard to read and understand how many object getting created but if we make a centralized part for object creation then we don't have to worry in one of ur code
u also faced this problem creating multiple object base on need by doing if else that thing is actually called simple factory method

Simple Factory is a class that: creates objects based on input, hides object creation logic from the client
Intent: Move object creation logic to one place

we make checkout method static bcz: just a helper to create objects, not something with state, so creating its object is unnecessary overhead.

*/

/*
Added by AI

Structure
Product (interface) → common behavior
Concrete Products → actual implementations
Factory Class → decides which object to create
Client → only asks factory, doesn’t use new

Static methods are best when:
No instance variables
No object-specific behavior
*/