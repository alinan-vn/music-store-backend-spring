package org.hcl.musicstore.controller;

import org.hcl.musicstore.model.CartProductItems;
import org.hcl.musicstore.service.CartProductItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CartProductItemsController {
	private static Logger logger = LoggerFactory.getLogger(CartProductItemsController.class);
	
	@Autowired
	CartProductItemsService cartProductItemsService;
	
	@PostMapping("/savecartproducts")
	public ResponseEntity<CartProductItems> saveCartProductItems(@RequestBody CartProductItems cartProductItems){
		logger.info("Saving cartProductItems: "+ cartProductItems.toString());
		cartProductItemsService.saveCartProducts(cartProductItems);
		return new ResponseEntity<CartProductItems>(HttpStatus.OK);
	}
	
	@PutMapping("/updatecartproducts/{id}")
	public ResponseEntity<CartProductItems> updateCartProductItems(@PathVariable Integer id, @RequestBody CartProductItems cartProductItems) throws Exception{
		logger.info("Updating cartProductItems: "+ cartProductItems.toString());
		CartProductItems edittedCartProductItems = cartProductItemsService.findCartProductItemsById(id);
		edittedCartProductItems.setQuantity(cartProductItems.getQuantity());
		cartProductItemsService.updateCartProductItems(edittedCartProductItems);
		return new ResponseEntity<CartProductItems>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecartproductitems/{id}")
	public ResponseEntity<String> deleteCartProductItem(@PathVariable Integer id) throws Exception{
		logger.info("Deleting cartProductItem with id: "+ id);
		boolean isRemoved = cartProductItemsService.deleteCartProductItemById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
}
