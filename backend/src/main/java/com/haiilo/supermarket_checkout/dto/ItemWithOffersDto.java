package com.haiilo.supermarket_checkout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ItemWithOffersDto {

    private long id;
    private String name;
    private double price;
    private List<OfferDto> offers;
}
