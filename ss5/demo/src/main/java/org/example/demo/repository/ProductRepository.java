package org.example.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.demo.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("FROM Product p", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public boolean save(Product product) {
        entityManager.persist(product);
        return false;
    }

    @Override
    public Product findById(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public boolean update(Integer id, Product product) {
        try {
            Product productDB = findById(id);
            productDB.setName(product.getName());
            productDB.setPrice(product.getPrice());
            entityManager.merge(productDB);
            return true;
        }catch (Exception e){}

        return false;
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        try {
            Product productDB = findById(id);
            entityManager.remove(productDB);
            return true;
        }catch (Exception e){}

        return false;
    }
}
