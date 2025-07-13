package com.example.ecommerce.service;

import com.example.ecommerce.model.*;
import com.example.ecommerce.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Order createOrder(String customerName, List<OrderItem> items) {
        double total = 0.0;
        for (OrderItem item : items) {
            Product product = productRepository.findById(item.getProduct().getId())
                .orElseThrow();
            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
            item.setProduct(product);
            total += product.getPrice() * item.getQuantity();
        }
        Order order = Order.builder()
                .customerName(customerName)
                .items(items)
                .totalAmount(total)
                .build();
        items.forEach(i -> i.setOrder(order));
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }
}

