package com.kz.bookingsystem.service;

import com.kz.bookingsystem.common.GenericService;
import com.kz.bookingsystem.dto.BookingDTO;

public interface BookingService {
    GenericService<Integer> saveBooking(BookingDTO bookingDTO);
}
