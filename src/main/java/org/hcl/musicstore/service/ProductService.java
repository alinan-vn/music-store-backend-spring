package org.hcl.musicstore.service;

import org.hcl.musicstore.model.Product;
import org.hcl.musicstore.repository.ProductCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
	private static Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductCrudRepository productCrudRepository;

	public Iterable<Product> findAllProduct() {

		return productCrudRepository.findAll();
	}

	public Optional<Product> findProductById(int id) throws Exception {
		Optional<Product> product = productCrudRepository.findById(id);

		if (product != null) {
			logger.info("product: " + product.toString());
			return product;
		}

		logger.error("product is null");
		throw new Exception("product with " + id + " doesn't exist");

	}

	public Product addProduct(Product product) {
		return productCrudRepository.save(product);
	}

	public boolean deleteProductById(Integer id) throws Exception {
		logger.info("deleting product with id: " + id);
		if (productCrudRepository.existsById(id)) {
			productCrudRepository.deleteById(id);
			return true;
		}

		logger.error("product is null");
		throw new Exception("Product not found");
	}

	public Product findByProductName(String name) throws Exception {

		Product product = productCrudRepository.findByProductName(name);

		if (product != null) {
			logger.info("album: " + product.toString());
			return product;
		}

		logger.error("product is null");
		throw new Exception("Product not found");
	}

}
