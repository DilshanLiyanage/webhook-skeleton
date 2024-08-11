package com.tharusha.webhook_implementation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flights")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightName;
    private String airLineName;
}
