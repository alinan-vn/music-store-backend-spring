package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.CartProductItems;
import org.springframework.data.repository.CrudRepository;

public interface CartProductItemsCrudRepository extends CrudRepository<CartProductItems, Integer> {
}
