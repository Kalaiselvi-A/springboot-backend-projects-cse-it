package com.tnsif.bookstore.service;

import com.tnsif.bookstore.entity.Book;
import com.tnsif.bookstore.entity.CartItem;
import com.tnsif.bookstore.repository.BookRepository;
import com.tnsif.bookstore.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final BookRepository bookRepository;

    public CartService(CartRepository cartRepository, BookRepository bookRepository) {
        this.cartRepository = cartRepository;
        this.bookRepository = bookRepository;
    }

    // ADD TO CART
    public CartItem addToCart(Long bookId, int quantity) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book ID not found"));

        CartItem item = new CartItem();
        item.setBook(book);
        item.setQuantity(quantity);

        return cartRepository.save(item);
    }

    // GET ALL ITEMS
    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    // REMOVE SINGLE ITEM
    public void removeCartItem(Long id) {
        cartRepository.deleteById(id);
    }

    // CLEAR ALL ITEMS
    public void clearCart() {
        cartRepository.deleteAll();
    }
}
