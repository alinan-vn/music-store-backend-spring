package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.ConditionType;
import org.springframework.data.repository.CrudRepository;

public interface ConditionCrudRepository extends CrudRepository<ConditionType, Integer> {
}
