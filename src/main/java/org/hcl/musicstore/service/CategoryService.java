package org.hcl.musicstore.service;

import java.util.Optional;

import org.hcl.musicstore.model.Category;
import org.hcl.musicstore.repository.CategoryCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	private static Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	@Autowired
	CategoryCrudRepository categoryCrudRepository;
	
	public Category findCategoryById(int id) {
		return categoryCrudRepository.findCategoryById(id);
	}
	
	public Iterable<Category> getAllCategory(){
        return categoryCrudRepository.findAll();
    }
	
	public Optional<Category> getCategory(int id) throws Exception {
		Optional<Category> category = categoryCrudRepository.findById(id);
		
		if(category != null) {
			logger.info("category: "+category.toString());
			return category;
		}
		
		logger.error("category is null");
		throw new Exception("Category not found");
	}
	
	public Category saveCategory(Category category) {
		return categoryCrudRepository.save(category);
	}
	
	public boolean deleteCategoryById(Integer id) throws Exception{
		logger.info("deleting Category with id: "+id);
		if(categoryCrudRepository.existsById(id)) {
			categoryCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("Category is null");
		throw new Exception("Category not found");
    }
	
	public Category updateCategory(Category category) {
		return categoryCrudRepository.save(category);
	}
}
