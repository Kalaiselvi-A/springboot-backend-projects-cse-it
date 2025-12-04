package com.tnsif.bookstore.service;

import com.tnsif.bookstore.entity.CartItem;
import com.tnsif.bookstore.entity.Order;
import com.tnsif.bookstore.repository.CartRepository;
import com.tnsif.bookstore.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    // PLACE ORDER
    public Order placeOrder() {

        List<CartItem> items = cartRepository.findAll();

        if (items.isEmpty()) {
            throw new RuntimeException("Cart is empty! Cannot place order.");
        }

        double total = items.stream()
                .mapToDouble(i -> i.getBook().getPrice() * i.getQuantity())
                .sum();

        Order order = new Order();
        order.setItems(items);
        order.setTotalAmount(total);
        order.setOrderDate(LocalDate.now());

        Order savedOrder = orderRepository.save(order);

        // Clear cart after order
        cartRepository.deleteAll();

        return savedOrder;
    }

    // GET ALL ORDERS
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
