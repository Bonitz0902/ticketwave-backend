package com.afs.restapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "seating")
public class Seating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seating_id")
    private Long seatingId;

    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "is_available")
    private boolean isAvailable;

    public Seating(){}

    public Seating(Long seatingId, Long scheduleId, String seatNumber, boolean isAvailable) {
        this.seatingId = seatingId;
        this.scheduleId = scheduleId;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }

    public Long getSeatingId() {
        return seatingId;
    }

    public void setSeatingId(Long seatingId) {
        this.seatingId = seatingId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
