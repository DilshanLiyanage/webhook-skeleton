package com.tharusha.webhook_implementation.service;

import com.tharusha.webhook_implementation.entity.Flight;
import com.tharusha.webhook_implementation.entity.Webhook;
import com.tharusha.webhook_implementation.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final WebhookService webhookService;

    public FlightService(FlightRepository flightRepository, WebhookService webhookService) {
        this.flightRepository = flightRepository;
        this.webhookService = webhookService;
    }


    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }
    public void addOrUpdateFlight(Flight flight) {
        // Implement logic to add or update a flight
        flightRepository.save(flight);

        // Trigger webhooks with the updated flight information
        List<Webhook> webhooks = webhookService.getAllWebhooks();
        String payload = "New flight information: " + flight.toString();

        for (Webhook webhook : webhooks) {
            webhookService.triggerUpdate(webhook.getId(), payload);
        }
    }
}
