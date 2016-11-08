package com.music.store.services;

import com.music.store.entities.Product;

import java.util.List;

public interface ProductService {
    public Product findId(long id);
    public Product findBy(String field, Object value);
    public List<Product> findAll();
    public List<Product> search(String keyword);
    public boolean insert(Product product);
    public boolean update(Product product);
    public boolean delete(Product product);
}
