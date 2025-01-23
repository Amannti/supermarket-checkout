package com.haiilo.supermarket_checkout.domain.cart;

import com.haiilo.supermarket_checkout.domain.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class CartMapper {

    private final ItemService itemService;

    @Autowired
    public CartMapper(ItemService itemService) {
        this.itemService = itemService;
    }

    CartDto map(Cart cart) {
        return new CartDto(cart.getItems().stream().map(this::mapItem).toList(), cart.getTotal());
    }

    CartItemDto mapItem(CartItem cartItem) {
        var item = itemService.getItemById(cartItem.getItemId());
        if (item == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item " + cartItem.getItemId() + " not found");
        }
        return new CartItemDto(
                cartItem.getItemId(),
                item.getName(),
                cartItem.getPrice(),
                cartItem.getPieces(),
                cartItem.getTotalWithoutOffers(),
                cartItem.getTotal()
        );
    }

}
