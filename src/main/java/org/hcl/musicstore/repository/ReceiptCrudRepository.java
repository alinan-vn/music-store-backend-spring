package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Receipt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReceiptCrudRepository extends CrudRepository<Receipt, Integer> {
    public List<Receipt> findReceiptByCustomerId(int id);
}
