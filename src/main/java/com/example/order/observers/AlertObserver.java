package com.example.order.observers;

import com.example.order.events.Event;
import com.example.order.processor.EventContext;

public class AlertObserver implements EventObserver {
    @Override
    public void beforeProcessing(Event event) {
        // Optional
    }

    @Override
    public void afterProcessing(Event event, EventContext context) {
        System.out.println("🔔 [ALERT] Event processed: " + event.eventType);
    }
}
