package strategy;

public class StudentDiscountStrategy implements DiscountStrategy {
    private static final double DISCOUNT_RATE = 0.10;

    @Override
    public double applyDiscount(double amount) {
        return amount * (1 - DISCOUNT_RATE);
    }
}
