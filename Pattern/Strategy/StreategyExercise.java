package Strategy;
public class StreategyExercise {
    public static void main(String[] args) {
        System.out.println("ranjan");
        DiscountService ds1 = new DiscountService();
        ds1.discountService(new PremiumDiscount());

        System.out.println(ds1.checkout(500));
        ds1.discountService(new FestivalDiscount());
        
        System.out.println(ds1.checkout(500));
    }
}


//here if u see object creation is manual and this is what we have to improve in factory pattern.
class DiscountService {
    private Discount discount;

    public void discountService(Discount discount) {
        this.discount = discount;
    }

    public int checkout(int price) {
        return discount.calculate(price);
    }
}


interface Discount {
    int calculate(int price);
}

class RegularDiscount implements Discount {
    @Override
    public int calculate(int price) {
        return price;
    }
}

class PremiumDiscount implements Discount {
    @Override
    public int calculate(int price) {
        return (int)(0.9 * price);
    }
}

class FestivalDiscount implements Discount {
    @Override
    public int calculate(int price) {
        return (int)(0.8 * price);
    }
}

class CouponDiscount implements Discount {
    @Override
    public int calculate(int price) {
        return price - 500;
    }
}