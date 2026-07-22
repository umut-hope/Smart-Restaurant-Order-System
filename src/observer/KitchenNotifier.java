package observer;

public class KitchenNotifier implements OrderObserver {
    @Override
    public void update(String orderId, String newStatus) {
        System.out.println("[Kitchen] Order " + orderId + " status updated: " + newStatus);
    }
}
