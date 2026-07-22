package observer;

public interface OrderObserver {
    void update(String orderId, String newStatus);
}
