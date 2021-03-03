package org.hcl.musicstore.service;

import org.hcl.musicstore.model.FormatType;
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
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartCrudRepository.save(shoppingCart);
    }

    public void deleteShoppingCart(ShoppingCart shoppingCart){
         shoppingCartCrudRepository.delete(shoppingCart);
    }
}
