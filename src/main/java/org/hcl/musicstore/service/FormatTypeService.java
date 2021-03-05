package org.hcl.musicstore.service;

import org.hcl.musicstore.model.FormatType;
import org.hcl.musicstore.repository.FormatTypeCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FormatTypeService {
    private static Logger logger = LoggerFactory.getLogger(FormatTypeService.class);

    @Autowired
    FormatTypeCrudRepository formatTypeCrudRepository;
    
    public FormatType findFormatTypeById(int id) {
    	return formatTypeCrudRepository.findFormatTypeById(id);
    }

    public Iterable<FormatType> findAllFormatType(){
        return formatTypeCrudRepository.findAll();
    }
    
    public Optional<FormatType> getFormatTypeById(int id) throws Exception{
        Optional<FormatType> formatType= formatTypeCrudRepository.findById(id);

        if(formatType!= null) {
            logger.info("formatType: "+formatType.toString());
            return formatType;
        }

        logger.error("formatType is null");
        throw new Exception("formatType with " + id + " doesn't exist!");

    }
	
	public FormatType saveFormatType(FormatType formatType) {
		return formatTypeCrudRepository.save(formatType);
	}
	
	public boolean deleteFormatTypeById(Integer id) throws Exception{
		logger.info("deleting format type with id: "+id);
		if(formatTypeCrudRepository.existsById(id)) {
			formatTypeCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("format type is null");
		throw new Exception("Format Type not found");
    }
	
	public FormatType updateFormatType(FormatType formatType) {
		return formatTypeCrudRepository.save(formatType);
	}


}
