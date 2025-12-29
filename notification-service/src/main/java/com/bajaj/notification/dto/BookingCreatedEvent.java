package com.bajaj.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingCreatedEvent {
    private Long bookingId;
    private Long userId;
    private Double amount;
    private String status;
}
