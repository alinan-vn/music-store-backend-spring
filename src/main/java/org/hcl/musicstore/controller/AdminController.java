package org.hcl.musicstore.controller;

import org.hcl.musicstore.model.Admin;
import org.hcl.musicstore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping(value="/admin/login")
	public ResponseEntity<?> adminLogin(@RequestParam String username, @RequestParam String password){
		
		Admin admin = adminService.findByUsername(username);
		
		if(adminService.validateAdmin(admin)) {
			if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
				return ResponseEntity.ok(admin);
			}
		}
		
		return ResponseEntity.badRequest().body("Invalid admin credentials");
	}

}






