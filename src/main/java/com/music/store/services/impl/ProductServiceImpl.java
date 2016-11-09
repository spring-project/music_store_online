package com.music.store.services.impl;

import com.music.store.daos.ProductDao;
import com.music.store.entities.Product;
import com.music.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    
    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findId(long id) {
        return productDao.findId(id);
    }

    public Product findBy(String field, Object value) {
        return productDao.findBy(field, value);
    }

    public List<Product> search(String keyword) {
        return productDao.search(keyword);
    }

    public void insert(Product product) {
        productDao.insert(product);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public void delete(Product product) {
        productDao.delete(product);
    }
}
