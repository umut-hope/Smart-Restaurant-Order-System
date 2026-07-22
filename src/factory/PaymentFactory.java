package factory;

public class PaymentFactory {
    public static Payment createPayment(String type) {
        switch (type.toLowerCase()) {
            case "credit": return new CreditCardPayment();
            case "cash":   return new CashPayment();
            default: throw new IllegalArgumentException("Invalid payment type: " + type);
        }
    }
}
