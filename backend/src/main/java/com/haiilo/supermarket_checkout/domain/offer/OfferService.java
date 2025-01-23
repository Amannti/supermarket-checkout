package com.haiilo.supermarket_checkout.domain.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> findAll() {
        return offerRepository.findAllByActiveIsTrueOrderByPiecesDesc();
    }

    public Offer findById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }
}
