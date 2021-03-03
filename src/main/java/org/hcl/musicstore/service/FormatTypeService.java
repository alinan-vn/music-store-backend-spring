package org.hcl.musicstore.service;

import org.hcl.musicstore.model.Customer;
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

    public Iterable<FormatType> getAllFormatType(){
        return formatTypeCrudRepository.findAll();
    }
    public Optional<FormatType> getFormatType(int id) throws Exception{
        Optional<FormatType> formatType= formatTypeCrudRepository.findById(id);

        if(formatType!= null) {
            logger.info("formatType: "+formatType.toString());
            return formatType;
        }

        logger.error("formatType is null");
        throw new Exception("formatType with " + id + " doesn't exist!");

    }


}
