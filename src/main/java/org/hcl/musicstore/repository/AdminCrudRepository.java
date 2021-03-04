package org.hcl.musicstore.repository;

import org.hcl.musicstore.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin, Integer> {

	public Admin findByUsername(String username);
	public Admin findAdminById(Integer id);
}
