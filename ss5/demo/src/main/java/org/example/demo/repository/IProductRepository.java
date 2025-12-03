package org.example.demo.repository;

import org.example.demo.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean save(Product product);
    Product findById(Integer id);
    boolean update(Integer id, Product product);
    boolean deleteById(Integer id);

}
