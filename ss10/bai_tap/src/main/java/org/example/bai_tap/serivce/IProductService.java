package org.example.bai_tap.serivce;

import org.example.bai_tap.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}