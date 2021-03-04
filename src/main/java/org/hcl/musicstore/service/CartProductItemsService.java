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
	
	public Iterable<CartProductItems> getAllCartProductItems(){
        return cartProductItemsCrudRepository.findAll();
    }
	
	public Optional<CartProductItems> getCartProductItems(int id) throws Exception {
		Optional<CartProductItems> cartProductItems = cartProductItemsCrudRepository.findById(id);
		
		if(cartProductItems!=null) {
			logger.info("cartProductItems: "+cartProductItems.toString());
			return cartProductItems;
		}
		
		logger.error("cartProductItems is null");
		throw new Exception("Cart Product Item not found");
	}
	
	public CartProductItems saveCartProducts(CartProductItems cartProductItems) {
		return cartProductItemsCrudRepository.save(cartProductItems);
	}
	
	public void updateCartProductItems(CartProductItems cartProductItems) throws Exception {
		if(cartProductItems!= null) {
			cartProductItemsCrudRepository.save(cartProductItems);
		}
		throw new Exception("Cannot find product");
		
	}
	
	public boolean deleteCartProductItemById(Integer id) throws Exception{
		logger.info("deleting cartProductItem with id: "+id);
		if(cartProductItemsCrudRepository.existsById(id)) {
			cartProductItemsCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("CartProductItem is null");
		throw new Exception("CartProductItem not found");
    }

}
