package org.example.thuc_hanh2.service;

import org.example.thuc_hanh2.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    boolean add(Customer customer);
    boolean edit(Customer customer);
    boolean delete(Integer id);
    Customer getById(Integer id);
}
