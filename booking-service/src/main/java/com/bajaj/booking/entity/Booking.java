package com.bajaj.booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long showId;
    private String seats; // Comma separated seat IDs
    private Double amount;
    private LocalDateTime bookingTime;
    private String status; // PENDING, CONFIRMED, CANCELLED
}
