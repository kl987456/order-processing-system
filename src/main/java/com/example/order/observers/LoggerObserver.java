package com.example.order.observers;

import com.example.order.events.Event;
import com.example.order.processor.EventContext;

public class LoggerObserver implements EventObserver {
    @Override
    public void beforeProcessing(Event event) {
        System.out.println("📥 [Logger] Processing event: " + event.eventType);
    }

    @Override
    public void afterProcessing(Event event, EventContext context) {
        System.out.println("✅ [Logger] Finished processing event: " + event.eventType);
    }
}
