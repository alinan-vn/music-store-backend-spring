package org.hcl.musicstore.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.hcl.musicstore.model.BillingInfo;
import org.hcl.musicstore.service.BillingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillingInfoController {
	
	@Autowired
	BillingInfoService billingInfoService;
	
	@PostMapping("/savebillinginfo")
	public BillingInfo saveBillingInfo(@Valid @RequestBody BillingInfo billingInfo) {
		return billingInfoService.saveBillingInfo(billingInfo);
	}
	
	@GetMapping("/viewbillinginfo/{id}")
	public Optional<BillingInfo> showBillingInfo(int id) throws Exception {
		return billingInfoService.getBillingInfo(id);
		
	}
	
}
