package com.example.order.events;

import com.example.order.processor.EventContext;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonTypeName("ShippingScheduled")
public class ShippingScheduledEvent extends Event {
    public String orderId;

    @JsonProperty("address")  // 🛠 Match JSON field
    public String shippingDate;

    @Override
    public void process(EventContext context) {
        context.scheduleShipping(orderId, shippingDate);
    }
}
