import model.Order;
import model.OrderItem;
import strategy.NoDiscountStrategy;
import strategy.StudentDiscountStrategy;
import factory.Payment;
import factory.PaymentFactory;
import observer.CustomerNotifier;
import observer.KitchenNotifier;

public class Main {
    public static void main(String[] args) {

        // ── Scenario 1: Student Discount + Credit Card ──────────────────────
        System.out.println("=== Scenario 1: Student Discount + Credit Card ===");
        Order order1 = new Order("ORD-001");
        order1.addItem(new OrderItem("Burger", 80.0, 2));
        order1.addItem(new OrderItem("Cola",   30.0, 1));
        order1.setDiscountStrategy(new StudentDiscountStrategy());
        double total1 = order1.calculateTotal();
        System.out.printf("Subtotal: 190.00 TL  |  After 10%% student discount: %.2f TL%n", total1);
        Payment pay1 = PaymentFactory.createPayment("credit");
        pay1.pay(total1);

        System.out.println();

        // ── Scenario 2: No Discount + Cash ───────────────────────────────────
        System.out.println("=== Scenario 2: No Discount + Cash ===");
        Order order2 = new Order("ORD-002");
        order2.addItem(new OrderItem("Pizza", 150.0, 1));
        order2.setDiscountStrategy(new NoDiscountStrategy());
        double total2 = order2.calculateTotal();
        System.out.printf("Total (no discount): %.2f TL%n", total2);
        Payment pay2 = PaymentFactory.createPayment("cash");
        pay2.pay(total2);

        System.out.println();

        // ── Scenario 3: Observer – Order Status Updates ───────────────────────
        System.out.println("=== Scenario 3: Observer - Order Status Updates ===");
        Order order3 = new Order("ORD-003");
        order3.addItem(new OrderItem("Salad", 60.0, 1));
        order3.addObserver(new CustomerNotifier());
        order3.addObserver(new KitchenNotifier());
        order3.setStatus("PREPARING");
        order3.setStatus("READY");
        order3.setStatus("DELIVERED");

        System.out.println();

        // ── Scenario 4: Invalid Payment Type ─────────────────────────────────
        System.out.println("=== Scenario 4: Invalid Payment Type ===");
        try {
            Payment invalid = PaymentFactory.createPayment("bitcoin");
            invalid.pay(100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] " + e.getMessage());
        }
    }
}
