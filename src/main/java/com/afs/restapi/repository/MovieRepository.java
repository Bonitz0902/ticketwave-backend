package com.afs.restapi.repository;

import com.afs.restapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository <Movie,Long> {
    List<Movie> findTop10ByOrderByRatingDesc();
}
