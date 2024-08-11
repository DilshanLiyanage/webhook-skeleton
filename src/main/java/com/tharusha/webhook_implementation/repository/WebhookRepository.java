package com.tharusha.webhook_implementation.repository;

import com.tharusha.webhook_implementation.entity.Webhook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebhookRepository extends JpaRepository<Webhook, Long> {

}
