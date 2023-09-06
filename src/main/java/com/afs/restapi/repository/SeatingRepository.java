package com.afs.restapi.repository;

import com.afs.restapi.entity.Seating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatingRepository extends JpaRepository<Seating, Long> {
    List<Seating> findAllByScheduleIdAndIsAvailable(Long scheduleId, boolean isAvailable);

    @Query("SELECT s FROM Seating s WHERE s.seatingId IN :seatingIds")
    List<Seating> findAllByIdIn(List<Long> seatingIds);
}
