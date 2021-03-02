package org.hcl.musicstore.repository;


import org.hcl.musicstore.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
