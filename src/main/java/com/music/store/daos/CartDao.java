package com.music.store.daos;

import com.music.store.entities.Cart;

public interface CartDao {
	public Cart create(Cart cart);
	public Cart read(String cartId);
	public void update(String cartId, Cart cart);
	public void delete(String cartId);
}
