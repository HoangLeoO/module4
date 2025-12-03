package org.example.demo.service;

import org.example.demo.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean save(Product product);
    Product findById(Integer id);
    boolean update(Integer id, Product product);
    boolean deleteById(Integer id);
}
