package com.haiilo.supermarket_checkout.domain.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {

    private List<CartItemDto> items;

    private double total;
}
