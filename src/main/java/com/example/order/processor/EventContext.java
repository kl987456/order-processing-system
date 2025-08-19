package com.example.order.processor;

import com.example.order.events.Event;
import com.example.order.models.Item;
import com.example.order.models.Order;
import com.example.order.observers.EventObserver;

import java.util.*;

public class EventContext {
    private final Map<String, Order> orderStore = new HashMap<>();
    private final List<EventObserver> observers = new ArrayList<>();

    // Observer management
    public void addObserver(EventObserver observer) {
        observers.add(observer);
    }

    public List<EventObserver> getObservers() {
        return observers;
    }

    // Order processing methods
    public void createOrder(String orderId, String customerId, List<Item> items, double totalAmount) {
        orderStore.put(orderId, new Order(orderId, customerId, items, totalAmount));
    }

    public void processPayment(String orderId, double amount) {
        Order order = orderStore.get(orderId);
        if (order != null) {
            order.setPaid(true);
        }
    }

    public void scheduleShipping(String orderId, String address) {
        Order order = orderStore.get(orderId);
        if (order != null) {
            order.setShippingAddress(address);
            order.setShipped(true);
        }
    }

    public void cancelOrder(String orderId, String reason) {
        Order order = orderStore.get(orderId);
        if (order != null) {
            order.setCancelled(true);
            order.setCancellationReason(reason);
        }
    }

    public Order getOrder(String orderId) {
        return orderStore.get(orderId);
    }

    // Optional: Notify all observers (if you want to notify manually from here)
    public void notifyBefore(Event event) {
        for (EventObserver observer : observers) {
            observer.beforeProcessing(event);
        }
    }

    public void notifyAfter(Event event) {
        for (EventObserver observer : observers) {
            observer.afterProcessing(event, this);
        }
    }
}
