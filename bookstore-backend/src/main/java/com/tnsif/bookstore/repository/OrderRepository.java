package com.tnsif.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.bookstore.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
