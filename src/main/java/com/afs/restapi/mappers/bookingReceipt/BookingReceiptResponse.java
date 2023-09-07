package com.afs.restapi.mappers.bookingReceipt;

public class BookingReceiptResponse {
    private Long bookingId;
    private Long accountId;
    private Long cinemaId;
    private Long movieId;
    private Long scheduleId;
    private Long seatingId;
    private String cinemaName;
    private String accountName;
    private String movieName;
    // You can add more details as needed

    // Constructors, getters, and setters

    public BookingReceiptResponse() {
    }

    public BookingReceiptResponse(
            Long bookingId,
            String accountName,
            String movieName,
            Long scheduleId,
            Long seatingId,
            String cinemaName) {
        this.bookingId = bookingId;
        this.accountName = accountName;
        this.movieName = movieName;
        this.scheduleId = scheduleId;
        this.seatingId = seatingId;
        this.cinemaName = cinemaName;
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

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    // Getters and setters
}
