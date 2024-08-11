package com.tharusha.webhook_implementation.controller;

import com.tharusha.webhook_implementation.service.WebhookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks")
@RequiredArgsConstructor
public class WebhookController {
    private final WebhookService webhookService;

    public WebhookController(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @PostMapping
    public ResponseEntity<String> registerWebhook(@RequestBody String webhookUrl) {
        // Implement webhook registration logic
        // Example: webhookService.registerWebhook(webhookUrl);
        return ResponseEntity.ok("Webhook registered successfully");
    }
}
