package com.tnsif.bookstore.controller;

import com.tnsif.bookstore.entity.CartItem;
import com.tnsif.bookstore.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // ADD TO CART
    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long bookId,
                              @RequestParam int quantity) {
        return cartService.addToCart(bookId, quantity);
    }

    // GET ALL CART ITEMS
    @GetMapping
    public List<CartItem> getCart() {
        return cartService.getCartItems();
    }

    // REMOVE ITEM
    @DeleteMapping("/{id}")
    public String removeItem(@PathVariable Long id) {
        cartService.removeCartItem(id);
        return "Cart item removed!";
    }

    // CLEAR CART
    @DeleteMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "Cart cleared!";
    }
}
