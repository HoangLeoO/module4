package org.example.thuc_hanh2.repository;

import org.example.thuc_hanh2.entity.Customer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CustomerRepository implements ICustomerRepository {
    private static final List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Hoang", LocalDate.parse("2011-01-01"), "Ha Noi"));
        customerList.add(new Customer(2, "Khanh", LocalDate.parse("2011-01-01"), "Ha Noi"));
        customerList.add(new Customer(3, "Tung", LocalDate.parse("2011-01-01"), "Ha Noi"));
        customerList.add(new Customer(4, "Nguyen", LocalDate.parse("2011-01-01"), "Ha Noi"));
        customerList.add(new Customer(5, "Hoang", LocalDate.parse("2011-01-01"), "Ha Noi"));
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }

    @Override
    public boolean add(Customer customer) {
        return customerList.add(customer);
    }

    @Override
    public boolean edit(Customer customer) {
        if (customer == null) {
            return false;
        }
        customerList.set(customer.getId() - 1, customer);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        return customerList.remove(customerList.get(id - 1));
    }

    @Override
    public Customer getById(Integer id) {
        return customerList.get(id - 1);
    }
}
