package com.haiilo.supermarket_checkout.domain.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class OfferMapper {

    private OfferService offerService;

    @Autowired
    public OfferMapper(OfferService offerService) {
        this.offerService = offerService;
    }

    public OfferDto map(final Offer offer) {
        return new OfferDto(offer.getPieces(), offer.getBundlePrice());
    }

    public OfferDto mapById(final long id) {
        var offer = offerService.findById(id);
        if (offer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Offer " + id + " not found");
        }

        return map(offer);
    }
}
