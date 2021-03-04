package org.hcl.musicstore.controller;

import java.util.Optional;

import org.hcl.musicstore.model.Album;
import org.hcl.musicstore.model.ShoppingCart;
import org.hcl.musicstore.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {
	private static Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	
	@Autowired
	ShoppingCartService shoppingCartService;

	@PostMapping("/saveshoppingcart")
	public ResponseEntity<ShoppingCart> saveAlbum(@RequestBody ShoppingCart shoppingCart){
		shoppingCartService.saveAndUpdateShoppingCart(shoppingCart);
		return new ResponseEntity<ShoppingCart>(HttpStatus.OK);
	}
	
	@GetMapping("/shoppingcart/{id}")
	public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable Integer id) throws Exception{
		Optional<ShoppingCart> shoppingCart = shoppingCartService.getShoppingCart(id);
		
		return shoppingCart.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	
	@DeleteMapping("/deleteshoppingcart/{id}")
	public ResponseEntity<String> deleteShoppingcart(@PathVariable Integer id) throws Exception{
		logger.info("Deleting shopping cart with id: "+ id);
		boolean isRemoved = shoppingCartService.deleteShoppingById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
}