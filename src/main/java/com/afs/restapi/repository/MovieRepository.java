package com.afs.restapi.repository;

import com.afs.restapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository <Movie,Long> {

}
