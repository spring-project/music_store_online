package com.music.store.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.music.store.daos.ProductDao;
import com.music.store.entities.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	public List<Product> findAll() {
		return null;
	}

    public Product findId(long id) {
        return null;
    }

    public Product findBy(String field, Object value) {
        return null;
    }

    public List<Product> search(String keyword) {
        return null;
    }

    public boolean insert(Product product) {
        return false;
    }

    public boolean update(Product product) {
        return false;
    }

    public boolean delete(Product product) {
        return false;
    }
}
