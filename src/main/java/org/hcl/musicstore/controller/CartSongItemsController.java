package org.hcl.musicstore.controller;

import javax.validation.Valid;

import org.hcl.musicstore.model.CartSongItems;
import org.hcl.musicstore.service.CartSongItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CartSongItemsController {
	
	@Autowired
	CartSongItemsService cartSongItemsService;
	
	@PostMapping("/savecartsongitems")
	public CartSongItems addCartProductItems(@Valid @RequestBody CartSongItems cartSongItems) {
		return cartSongItemsService.saveCartSongItems(cartSongItems);
	}
	
}
