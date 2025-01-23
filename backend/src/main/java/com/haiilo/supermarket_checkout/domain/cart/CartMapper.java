package com.haiilo.supermarket_checkout.domain.cart;

import com.haiilo.supermarket_checkout.domain.item.ItemService;
import com.haiilo.supermarket_checkout.domain.offer.OfferMapper;
import com.haiilo.supermarket_checkout.domain.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class CartMapper {

    private final ItemService itemService;
    private final OfferMapper offerMapper;

    @Autowired
    public CartMapper(ItemService itemService, OfferMapper offerMapper) {
        this.itemService = itemService;
        this.offerMapper = offerMapper;
    }

    CartDto map(Cart cart) {
        return new CartDto(cart.getItems().stream().map(this::mapItem).toList(), cart.getTotal());
    }

    CartItemDto mapItem(CartItem cartItem) {
        var item = itemService.getItemById(cartItem.getItemId());
        if (item == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item " + cartItem.getItemId() + " not found");
        }
        return new CartItemDto(cartItem.getItemId(), item.getName(), cartItem.getOriginPrice(), cartItem.getPieces(), cartItem.getUsedOfferIds()
                .stream()
                .map(offerMapper::mapById)
                .toList()
        );
    }

}
