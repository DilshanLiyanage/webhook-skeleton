package com.tharusha.webhook_implementation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "webhooks")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Webhook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String travelAgentId;

}
