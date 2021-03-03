package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Genre;
import org.hcl.musicstore.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    public Optional<Product> getProductByCategoryId(int category_id);
}
