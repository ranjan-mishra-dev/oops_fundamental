public class WithStrategy {
    public static void main(String[] args) {
        System.out.println("Ranjan");
        PaymentService service = new PaymentService(new CreditCardService());
        service.checkout(2000);
        
        PaymentService service2 = new PaymentService(new UpiService());
        service2.checkout(5000);
    }
}

/*one thought trigger is for each new service like credit then upi i have to create new payment service?
previously i was putting payment strategy creation in constructor but for this u have create another method in payment service to handle so that avoid multiple object creation
but u can go with constructor method to avoid runtime chng, setter way to give flexibility to chng at runtime like clicking on pay in cart to chng payment method upi to debit else.


*/

interface Payment {
    void pay(int amount);
}

class CreditCardService implements Payment{
    @Override
    public void pay(int amount) {
        System.out.println("Amount of Rs. " + amount + " processing using credit card");
    }
}

class UpiService implements Payment{
    @Override
    public void pay(int amount) {
        System.out.println("Amount of Rs. " + amount + " processing using UPI");
    }
}

class PaymentService {
    private final Payment payment;

    public PaymentService(Payment payment) {
        this.payment = payment;
    }

    public void checkout(int amount) {
        System.out.println("Payment processing");
        payment.pay(amount);
        System.out.println("Payment successully completed...");
    }

}

/**
 i was thinking we read SOLID prinicple then what need of this pattern then i found, unintentionally i used this pattern in my one of code :)
 
 actually what this pattern say define a family of algorithm, put them into separate classes and so that they can be changed at runntime
 previosuly if u don't have strategy pattern in that case you have to write multiple if else condition to execute an algo base on need
 but problem too much if else, your logic is also visible and and hard to test/debug and also break OCP you have to go in main cls to chng if-else for every new feature addition

 when to use:
 when multiple way to perform same task u can go with creating one single algo,
 too many if else, behvaiour chng at runtime


 
 */

 /*
 Added by AI

 Instead of writing multiple if-else or switch conditions, you create separate classes for each behavior and choose one dynamically.
 You have multiple algorithms and want to switch dynamically -> SP

 Problems:
Violates Open/Closed Principle
Hard to maintain
Code becomes messy with more conditions
Difficult to test individual logic


Setter Injection (changing the strategy on an existing object) vs. Constructor Injection (creating a new object for each strategy).


1. The "Academic" Answer (Which is the Strategy Pattern?)
Both are valid Strategy Patterns.
The core of the Strategy Pattern is Composition (having a reference to an interface) rather than Inheritance. Whether you swap that reference via a constructor or a setter doesn't change the fact that it's a Strategy Pattern.

2. The "Real-World" Answer (Which should you use?)
Use Constructor Injection (The "Notification" style) if:
The behavior shouldn't change mid-process: Once you start an "Email Notification," you don't suddenly want it to turn into an "SMS" halfway through the logic.

Immutability: It makes your code thread-safe. Once service is created, you know exactly what it does.

Dependency Safety: You ensure the object is never "empty" or null because the constructor forces you to provide a strategy.

Use Setter Injection (The "ShoppingCart" style) if:
The object is a "Long-lived" Container: A Shopping Cart lives while the user browses. The user might change their payment method three times before clicking "Pay."

State-Dependent Behavior: If the strategy depends on a user's toggle/switch in a UI that happens after the object is created.

The Verdict: How to do it like a Pro
In high-level LLD (like designing a system for Amazon or Uber), we actually combine them. We use Constructor Injection for the service, but we use a Factory to decide which strategy to inject.
 */