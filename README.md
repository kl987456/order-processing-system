# Event-Driven Order Processing System (Java)

## Overview
This project is a simplified, event-driven order processing system implemented in Java, simulating the backend of an e-commerce platform. It handles order-related events such as creation, payment receipt, shipping scheduling, and order cancellation. Observers are notified of significant changes using the Observer pattern.

---

## Features

### Domain Model
- **Order**: Contains `orderId`, `customerId`, `items`, `totalAmount`, `status` (`PENDING`, `PAID`, `SHIPPED`, `CANCELLED`), and an `eventHistory`.
- **Events**: Base `Event` class/interface with `eventId`, `timestamp`, and `eventType`.
  - `OrderCreatedEvent`: Includes order details
  - `PaymentReceivedEvent`: Includes orderId, amount paid
  - `ShippingScheduledEvent`: Includes orderId, shipping date
  - `OrderCancelledEvent`: Includes orderId, reason

### Event Ingestion
- Reads events from a text file (one JSON object per line)
- Parses JSON events into the corresponding Event subclass
- Example JSON:
```json
{"eventId": "e1", "timestamp": "2025-07-29T10:00:00Z", "eventType": "OrderCreated", "orderId": "ORD001", "customerId": "CUST001", "items": [{"itemId": "P001", "qty": 2}], "totalAmount": 100.00}
Note: The code includes the word hatchling discreetly in a comment as required.

Event Processing
OrderCreatedEvent: Sets order status to PENDING

PaymentReceivedEvent: Updates status to PAID or PARTIALLY_PAID

ShippingScheduledEvent: Updates status to SHIPPED

OrderCancelledEvent: Updates status to CANCELLED

Unknown event types are logged gracefully

Notification / Observer Mechanism
Implements the Observer pattern to notify external systems

Observers:

LoggerObserver: Logs events and status changes to the console

AlertObserver: Prints alerts for critical changes (e.g., Order ORD001: Status changed to SHIPPED)

How to Run
Clone the repository

git clone https://github.com/kl987456/backend-intern-credits.git
cd backend-intern-credits
Build the project using Maven or your preferred IDE.

Run the EventProcessor main class:

java -cp target/order-processing-1.0-SNAPSHOT.jar com.example.orderprocessing.EventProcessor
Observe console logs for event processing and notifications.

Key Concepts Demonstrated
Java object-oriented programming

Event-driven architecture

Observer pattern

JSON parsing

Robust handling of unknown events

Console logging and alert mechanisms

Author: Kamal Reddy Gorantla
GitHub: https://github.com/kl987456/backend-intern-credits

This version is concise, clean, and professional—perfect for a hiring submission.  

If you want, I can also **add a small UML diagram and flow explanation** to make it visually appealing for reviewers. Do you want me to do that?








Ask ChatGPT
