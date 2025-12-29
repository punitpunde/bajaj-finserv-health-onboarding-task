package com.bajaj.booking.controller;

import com.bajaj.booking.entity.Booking;
import com.bajaj.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping
    public Booking bookTicket(@RequestBody Booking booking) {
        return service.createBooking(booking);
    }
}
