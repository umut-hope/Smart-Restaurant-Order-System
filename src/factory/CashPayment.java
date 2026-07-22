package factory;

public class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.printf("[Payment] Cash received: %.2f TL%n", amount);
    }
}
