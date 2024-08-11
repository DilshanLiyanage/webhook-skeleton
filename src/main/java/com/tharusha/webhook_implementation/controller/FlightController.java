package com.tharusha.webhook_implementation.controller;

import com.tharusha.webhook_implementation.entity.Flight;
import com.tharusha.webhook_implementation.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<String> addOrUpdateFlight(@RequestBody Flight flight) {
        flightService.addOrUpdateFlight(flight);
        return ResponseEntity.ok("Flight added or updated successfully");
    }
}
