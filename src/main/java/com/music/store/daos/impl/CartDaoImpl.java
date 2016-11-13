package com.music.store.daos.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.music.store.daos.CartDao;
import com.music.store.entities.Cart;

@Repository
public class CartDaoImpl implements CartDao {
	private Map<String, Cart> listCards;
	
	public CartDaoImpl() {
		this.listCards = new HashMap<String, Cart>();
	}
	
	@Override
	public Cart create(Cart card) {
//		if (listCards.containsKey(card.getCardId())) {
		String cardId = card.getCartId();
		if (listCards.keySet().contains(cardId)) {
			throw new IllegalArgumentException(
				String.format("Cannot create cart. The card id (%) already exists.", cardId)
			);
		}
		listCards.put(cardId, card);
		return card;
	}

	@Override
	public Cart read(String cardId) {
		return listCards.get(cardId);
	}

	@Override
	public void update(String cardId, Cart card) {
		if (!listCards.keySet().contains(cardId)) {
			throw new IllegalArgumentException(
				String.format("Cannot update cart. The card id (%) doesn't exists.", cardId)
			);
		}
		listCards.put(cardId, card);
	}

	@Override
	public void delete(String cardId) {
		if (!listCards.keySet().contains(cardId)) {
			throw new IllegalArgumentException(
				String.format("Cannot delete cart. The card id (%) doesn't exists.", cardId)
			);
		}
		listCards.remove(cardId);
	}

}
