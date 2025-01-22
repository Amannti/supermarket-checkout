package com.haiilo.supermarket_checkout.domain.item;

import com.haiilo.supermarket_checkout.domain.offer.Offer;
import com.haiilo.supermarket_checkout.dto.ItemWithOffersDto;
import com.haiilo.supermarket_checkout.dto.OfferDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    ItemWithOffersDto mapWithActiveOffers(Item item) {
        return new ItemWithOffersDto(item.getId(), item.getName(), item.getPrice(), item.getOffers()
                .stream()
                .filter(Offer::isActive)  // ToDo Consider remove active for offers
                .map(offer -> new OfferDto(offer.getPieces(), offer.getBundlePrice()))
                .toList()
        );
    }
}
