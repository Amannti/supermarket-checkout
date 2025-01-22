package com.haiilo.supermarket_checkout.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OfferDto {

    private int pieces;
    private double bundlePrice;
}
