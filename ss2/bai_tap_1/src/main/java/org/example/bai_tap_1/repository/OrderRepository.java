package org.example.bai_tap_1.repository;

import org.example.bai_tap_1.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository implements IOrderRepository{

    private final static List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public boolean add(Order order) {
        return orders.add(order);
    }
}
