package com.music.store.services;

import com.music.store.entities.Product;

import java.util.List;

public interface ProductService {
    public Product findId(long id);
    public Product findBy(String field, Object value);
    public List<Product> findAll();
    public List<Product> search(String keyword);
    public void insert(Product product);
    public void update(Product product);
    public void delete(Product product);
}
