package com.afs.restapi.repository;

import com.afs.restapi.entity.BookingReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingReceiptRepository extends JpaRepository<BookingReceipt, Long> {
    BookingReceipt findByBookingId(Long id);
}
