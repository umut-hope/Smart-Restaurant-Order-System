package factory;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.printf("[Payment] Credit card charged: %.2f TL%n", amount);
    }
}
