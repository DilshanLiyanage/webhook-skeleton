package com.tharusha.webhook_implementation.service;

import com.tharusha.webhook_implementation.entity.Webhook;
import com.tharusha.webhook_implementation.repository.WebhookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebhookService {
    private final WebhookRepository webhookRepository;
    private final WebhookExecutionService webhookExecutionService;

    public WebhookService(WebhookRepository webhookRepository, WebhookExecutionService webhookExecutionService) {
        this.webhookRepository = webhookRepository;
        this.webhookExecutionService = webhookExecutionService;
    }

    public void registerWebhook(String url) {
        // Implement registration logic
    }

    public void updateWebhook(Long webhookId, String newUrl) {
        // Implement update logic
    }

    public List<Webhook> getAllWebhooks() {
        return webhookRepository.findAll();
    }

    public void triggerUpdate(Long webhookId, String payload) {
        Webhook webhook = webhookRepository.findById(webhookId)
                .orElseThrow(() -> new EntityNotFoundException("Webhook not found"));

        webhookExecutionService.executeWebhook(webhook, payload);
    }
}
