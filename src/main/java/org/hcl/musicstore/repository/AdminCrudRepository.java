package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminCrudRepository extends CrudRepository<Admin, Integer> {
    public Optional<Admin> findByUsername(String username);
}
