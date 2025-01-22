package com.haiilo.supermarket_checkout.domain.item;

import com.haiilo.supermarket_checkout.domain.offer.Offer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Offer> offers;
}