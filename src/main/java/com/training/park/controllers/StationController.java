package com.training.park.controllers;

import com.training.park.models.Station;
import com.training.park.services.EmployeeService;
import com.training.park.services.StationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stations")
public class StationController {

    private StationService stationService;

    public StationController(StationService stationService){
        this.stationService = stationService;
    }
    @GetMapping
    public List<Station> getStationsWithAttractions() {
        return stationService.getStationsWithAttractions();
    }
}
