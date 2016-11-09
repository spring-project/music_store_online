package com.music.store.daos.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.music.store.daos.ProductDao;
import com.music.store.entities.Product;

@Repository
public class ProductDaoImpl implements ProductDao {


	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public List<Product> findAll() {
		String hql = "from Product order by id desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
	}

    public Product findId(long id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @SuppressWarnings({ "rawtypes", "deprecation" })
    public Product findBy(String field, Object value) {
    	String hql = "from Product where " + field + " = :field";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("field", value);
        return (Product) query.uniqueResult();
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
    public List<Product> search(String keyword) {
    	String hql = "from Product where name like :key order by id desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("key", "%" + keyword + "%");
        return query.list();
    }

    public void insert(Product product) {
        sessionFactory.getCurrentSession().persist(product);
    }

    public void update(Product product) {
    	sessionFactory.getCurrentSession().update(product);
    }

    public void delete(Product product) {
    	sessionFactory.getCurrentSession().delete(product);
    }
}
