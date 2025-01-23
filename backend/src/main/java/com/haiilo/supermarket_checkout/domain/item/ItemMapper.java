package com.haiilo.supermarket_checkout.domain.item;

import com.haiilo.supermarket_checkout.domain.offer.Offer;
import com.haiilo.supermarket_checkout.domain.offer.OfferDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    ItemWithOffersDto mapWithActiveOffers(Item item) {
        return new ItemWithOffersDto(item.getId(), item.getName(), item.getPrice(), item.getOffers()
                .stream()
                .filter(Offer::isActive)
                .map(offer -> new OfferDto(offer.getPieces(), offer.getBundlePrice()))
                .toList()
        );
    }
}
