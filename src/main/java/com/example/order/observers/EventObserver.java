package com.example.order.observers;

import com.example.order.events.Event;
import com.example.order.processor.EventContext;

public interface EventObserver {
    void beforeProcessing(Event event);
    void afterProcessing(Event event, EventContext context);
}
