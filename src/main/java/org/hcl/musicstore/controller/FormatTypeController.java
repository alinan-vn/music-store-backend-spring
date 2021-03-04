package org.hcl.musicstore.controller;

import java.util.Optional;

import org.hcl.musicstore.model.FormatType;
import org.hcl.musicstore.service.FormatTypeService;
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
public class FormatTypeController {
	private static Logger logger = LoggerFactory.getLogger(FormatTypeController.class);
	
	@Autowired
	FormatTypeService formatTypeService;

	@PostMapping("/saveformattype")
	public ResponseEntity<FormatType> saveFormatType(@RequestBody FormatType formatType){
		formatTypeService.saveFormatType(formatType);
		return new ResponseEntity<FormatType>(HttpStatus.OK);
	}
	
	@GetMapping("/formattype")
	public Iterable<FormatType> getFormatTypeDetails(){
		return formatTypeService.findAllFormatType();
	}
	
	@GetMapping("/album/{id}")
	public ResponseEntity<FormatType> getAlbumById(@PathVariable Integer id) throws Exception{
		Optional<FormatType> formatType = formatTypeService.findFormatTypeById(id);
		
		return formatType.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/deleteformattype/{id}")
	public ResponseEntity<String> deleteFormatType(@PathVariable Integer id) throws Exception{
		logger.info("Deleting format type with id: "+ id);
		boolean isRemoved = formatTypeService.deleteFormatTypeById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
}
