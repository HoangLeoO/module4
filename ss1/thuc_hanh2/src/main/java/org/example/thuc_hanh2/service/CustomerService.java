package org.example.thuc_hanh2.service;

import org.example.thuc_hanh2.entity.Customer;
import org.example.thuc_hanh2.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public boolean add(Customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public boolean edit(Customer customer) {
        return customerRepository.edit(customer);
    }

    @Override
    public boolean delete(Integer id) {
        return customerRepository.delete(id);
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.getById(id);
    }
}
