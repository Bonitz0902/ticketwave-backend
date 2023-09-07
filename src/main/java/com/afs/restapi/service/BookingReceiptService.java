package com.afs.restapi.service;

import com.afs.restapi.entity.BookingReceipt;
import com.afs.restapi.mappers.bookingReceipt.BookingReceiptMapper;
import com.afs.restapi.mappers.bookingReceipt.BookingReceiptResponse;
import com.afs.restapi.repository.BookingReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingReceiptService {
    private final BookingReceiptRepository bookingReceiptRepository;
    private final BookingReceiptMapper bookingReceiptMapper;

    @Autowired
    public BookingReceiptService(BookingReceiptRepository bookingReceiptRepository, BookingReceiptMapper bookingReceiptMapper) {
        this.bookingReceiptRepository = bookingReceiptRepository;
        this.bookingReceiptMapper = bookingReceiptMapper;
    }

    public List<BookingReceipt> getAllBookingReceipts() {
        return bookingReceiptRepository.findAll();
    }

    public BookingReceiptResponse getBookingReceiptById(Long id) {
        BookingReceipt bookingReceipt = bookingReceiptRepository.findByBookingId(id);
        BookingReceiptResponse bookingReceiptResponse = bookingReceiptMapper.toResponse(bookingReceipt);
        return bookingReceiptResponse;
    }

    public BookingReceipt createBookingReceipt(BookingReceipt bookingReceipt) {
        return bookingReceiptRepository.save(bookingReceipt);
    }

    public void deleteBookingReceipt(Long id) {
        bookingReceiptRepository.deleteById(id);
    }
}
