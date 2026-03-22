public class PaymentServiceFollowed {
    public static void main(String[] args) {
        System.out.println("ranjan");

        PaymentService payment = new PaymentService();
        payment.processOrderPayment(new UPI(), 500.0);

    }
}

class PaymentService {
    public void processOrderPayment(Payment payment, double amount) {
        payment.pay(amount);
    }
    
}

interface Payment {
    public void pay(double amount);
}


class CreditCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("You are paying " + amount + " using credit card");
    }
}

class DebitCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("You are paying " + amount + " using debit card");
    }
}

class UPI implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("You are paying Rs. " + amount + " using UPI");
    }
}



/*

during writing this code i thought if i removed if else block and make code to follow OCP that's fine but when user come
and select payment using UPI then in that case i need if else block to make decision so how to deal with it
i found this problem then solve using factory pattern.

again one more question why i used interface when java gives us abstract cls:
jo here we use interface bcz Use an interface when you want to define a contract that multiple, unrelated classes must follow. It’s best for horizontal behavior.
Scenario: You have CreditCard and Crypto. They have totally different logic, but they both "can" pay().
Key Strength: A class can implement multiple interfaces (e.g., CreditCard implements PaymentMethod AND Taxable).

interface give a CAN-DO relationship

on the other hand abstract cls follow is a relation ship, and u should use when
when classes share common code or state (variables). 
It’s best for vertical hierarchy where you want to avoid code duplication.
Scenario: All "Card" payments (Debit and Credit) need to validateExpiry(). Instead of writing that logic twice, you put it in an abstract class.
Key Strength: You can provide "default" behavior so the child classes don't have to rewrite everything.

abstract when u have common code, interface a common contract just u need: POLYMORPHISM scenario
*/