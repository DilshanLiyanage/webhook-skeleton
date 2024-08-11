package com.tharusha.webhook_implementation.service;

import com.tharusha.webhook_implementation.entity.Webhook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;\

@Service
@RequiredArgsConstructor
public class WebhookExecutionService {

    private final RestTemplate restTemplate;

    public WebhookExecutionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retryable(
            value = { HttpServerErrorException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000)
    )
    public void executeWebhook(Webhook webhook, String payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        restTemplate.postForObject(webhook.getUrl(), request, String.class);
    }
}
