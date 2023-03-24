package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private float price;
    private String description;
    private String imgUrl;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Cart cart;
}
