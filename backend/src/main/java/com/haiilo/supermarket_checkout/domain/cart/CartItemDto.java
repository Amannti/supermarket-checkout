package com.haiilo.supermarket_checkout.domain.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemDto {

    private long itemId;

    private String itemName;

    private double price;

    private int pieces;

    private double totalWithoutOffers;

    private double total;
}
