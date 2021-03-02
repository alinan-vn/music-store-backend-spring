package org.hcl.musicstore.repository;


import org.hcl.musicstore.model.Receipt;
import org.springframework.data.repository.CrudRepository;

public interface ReceiptCrudRepository extends CrudRepository<Receipt, Integer> {
}
