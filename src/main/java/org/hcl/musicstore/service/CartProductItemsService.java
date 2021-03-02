package org.hcl.musicstore.service;

import java.util.Optional;

import org.hcl.musicstore.model.CartProductItems;
import org.hcl.musicstore.repository.CartProductItemsCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartProductItemsService {
	private static Logger logger = LoggerFactory.getLogger(CartProductItemsService.class);
	
	@Autowired
	CartProductItemsCrudRepository cartProductItemsCrudRepository;
	
	public Optional<CartProductItems> getCartProductItems(int id) throws Exception {
		Optional<CartProductItems> cartProductItems = cartProductItemsCrudRepository.findById(id);
		
		if(cartProductItems!=null) {
			logger.info("cartProductItems: "+cartProductItems.toString());
			return cartProductItems;
		}
		
		logger.error("cartProductItems is null");
		throw new Exception("Cart Product Item not found");
		
		
	}

}
