package org.hcl.musicstore.controller;

import org.hcl.musicstore.model.CartSongItems;
import org.hcl.musicstore.service.CartSongItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CartSongItemsController {
	private static Logger logger = LoggerFactory.getLogger(CartSongItemsController.class);
	
	@Autowired
	CartSongItemsService cartSongItemsService;
	
	@PostMapping("/savecartsongitems")
	public ResponseEntity<CartSongItems> saveCartSongItems(@RequestBody CartSongItems cartSongItems){
		logger.info("Saving cartSongItems: "+ cartSongItems.toString());
		cartSongItemsService.saveCartSongItems(cartSongItems);
		return new ResponseEntity<CartSongItems>(HttpStatus.OK);
	}
	
	@PutMapping("/updatecartsongs/{id}")
	public ResponseEntity<CartSongItems> updateCartProductItems(@PathVariable Integer id, @RequestBody CartSongItems cartSongItems) throws Exception{
		logger.info("Updating cartSongItems: "+ cartSongItems.toString());
		CartSongItems editedCartSongItems = cartSongItemsService.findCartSongItemsById(id);
		editedCartSongItems.setQuantity(cartSongItems.getQuantity());
		cartSongItemsService.updateCartSongItems(editedCartSongItems);
		return new ResponseEntity<CartSongItems>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecartsong/{id}")
	public ResponseEntity<String> deleteCartSongItem(@PathVariable Integer id) throws Exception{
		logger.info("Deleting cartSongItem with id: "+ id);
		boolean isRemoved = cartSongItemsService.deleteCartSongItemById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
}
