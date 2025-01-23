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
        var cart = cartService.getCurrentCart();
        if (cart == null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(cartMapper.map(cart));
    }

    @PostMapping("item/{itemId}")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable final long itemId) {
        return ResponseEntity.ok(cartMapper.map(cartService.addItem(itemId)));
    }

    @DeleteMapping("item/{itemId}")
    public ResponseEntity<CartDto> removeItemFromCart(@PathVariable final long itemId) {
        return ResponseEntity.ok(cartMapper.map(cartService.removeItem(itemId)));
    }

    @PutMapping()
    public ResponseEntity<Void> payCart() {
        cartService.payCart();
        return ResponseEntity.ok().build();
    }
}
