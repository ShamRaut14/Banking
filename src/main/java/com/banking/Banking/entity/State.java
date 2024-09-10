package com.banking.Banking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private String stateName;

    // Getters and Setters
}