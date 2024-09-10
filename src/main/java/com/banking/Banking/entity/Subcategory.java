package com.banking.Banking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subcategoryId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String subcategoryName;

    // Getters and Setters
}