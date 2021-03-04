package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartCrudRepository extends CrudRepository<ShoppingCart, Integer> {
	public ShoppingCart findShoppingCartById(Integer id);
}
