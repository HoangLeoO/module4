package org.example.bai_tap.service;

import org.example.bai_tap.model.Product;

import java.util.List;

public interface IService {
    List<Product> getAll();

    Product getById(int id);

    void save(Product product);

    void update(int id, Product product);

    void remove(int id);

}
