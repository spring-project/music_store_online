package com.music.store.services.impl;

import com.music.store.daos.ProductDao;
import com.music.store.entities.Product;
import com.music.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    
    @Transactional
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Transactional
    public Product findId(long id) {
        return productDao.findId(id);
    }

    @Transactional
    public Product findBy(String field, Object value) {
        return productDao.findBy(field, value);
    }

    @Transactional
    public List<Product> search(String keyword) {
        return productDao.search(keyword);
    }

    @Transactional
    public boolean insert(Product product) {
        return productDao.insert(product);
    }

    @Transactional
    public boolean update(Product product) {
        return productDao.update(product);
    }

    @Transactional
    public boolean delete(Product product) {
        return productDao.delete(product);
    }
}
