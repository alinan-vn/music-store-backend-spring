package org.hcl.musicstore.service;

import java.util.Optional;

import org.hcl.musicstore.model.CartSongItems;
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
	
	public CartSongItems findCartSongItemsById(int id) {
		return cartSongItemsCrudRepository.findCartSongItemsById(id);
	}
	
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
	
	public CartSongItems saveCartSongItems(CartSongItems cartSongItems) {
		return cartSongItemsCrudRepository.save(cartSongItems);
	}
	
	public void updateCartSongItems(CartSongItems cartSongItems) {
		cartSongItemsCrudRepository.save(cartSongItems);
	}
	
	public boolean deleteCartSongItemById(Integer id) throws Exception{
		logger.info("deleting cartSongItem with id: "+id);
		if(cartSongItemsCrudRepository.existsById(id)) {
			cartSongItemsCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("CartSongItem is null");
		throw new Exception("CartSongItem not found");
    }

}
