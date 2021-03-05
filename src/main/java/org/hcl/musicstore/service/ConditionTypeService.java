package org.hcl.musicstore.service;

import java.util.Optional;

import org.hcl.musicstore.model.ConditionType;
import org.hcl.musicstore.repository.ConditionCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionTypeService {
	private static Logger logger = LoggerFactory.getLogger(ConditionTypeService.class);
	
	@Autowired
	ConditionCrudRepository conditionCrudRepository;
	
	public ConditionType findConditionTypeById(int id) {
		return conditionCrudRepository.findConditionTypeById(id);
	}
	
	 public Iterable<ConditionType> getAllConditionType(){
	        return conditionCrudRepository.findAll();
	    }
	
	public Optional<ConditionType> getConditionType(int id) throws Exception {
		Optional<ConditionType> conditionType = conditionCrudRepository.findById(id);
		
		if(conditionType != null) {
			logger.info("conditionType: "+conditionType.toString());
			return conditionType;
		}
		
		logger.error("ConditionType is null");
		throw new Exception("ConditionType not found");
	}
	
	public ConditionType saveConditionType(ConditionType conditionType) {
		return conditionCrudRepository.save(conditionType);
	}
	
	public boolean deleteConditionTypeById(Integer id) throws Exception{
		logger.info("deleting ConditionType with id: "+id);
		if(conditionCrudRepository.existsById(id)) {
			conditionCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("ConditionType is null");
		throw new Exception("ConditionType not found");
    }
	
	public ConditionType updateConditionType(ConditionType conditionType) {
		return conditionCrudRepository.save(conditionType);
	}
	
}
