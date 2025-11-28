package org.example.bai_tap_1.service;

import org.example.bai_tap_1.entity.Order;
import org.example.bai_tap_1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private  OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public boolean add(Order order) {
        return orderRepository.add(order);
    }
}
