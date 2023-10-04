package com.afs.restapi.mappers;

import java.util.List;

public class SeatingRequest {
    private Long scheduleId;
    private List<String> seatNumbers;

    private boolean isAvailable;

    public SeatingRequest(){
        //empty Constructor
    }

    public SeatingRequest(Long scheduleId, List<String> seatNumbers, boolean isAvailable) {
        this.scheduleId = scheduleId;
        this.seatNumbers = seatNumbers;
        this.isAvailable = isAvailable;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
