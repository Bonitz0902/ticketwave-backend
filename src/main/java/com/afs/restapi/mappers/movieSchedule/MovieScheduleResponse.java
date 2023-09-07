package com.afs.restapi.mappers.movieSchedule;

import com.afs.restapi.entity.Cinema;

import java.util.Date;

public class MovieScheduleResponse {
    private Long scheduleId;
    private Cinema cinema;
    private Date scheduleDate;
    private String startTime;
    private String endTime;

    public MovieScheduleResponse(){
    }

    public MovieScheduleResponse(Long id, Cinema cinema, Date scheduleDate, String startTime, String endTime) {
        this.scheduleId = id;
        this.cinema = cinema;
        this.scheduleDate = scheduleDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
