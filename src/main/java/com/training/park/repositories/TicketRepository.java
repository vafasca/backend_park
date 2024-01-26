package com.training.park.repositories;

import com.training.park.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.client.id = :clientId")
    List<Ticket> findTicketsByClientId(@Param("clientId") Long clientId);
}
