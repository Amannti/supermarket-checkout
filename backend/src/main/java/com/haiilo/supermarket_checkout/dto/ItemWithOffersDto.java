package com.haiilo.supermarket_checkout.dto;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ItemWithOffersDto {

    private long id;
    private String name;
    private double price;
    private List<OfferDto> offers;
}
