package com.bajaj.booking.service;

import com.bajaj.booking.dto.BookingCreatedEvent;
import com.bajaj.booking.entity.Booking;
import com.bajaj.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    @Autowired
    private KafkaTemplate<String, BookingCreatedEvent> kafkaTemplate;

    @Transactional
    public Booking createBooking(Booking booking) {
        // Here we would call Event Service to lock seats
        // For now, we assume seats are available
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus("CONFIRMED");
        Booking savedBooking = repository.save(booking);

        // Send Notification
        kafkaTemplate.send("booking-confirmed", new BookingCreatedEvent(savedBooking.getId(), savedBooking.getUserId(), savedBooking.getAmount(), savedBooking.getStatus()));

        return savedBooking;
    }
}
