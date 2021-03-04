package org.hcl.musicstore.controller;

import org.hcl.musicstore.model.Category;
import org.hcl.musicstore.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {
	private static Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/showallcategory")
	public Iterable<Category> showAllCategory(){
		return categoryService.getAllCategory();
	}
	
	@PostMapping("/savecategory")
	public ResponseEntity<Category> saveCategory(@RequestBody Category category){
		categoryService.saveCategory(category);
		return new ResponseEntity<Category>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecategory/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer id) throws Exception{
		logger.info("Deleting Category with id: "+ id);
		boolean isRemoved = categoryService.deleteCategoryById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
}
