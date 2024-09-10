package com.banking.Banking.entity;

import jakarta.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    private String cityName;

    // Getters and Setters
}