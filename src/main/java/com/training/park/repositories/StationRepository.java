package com.training.park.repositories;

import com.training.park.models.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    @Query("SELECT s FROM Station s JOIN FETCH s.attractions")
    List<Station> findAllWithAttractions();
}
