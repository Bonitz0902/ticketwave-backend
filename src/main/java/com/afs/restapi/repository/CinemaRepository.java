package com.afs.restapi.repository;

import com.afs.restapi.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    List<Cinema> findAllByLocationLocationIdAndMovieId(Long locationId, Long movieId);
}
