package org.example.bai_tap.service;

import org.example.bai_tap.model.Product;
import org.example.bai_tap.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IService{
    @Autowired
    private IRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void update(int id, Product product) {
        repository.update(id, product);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
