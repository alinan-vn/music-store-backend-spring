package org.hcl.musicstore.controller;


import org.hcl.musicstore.model.Category;
import org.hcl.musicstore.model.ConditionType;
import org.hcl.musicstore.service.ConditionTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConditionTypeController {
	private static Logger logger = LoggerFactory.getLogger(ConditionTypeController.class);
	
	@Autowired
	ConditionTypeService conditionTypeService;
	
	@GetMapping("/showallconditiontype")
	public Iterable<ConditionType> showAllCategory(){
		return conditionTypeService.getAllConditionType();
	}
	
	@PostMapping("/saveconditiontype")
	public ResponseEntity<ConditionType> saveCategory(@RequestBody ConditionType conditionType){
		conditionTypeService.saveConditionType(conditionType);
		return new ResponseEntity<ConditionType>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteconditiontype/{id}")
	public ResponseEntity<String> deleteConditionType(@PathVariable Integer id) throws Exception{
		logger.info("Deleting ConditionType with id: "+ id);
		boolean isRemoved = conditionTypeService.deleteConditionTypeById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
	@PutMapping("/updatecondition/{id}")
	public ResponseEntity<Category> updateConditionType(@PathVariable Integer id, @RequestBody ConditionType conditionType) throws Exception{
		logger.info("Updating conditionType to: "+ conditionType.toString());
		
		ConditionType editedConditionType = conditionTypeService.findConditionTypeById(id);
		editedConditionType.setCondition_name(conditionType.getCondition_name());
		conditionTypeService.updateConditionType(editedConditionType);
		
		return new ResponseEntity<Category>(HttpStatus.OK);
	}
}