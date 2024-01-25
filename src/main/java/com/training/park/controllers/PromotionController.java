package com.training.park.controllers;

import com.training.park.models.Client;
import com.training.park.models.Employee;
import com.training.park.models.Promotion;
import com.training.park.services.EmployeeService;
import com.training.park.services.PromotionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/promotions")
public class PromotionController {

    private PromotionService promotionService;

    public PromotionController(PromotionService promotionService){
        this.promotionService = promotionService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(promotionService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. PLease try later.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Promotion entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(promotionService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. PLease try later.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(promotionService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. PLease try later.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Promotion entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(promotionService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. PLease try later.\"}");
        }
    }

}
