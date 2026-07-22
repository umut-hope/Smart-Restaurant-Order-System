package model;

import strategy.DiscountStrategy;
import strategy.NoDiscountStrategy;
import observer.OrderObserver;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private List<OrderItem> items;
    private DiscountStrategy discountStrategy;
    private List<OrderObserver> observers;
    private String status;

    public Order(String id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.discountStrategy = new NoDiscountStrategy();
        this.status = "CREATED";
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public double calculateTotal() {
        double subtotal = 0;
        for (OrderItem item : items) {
            subtotal += item.getSubTotal();
        }
        return discountStrategy.applyDiscount(subtotal);
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
        for (OrderObserver observer : observers) {
            observer.update(id, newStatus);
        }
    }

    public String getId()     { return id; }
    public String getStatus() { return status; }
}
