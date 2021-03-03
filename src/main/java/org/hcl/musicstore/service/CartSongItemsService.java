package org.hcl.musicstore.service;

import java.util.Optional;

import org.hcl.musicstore.model.CartSongItems;
import org.hcl.musicstore.model.Category;
import org.hcl.musicstore.repository.CartSongItemsCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartSongItemsService {
	private static Logger logger = LoggerFactory.getLogger(CartSongItemsService.class);
	
	@Autowired
	CartSongItemsCrudRepository cartSongItemsCrudRepository;
	
	public Iterable<CartSongItems> getAllCartSong(){
        return cartSongItemsCrudRepository.findAll();
    }
	
	public Optional<CartSongItems> getCartSongItems(int id) throws Exception {
		Optional<CartSongItems> cartSongItem = cartSongItemsCrudRepository.findById(id);
		
		if(cartSongItem != null) {
			logger.info("cartSongItem: "+cartSongItem.toString());
			return cartSongItem;
		}
		
		logger.error("cartSongItem is null");
		throw new Exception("Cart Song Item not found");
		
	}

}
