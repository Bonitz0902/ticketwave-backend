package com.afs.restapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private Long cinemaId;

    @ManyToOne
    @JoinColumn(name = "location_id") // This should match the column name in the database
    private Location location;

    @ManyToOne
    @JoinColumn(name = "movie_id") // This should match the column name in the database
    private Movie movie;

    @Column(name = "cinema_name")
    private String cinemaName;

    // Constructors, getters, and setters

    public Cinema() {
    }

    public Cinema(Location location, Movie movie, String cinemaName) {
        this.location = location;
        this.movie = movie;
        this.cinemaName = cinemaName;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }
}
