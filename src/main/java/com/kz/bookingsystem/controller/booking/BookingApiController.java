package com.kz.bookingsystem.controller.booking;

import com.kz.bookingsystem.dto.BSClassDTO;
import com.kz.bookingsystem.dto.BookingDTO;
import com.kz.bookingsystem.exception.CoreApiException;
import com.kz.bookingsystem.handler.ResponseSuccessHandler;
import com.kz.bookingsystem.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingApiController {

    private final BookingService service;

    public BookingApiController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> saveBooking(@RequestBody BookingDTO bookingDTO) {
        try{
            var res = new ResponseSuccessHandler();
            var result = service.saveBooking(bookingDTO);

            res.setBody(result.getData());
            return res.response();
        }
        catch (CoreApiException ex) {
            throw new CoreApiException(ex.getTitle(), ex.getCode(), ex.getMessage());
        }
    }
}
