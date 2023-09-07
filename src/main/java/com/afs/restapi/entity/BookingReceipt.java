package com.afs.restapi.entity;

import com.afs.restapi.controller.BookingReceiptController;

import javax.persistence.*;

@Entity
@Table(name = "booking_receipt")
public class BookingReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "cinema_id")
    private Long cinemaId;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "seating_id")
    private Long seatingId;

    public BookingReceipt(Long bookingId, Long accountId, Long cinemaId,
                          Long movieId, Long scheduleId, Long seatingId) {
        this.bookingId = bookingId;
        this.accountId = accountId;
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.scheduleId = scheduleId;
        this.seatingId = seatingId;
    }

    public BookingReceipt(){

    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getSeatingId() {
        return seatingId;
    }

    public void setSeatingId(Long seatingId) {
        this.seatingId = seatingId;
    }
}
