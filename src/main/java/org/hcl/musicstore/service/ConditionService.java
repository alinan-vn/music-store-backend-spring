package org.hcl.musicstore.service;

import java.util.Optional;

import org.hcl.musicstore.model.Condition;
import org.hcl.musicstore.repository.ConditionCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionService {
	private static Logger logger = LoggerFactory.getLogger(ConditionService.class);
	
	@Autowired
	ConditionCrudRepository conditionCrudRepository;
	
	public Optional<Condition> getCondition(int id) throws Exception {
		Optional<Condition> condition = conditionCrudRepository.findById(id);
		
		if(condition != null) {
			logger.info("condition: "+condition.toString());
			return condition;
		}
		
		logger.error("condition is null");
		throw new Exception("Condition not found");
	}
	

}
