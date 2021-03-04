package org.hcl.musicstore.controller;

import java.util.List;
import java.util.Optional;

import org.hcl.musicstore.model.Album;
import org.hcl.musicstore.model.Receipt;
import org.hcl.musicstore.service.ReceiptService;
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
public class ReceiptController {
	private static Logger logger = LoggerFactory.getLogger(ReceiptController.class);
	
	@Autowired
	ReceiptService receiptService;

	@PostMapping("/savereceipt")
	public ResponseEntity<Receipt> saveReceipt(@RequestBody Receipt receipt){
		receiptService.saveReceipt(receipt);
		return new ResponseEntity<Receipt>(HttpStatus.OK);
	}
	
	@GetMapping("/receipt/{id}")
	public ResponseEntity<Receipt> getReceiptById(@PathVariable Integer id) throws Exception{
		Optional<Receipt> receipt = receiptService.getReceiptById(id);
		
		return receipt.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/findcustomerrecipts/{customer_id}")
	public List<Receipt> searchCustomerReceiptsByCustomerId(@PathVariable Integer customerId) throws Exception {
		return receiptService.findReceiptByCustomerId(customerId);
	}
	
	@DeleteMapping("/deletereceipt/{id}")
	public ResponseEntity<String> deleteReceipt(@PathVariable Integer id) throws Exception{
		logger.info("Deleting receipt with id: "+ id);
		boolean isRemoved = receiptService.deleteReceiptById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
	@PutMapping("/updatereceipt/{id}")
	public ResponseEntity<Receipt> updateReceipt(@PathVariable Integer id, @RequestBody Receipt receipt) throws Exception{
		logger.info("Updating receipt to: "+ receipt.toString());
		
		Receipt editedReceipt = receiptService.findReceiptById(id);
		editedReceipt.setReceiptName(receipt.getReceiptName());
		receiptService.updateReceipt(editedReceipt);
		
		return new ResponseEntity<Receipt>(HttpStatus.OK);
	}
	
}
