public class PaymentServiceViolated {
    public static void main(String[] args) {
        System.out.println("ranjan");
        PaymentService payment = new PaymentService();
        payment.pay("UPI");
    }
}

class PaymentService {
    public void pay(String type) {
        if (type.contains("Credit Card")) {
            System.out.println("Paying using credit card");
        } else if (type.contains("UPI")) {
            System.out.println("Paying using UPI");
        } else if (type.contains("Debit Card")) {
            System.out.println("Paying using debit card");
        }// but what i rupay card arrived????
    }
}

/**
 problem face during this OCP is first off all this payment service cls doing whole thing means i have to segregate following SRP
 but later i found if rupay card get added then again i have to come in payment service cls and put extra else if condition
 and OCP says: Open for extension, Closed for modification
You should be able to add new behavior, WITHOUT changing existing code

so i thought thought and thought.... :)
 */
