package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<Customer, Integer> {
    public Customer findCustomerByUsername(String username);
    public Customer findCustomerById(Integer id);
}
