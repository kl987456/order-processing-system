package com.example.order.observers;

import com.example.order.events.Event;
import com.example.order.models.Order;

public interface Observer {
    void onEvent(Order order, Event event);
}
