package com.example.order.models;

import java.util.List;

public class Order {
    private String orderId;
    private String customerId;
    private List<Item> items;
    private double totalAmount;
    private boolean paid;
    private boolean shipped;
    private boolean cancelled;
    private String shippingAddress;
    private String cancellationReason;

    public Order(String orderId, String customerId, List<Item> items, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        if (cancelled) return "Cancelled";
        if (!paid) return "Pending Payment";
        if (!shipped) return "Payment Received";
        return "Shipped";
    }

    // ✅ Add these missing setters
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }
}
