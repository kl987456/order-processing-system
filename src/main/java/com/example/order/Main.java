package com.example.order;

import com.example.order.observers.*;
import com.example.order.processor.*;

public class Main {
    public static void main(String[] args) {
        EventContext context = new EventContext();

        // ✅ Register observers with the context (not processor)
        context.addObserver(new LoggerObserver());
        context.addObserver(new AlertObserver());

        EventProcessor processor = new EventProcessor(context);
        String filePath = "src/main/resources/events.json";
        processor.processEvents(filePath);
    }
}
