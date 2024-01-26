package com.training.park.controllers;

import com.training.park.models.Client;
import com.training.park.models.Ticket;
import com.training.park.services.ClientService;
import com.training.park.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tickets")
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Ticket entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ticketService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. PLease try later.\"}");
        }
    }

    @GetMapping("/frecuency/{clientId}")
    public ResponseEntity<?> getTicketsByClient(@PathVariable Long clientId){
        try {
            List<Ticket> tickets = ticketService.obtenerTicketsPorCliente(clientId);
            return ResponseEntity.status(HttpStatus.OK).body(tickets);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please try later.\"}");
        }
    }

}
