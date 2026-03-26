public class FactoryMethod {
    public static void main(String[] args) {
        System.out.println("ranjan");

        PaymentFactory upiFactory = new UpiPaymentFactory();
        Payment upiProcessor = upiFactory.createPayment();
        upiProcessor.pay(5000.0);
        
        // If the user wants Credit Card, we use the Credit Card Factory
        PaymentFactory ccFactory = new CreditCardPaymentFactory();
        Payment ccProcessor = ccFactory.createPayment();
        ccProcessor.pay(10000.0);
    }
}

// thinking model for this u create a object factory of the feature u want, then using that factory u get that object's feature, then u use that object methods. 


interface PaymentFactory {
    Payment createPayment();
}

class UpiPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new UpiPayment();
    }
}

class CreditCardPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}

class DebitCardPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new DebitCardPayment();
    }
}

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Amount of Rs. " + amount + " successfully transfer using your credit card");
    }
}

class UpiPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Amount of Rs. " + amount + " successfully transfer your upi");
    }
}

class DebitCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Amount of Rs. " + amount + " successfully transfer using your debit card");
    }
}

/*
Factory Method defines an interface for creating an object, but lets subclasses decide which object to create.
main thinking is object creation is delegated to subclasses

why they did, whats wrong with simple factory actually its violating OCP principle and hard to maintain so main if else conditions, bcz of this just add another payment and use it.
No if-else, add new type  just add new class, no modification in existing code
*/