package com.example.order.processor;

import com.example.order.events.*;
import com.example.order.observers.EventObserver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EventProcessor {
    private final ObjectMapper mapper;
    private final EventContext context;
    private final List<EventObserver> observers = new ArrayList<>();

    public EventProcessor(EventContext context) {
        this.context = context;
        this.mapper = new ObjectMapper();
        mapper.registerSubtypes(
                new NamedType(OrderCreatedEvent.class, "OrderCreated"),
                new NamedType(PaymentReceivedEvent.class, "PaymentReceived"),
                new NamedType(ShippingScheduledEvent.class, "ShippingScheduled"),
                new NamedType(OrderCancelledEvent.class, "OrderCancelled")
        );
    }

    public void addObserver(EventObserver observer) {
        observers.add(observer);
    }

    public void processEvents(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> {
                try {
                    Event event = mapper.readValue(line, Event.class);
                    for (EventObserver obs : observers) obs.beforeProcessing(event);
                    event.process(context);
                    for (EventObserver obs : observers) obs.afterProcessing(event, context);
                } catch (Exception e) {
                    System.err.println("⚠️ Failed to process event: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.err.println("❌ Failed to read events file: " + e.getMessage());
        }
    }
}
