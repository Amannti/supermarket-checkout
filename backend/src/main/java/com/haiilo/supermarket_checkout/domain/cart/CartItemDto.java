package com.haiilo.supermarket_checkout.domain.cart;

import com.haiilo.supermarket_checkout.domain.offer.OfferDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartItemDto {

    private long itemId;

    private String itemName;

    private double price;

    private int pieces;

    private List<OfferDto> userOffers;
}
