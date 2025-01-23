package com.haiilo.supermarket_checkout.domain.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;
    private final CartMapper cartMapper;

    @Autowired
    public CartController(CartService cartService, CartMapper cartMapper) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }

    @GetMapping
    public ResponseEntity<CartDto> getCurrentCart() {
        return ResponseEntity.ok(cartMapper.map(cartService.getCurrentCart()));
    }

    @PostMapping("item/{itemId}")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable final long itemId) {
        return ResponseEntity.ok(cartMapper.map(cartService.addItem(itemId)));
    }
}
