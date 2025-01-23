package com.haiilo.supermarket_checkout.domain.item;

import com.haiilo.supermarket_checkout.dto.ItemWithOffersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @GetMapping
    public ResponseEntity<List<ItemWithOffersDto>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems()
                .stream()
                .map(itemMapper::mapWithActiveOffers)
                .toList()
        );
    }

}