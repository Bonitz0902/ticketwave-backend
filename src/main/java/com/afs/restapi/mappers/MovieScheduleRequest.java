package com.afs.restapi.mappers;

import java.util.Date;

public class MovieScheduleRequest {
    private Long scheduleId;
    private Long cinemaId;
    private Date startDate;
    private Date endDate;
    private String startTime;
    private String endTime;


    public MovieScheduleRequest(Long scheduleId, Long cinemaId,  Date startDate, Date endDate, String startTime, String endTime) {
        this.scheduleId = scheduleId;
        this.cinemaId = cinemaId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
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

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }
}
