package org.hcl.musicstore.service;

import org.hcl.musicstore.model.ShoppingCart;
import org.hcl.musicstore.repository.ShoppingCartCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {
    private static  Logger logger = LoggerFactory.getLogger(ShoppingCartService.class);

    @Autowired
    ShoppingCartCrudRepository shoppingCartCrudRepository;
    
    public ShoppingCart findShoppingCartById(int id) {
    	return shoppingCartCrudRepository.findShoppingCartById(id);
    }

    public Iterable<ShoppingCart> getAllShoppingCart(){
        return shoppingCartCrudRepository.findAll();
    }

    public Optional<ShoppingCart> getShoppingCart(int id ) throws Exception {
        Optional<ShoppingCart> shoppingCart = shoppingCartCrudRepository.findById(id);
        if (shoppingCart != null) {
            logger.info("shoppingCart: " + shoppingCart.toString());
            return shoppingCart;
        }
        logger.error("shoppingCart is Null");
        throw new Exception("shoppingCart with " + id + " doesn't exist!");
    }
    
    public ShoppingCart saveAndUpdateShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartCrudRepository.save(shoppingCart);
    }

    public boolean deleteShoppingById(Integer id) throws Exception{
		logger.info("deleting shopping with id: "+id);
		if(shoppingCartCrudRepository.existsById(id)) {
			shoppingCartCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("shopping cart is null");
		throw new Exception("Shopping Cart not found");
    }
    
    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartCrudRepository.save(shoppingCart);
    }
}
