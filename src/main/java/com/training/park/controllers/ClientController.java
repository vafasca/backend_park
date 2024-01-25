package com.training.park.controllers;



import com.training.park.models.Client;
import com.training.park.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }



    @GetMapping("")
    public ResponseEntity<?> obtenerClientesOrdenadosPorCantidadDeTickets() {
        try {
            List<Client> clientesOrdenados = clientService.obtenerClientesOrdenadosPorCantidadDeTickets();
            return ResponseEntity.status(HttpStatus.OK).body(clientesOrdenados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"Error. Please try later.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. PLease try later.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Client entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. PLease try later.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Client entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. PLease try later.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clientService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. PLease try later.\"}");
        }
    }
}
