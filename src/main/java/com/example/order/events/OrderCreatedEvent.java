package com.example.order.events;

import com.example.order.models.Item;
import com.example.order.processor.EventContext;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("OrderCreated")
public class OrderCreatedEvent extends Event {
    public String orderId;
    public String customerId;
    public List<Item> items;
    public double totalAmount;

    @Override
    public void process(EventContext context) {
        context.createOrder(orderId, customerId, items, totalAmount);
    }
}
