package com.example.order.events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "eventType"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = OrderCreatedEvent.class, name = "OrderCreated"),
    @JsonSubTypes.Type(value = PaymentReceivedEvent.class, name = "PaymentReceived"),
    @JsonSubTypes.Type(value = ShippingScheduledEvent.class, name = "ShippingScheduled"),
    @JsonSubTypes.Type(value = OrderCancelledEvent.class, name = "OrderCancelled")
})
public abstract class Event {
    public String eventId;
    public String eventType;
    public String timestamp;

    public abstract void process(com.example.order.processor.EventContext context);
}
