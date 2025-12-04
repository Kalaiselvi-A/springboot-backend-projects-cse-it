package com.tnsif.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.bookstore.entity.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long> {

}
