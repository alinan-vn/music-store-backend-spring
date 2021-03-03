package org.hcl.musicstore.controller;


import javax.validation.Valid;


import org.hcl.musicstore.model.Admin;
import org.hcl.musicstore.repository.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    AdminCrudRepository adminCrudRepository;

    @PostMapping(value="/admin/login")
    public ResponseEntity<?> getAdmin(@RequestParam String username, @RequestParam String password ){
       if(adminCrudRepository.findByUsername())
    }
}






