package org.example.bai_tap_1.service;

import org.example.bai_tap_1.entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();
    boolean add(Order order);
}
