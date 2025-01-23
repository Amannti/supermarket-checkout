package com.haiilo.supermarket_checkout.domain.cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartItem {

    private Long itemId;

    private double price;

    private int pieces;

    private List<Long> usedOfferIds;

    private double totalWithoutOffers;

    private double total;
}

