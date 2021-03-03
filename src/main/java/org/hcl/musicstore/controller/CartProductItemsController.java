package org.hcl.musicstore.controller;

import javax.validation.Valid;

import org.hcl.musicstore.model.CartProductItems;
import org.hcl.musicstore.service.CartProductItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CartProductItemsController {
	
	@Autowired
	CartProductItemsService cartProductItemsService;
	
	@PostMapping("/savecartproducts")
	public CartProductItems addCartProductItems(@Valid @RequestBody CartProductItems cartProductItems) {
		return cartProductItemsService.saveCartProducts(cartProductItems);
	}
	
}
