package com.example.order.events;

import com.example.order.processor.EventContext;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("OrderCancelled")
public class OrderCancelledEvent extends Event {
    public String orderId;
    public String reason;

    @Override
    public void process(EventContext context) {
        context.cancelOrder(orderId, reason);
    }
}
