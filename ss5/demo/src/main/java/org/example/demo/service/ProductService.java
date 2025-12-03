package org.example.demo.service;

import org.example.demo.entity.Product;
import org.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean update(Integer id, Product product) {
        return productRepository.update(id, product);
    }

    @Override
    public boolean deleteById(Integer id) {
        return productRepository.deleteById(id);
    }
}
