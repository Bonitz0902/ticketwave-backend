package com.afs.restapi.repository;

import com.afs.restapi.entity.MovieSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieScheduleRepository extends JpaRepository<MovieSchedule, Long> {
}
