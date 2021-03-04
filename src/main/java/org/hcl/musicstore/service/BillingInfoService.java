package org.hcl.musicstore.service;

import java.util.Optional;

import org.hcl.musicstore.model.Admin;
import org.hcl.musicstore.model.BillingInfo;
import org.hcl.musicstore.repository.BillingInfoCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingInfoService {
	private static Logger logger = LoggerFactory.getLogger(ConditionTypeService.class);
	
	@Autowired
	BillingInfoCrudRepository billingInfoCrudRepository;
	
	public BillingInfo findBillingInfoById(int id) {
		return billingInfoCrudRepository.findBillingInfoById(id);
	}
	
	public Optional<BillingInfo> getBillingInfo(int id) throws Exception {
		Optional<BillingInfo> billingInfo = billingInfoCrudRepository.findById(id);
		
		if(billingInfo!=null) {
			logger.info("billingInfo: "+billingInfo.toString());
			return billingInfo;
		}
		
		logger.error("billingInfo is null");
		throw new Exception("Billing Info not found");
		
	}
	
	public BillingInfo saveBillingInfo(BillingInfo customerInfo) {
		return billingInfoCrudRepository.save(customerInfo);
		
	}
	
	public boolean deleteBillingInfoById(Integer id) throws Exception{
		logger.info("deleting album with id: "+id);
		if(billingInfoCrudRepository.existsById(id)) {
			billingInfoCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("billingInfo is null");
		throw new Exception("billingInfo not found");
    }
	
	public void updateBillingInfo(BillingInfo customerInfo) {
		billingInfoCrudRepository.save(customerInfo);
	}

}
