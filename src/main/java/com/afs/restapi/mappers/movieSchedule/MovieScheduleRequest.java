package com.afs.restapi.mappers.movieSchedule;

import java.util.Date;

public class MovieScheduleRequest {
    private Long scheduleId;
    private Long cinemaId;
    private Date scheduleDate;
    private String startTime;
    private String endTime;


    public MovieScheduleRequest(Long scheduleId, Long cinemaId, Date scheduleDate, String startTime, String endTime) {
        this.scheduleId = scheduleId;
        this.cinemaId = cinemaId;
        this.scheduleDate = scheduleDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
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

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }
}
