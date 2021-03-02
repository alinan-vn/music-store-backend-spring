package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
}
