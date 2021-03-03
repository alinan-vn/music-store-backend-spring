package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Receipt;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReceiptCrudRepository extends CrudRepository<Receipt, Integer> {
    public Optional<Receipt> getReceiptByCustomerId(int customer_id);
}
