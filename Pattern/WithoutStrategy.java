public class WithoutStrategy {
    public static void main(String[] args) {
        System.out.println("ranjan");
        PaymentService service = new PaymentService();
        service.pay("upi", 1000);
        service.pay("debit card", 5000);
    }
}

class PaymentService {

    public void pay(String type, int amount) {
        if (type.equals("credit card"))
            System.out.println("Amount of Rs. " + amount + " processing using " + type);
        else if (type.equals("upi"))
            System.out.println("Amount of Rs. " + amount + " processing using " + type);
        else if (type.equals("debit card"))
            System.out.println("Amount of Rs. " + amount + " processing using " + type);
        else
            throw new IllegalArgumentException("Invalid payment type");
    }
}

/*problem here is messy if else condition, solid principle violation for new feature addition, hard to debug and test, DRY principle violation what if 2 payment gateway has same logic then u again writing same code
mixing responsibilites in one cls */