package observer;

public class CustomerNotifier implements OrderObserver {
    @Override
    public void update(String orderId, String newStatus) {
        System.out.println("[Customer] Your order " + orderId + " is now: " + newStatus);
    }
}
