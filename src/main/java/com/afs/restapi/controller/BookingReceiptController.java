package com.afs.restapi.controller;

import com.afs.restapi.entity.BookingReceipt;
import com.afs.restapi.mappers.bookingreceipt.BookingReceiptResponse;
import com.afs.restapi.service.BookingReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/booking-receipts")
public class BookingReceiptController {
    private final BookingReceiptService bookingReceiptService;

    @Autowired
    public BookingReceiptController(BookingReceiptService bookingReceiptService) {
        this.bookingReceiptService = bookingReceiptService;
    }

    @GetMapping
    public List<BookingReceipt> getAllBookingReceipts() {
        return bookingReceiptService.getAllBookingReceipts();
    }

    @GetMapping("/{id}")
    public BookingReceiptResponse getBookingReceiptById(@PathVariable Long id) {
        return bookingReceiptService.getBookingReceiptById(id);
    }

    @PostMapping
    public BookingReceipt createBookingReceipt(@RequestBody BookingReceipt bookingReceipt) {
        return bookingReceiptService.createBookingReceipt(bookingReceipt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingReceipt(@PathVariable Long id) {
        bookingReceiptService.deleteBookingReceipt(id);
        return ResponseEntity.noContent().build();
    }
}
