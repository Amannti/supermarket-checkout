package com.haiilo.supermarket_checkout.domain.cart;

import com.haiilo.supermarket_checkout.domain.item.ItemService;
import com.haiilo.supermarket_checkout.domain.offer.Offer;
import com.haiilo.supermarket_checkout.domain.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    private final ItemService itemService;
    private final OfferService offerService;

    @Autowired
    public CartService(CartRepository cartRepository, ItemService itemService, OfferService offerService) {
        this.cartRepository = cartRepository;
        this.itemService = itemService;
        this.offerService = offerService;
    }

    public Cart getCurrentCart() {
        return this.cartRepository.findByPaidIsFalse();
    }

    public Cart addItem(Long itemId) {
        var cart = this.cartRepository.findByPaidIsFalse();
        if (cart == null) {
            cart = new Cart();
        }

        var itemOpt = cart.getItems()
                .stream()
                .filter(item -> item.getItemId().equals(itemId))
                .findFirst();

        if (itemOpt.isPresent()) {
            var item = itemOpt.get();
            item.setPieces(itemOpt.get().getPieces() + 1);
        } else {
            var item = itemService.getItemById(itemId);
            if (item == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item " + itemId + " not found");
            }

            cart.getItems().add(new CartItem(
                    item.getId(),
                    item.getPrice(),
                    1,
                    List.of(),
                    0,
                    0
            ));
        }

        calculateTotal(cart);

        return this.cartRepository.save(cart);
    }

    public Cart removeItem(Long itemId) {
        var cart = this.cartRepository.findByPaidIsFalse();
        if (cart == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found");
        }

        var itemToRemoveOpt = cart.getItems()
                .stream()
                .filter(item -> item.getItemId().equals(itemId))
                .findFirst();

        if (itemToRemoveOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item " + itemId + " not found");
        }

        var itemToRemove = itemToRemoveOpt.get();
        if (itemToRemove.getPieces() == 1) {
            cart.getItems().remove(itemToRemove);
        } else {
            itemToRemove.setPieces(itemToRemove.getPieces() - 1);
        }

        calculateTotal(cart);

        return this.cartRepository.save(cart);
    }

    private void calculateTotal(Cart cart) {
        double total = 0;
        var offers = offerService.findAll();
        for (CartItem item : cart.getItems()) {
            calculatePriceForItem(offers
                    .stream()
                    .filter(offer -> offer.getItem().getId().equals(item.getItemId()))
                    .toList(), item);
            total += item.getTotal();
        }

        cart.setTotal(total);
    }

    private void calculatePriceForItem(List<Offer> offers, CartItem item) {
        double totalForItem = 0;
        item.setUsedOfferIds(new ArrayList<>());
        var pieces = item.getPieces();

        for (Offer offer : offers) {
            if (offer.getPieces() <= pieces) { // ToDo what is if you have the same offer twice regarding to the pieces
                totalForItem += offer.getBundlePrice();
                pieces -= offer.getPieces();
                item.getUsedOfferIds().add(offer.getId());
            }
        }

        if (pieces > 0) {
            totalForItem += (pieces * item.getPrice());
        }

        item.setTotalWithoutOffers(item.getPieces() * item.getPrice());
        item.setTotal(totalForItem);
    }
}
