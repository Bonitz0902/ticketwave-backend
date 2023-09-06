package com.afs.restapi.mappers;

public class SeatingResponse {

    private Long seatingId;
    private Long scheduleId;
    private String seatNumber;
    private boolean isAvailable;

    public SeatingResponse(){}

    public SeatingResponse(Long seatingId, Long scheduleId, String seatNumber, boolean isAvailable) {
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
