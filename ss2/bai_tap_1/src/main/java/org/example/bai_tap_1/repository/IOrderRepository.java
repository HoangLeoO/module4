package org.example.bai_tap_1.repository;

import org.example.bai_tap_1.entity.Order;

import java.util.List;

public interface IOrderRepository {
    List<Order> getAll();
    boolean add(Order order);
}
