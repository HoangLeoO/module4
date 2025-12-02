package org.example.bai_tap.repository;


import org.example.bai_tap.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IRepository{

    private static final List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "iPhone 13", 10000000));
        products.add(new Product(2, "iPhone 12", 8000000));
        products.add(new Product(3, "iPhone 11", 7000000));
        products.add(new Product(4, "iPhone SE", 6000000));
        products.add(new Product(5, "iPhone XR", 5000000));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        return products.get(id-1);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void update(int id, Product product) {
        products.set(id-1, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id-1);
    }
}
