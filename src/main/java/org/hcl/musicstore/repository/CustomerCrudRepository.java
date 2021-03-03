package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerCrudRepository extends CrudRepository<Customer, Integer> {

    public Optional<Customer> getByCustomerName(String name);
}
