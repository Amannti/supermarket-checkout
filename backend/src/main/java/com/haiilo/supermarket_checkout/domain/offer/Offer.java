package com.haiilo.supermarket_checkout.domain.offer;

import com.haiilo.supermarket_checkout.domain.item.Item;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private int pieces;

    private double bundlePrice;

    private boolean active;
}
