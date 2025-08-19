package com.example.order.events;

import com.example.order.processor.EventContext;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonTypeName("PaymentReceived")
public class PaymentReceivedEvent extends Event {
    public String orderId;

    @JsonProperty("amount")  // 🛠 Match JSON field
    public double amountPaid;

    @Override
    public void process(EventContext context) {
        context.processPayment(orderId, amountPaid);
    }
}
