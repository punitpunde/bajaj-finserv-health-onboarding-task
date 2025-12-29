package com.bajaj.notification.consumer;

import com.bajaj.notification.dto.BookingCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationConsumer {

    @KafkaListener(topics = "booking-confirmed", groupId = "notification-group")
    public void consume(BookingCreatedEvent event) {
        log.info("Received Notification for Booking: {}", event.getBookingId());
        // Simulate sending email
        log.info("Sending email to user: {}", event.getUserId());
    }
}
