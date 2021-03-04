package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.CartSongItems;
import org.springframework.data.repository.CrudRepository;

public interface CartSongItemsCrudRepository extends CrudRepository<CartSongItems, Integer> {
	public CartSongItems findCartSongItemsById(Integer id);
}
