package com.afs.restapi.mappers;

import com.afs.restapi.entity.Cinema;
import com.afs.restapi.entity.Movie;

import java.util.Date;

public class MovieScheduleResponse {
    private Long scheduleId;
    private Cinema cinema;
    private Date startDate;
    private Date endDate;
    private String startTime;
    private String endTime;

    public MovieScheduleResponse(){
    }

    public MovieScheduleResponse(Long id, Cinema cinema, Date startDate, Date endDate, String startTime, String endTime) {
        this.scheduleId = id;
        this.cinema = cinema;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
