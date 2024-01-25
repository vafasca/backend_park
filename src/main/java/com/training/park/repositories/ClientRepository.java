package com.training.park.repositories;

import com.training.park.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c LEFT JOIN Ticket t ON c.id = t.client.id GROUP BY c ORDER BY COUNT(t) DESC")
    List<Client> findClientsOrderByTicketCountDesc();


}
