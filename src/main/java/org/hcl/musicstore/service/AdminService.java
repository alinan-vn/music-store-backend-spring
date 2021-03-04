package org.hcl.musicstore.service;

import org.hcl.musicstore.model.Admin;
import org.hcl.musicstore.repository.AdminCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
	private static Logger logger = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private AdminCrudRepository adminCrudRepository;

	public boolean validateAdmin(Admin admin) {
		logger.info("admin: "+ admin.toString());
		return adminCrudRepository.findById(admin.getId()) != null;
	}

	public Admin findByUsername(String username){
		return adminCrudRepository.findByUsername(username);
	}


}
