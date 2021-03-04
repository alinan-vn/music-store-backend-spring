package org.hcl.musicstore.controller;

import java.util.Optional;

import org.hcl.musicstore.model.Album;
import org.hcl.musicstore.model.BillingInfo;
import org.hcl.musicstore.service.BillingInfoService;
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
public class BillingInfoController {
	private static Logger logger = LoggerFactory.getLogger(BillingInfoController.class);
	
	@Autowired
	BillingInfoService billingInfoService;
	
	@PostMapping("/savebillinginfo")
	public ResponseEntity<BillingInfo> saveBillingInfo(@RequestBody BillingInfo billingInfo) {
		
		logger.info(billingInfo.toString());
		billingInfoService.saveBillingInfo(billingInfo);
		return new ResponseEntity<BillingInfo>(HttpStatus.OK);
		
	}
	
	@GetMapping("/viewbillinginfo/{id}")
	public ResponseEntity<BillingInfo> showBillingInfo(@PathVariable Integer id) throws Exception {
		Optional<BillingInfo> billingInfo = billingInfoService.getBillingInfo(id);
		return billingInfo.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/deletebillinginfo/{id}")
	public ResponseEntity<String> deleteBillingInfo(@PathVariable Integer id) throws Exception{
		logger.info("Deleting billingInfo with id: "+ id);
		boolean isRemoved = billingInfoService.deleteBillingInfoById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
	@PutMapping("/updatebillinginfo/{id}")
	public ResponseEntity<BillingInfo> updateCartProductItems(@PathVariable Integer id, @RequestBody BillingInfo billingInfo) throws Exception{
		logger.info("Updating billingInfo to: "+ billingInfo.toString());
		
		BillingInfo editedBillingInfo = billingInfoService.findBillingInfoById(id);
		editedBillingInfo.setApartmentNumber(billingInfo.getApartmentNumber());
		editedBillingInfo.setCity(billingInfo.getCity());
		editedBillingInfo.setCreditCardNumber(billingInfo.getCreditCardNumber());
		editedBillingInfo.setExpirationDay(billingInfo.getExpirationDay());
		editedBillingInfo.setExpirationMonth(billingInfo.getExpirationMonth());
		editedBillingInfo.setNameOnCard(billingInfo.getNameOnCard());
		editedBillingInfo.setPinNumber(billingInfo.getPinNumber());
		editedBillingInfo.setState(billingInfo.getState());
		editedBillingInfo.setStreetName(billingInfo.getStreetName());
		billingInfoService.updateBillingInfo(editedBillingInfo);
		
		return new ResponseEntity<BillingInfo>(HttpStatus.OK);
	}
	
}
