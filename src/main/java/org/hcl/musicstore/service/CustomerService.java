package org.hcl.musicstore.service;

import org.hcl.musicstore.model.Customer;
import org.hcl.musicstore.repository.CustomerCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    CustomerCrudRepository customerCrudRepository;

    public Iterable<Customer> getAllTasks(){
        return customerCrudRepository.findAll();
    }

    public Optional<Customer> getCustomer(int id) throws Exception{
        Optional<Customer> customer = customerCrudRepository.findById(id);

        if(customer!= null) {
            logger.info("customer: "+customer.toString());
            return customer;
        }

        logger.error("customer is null");
        throw new Exception("customer with " + id + " doesn't exist!");

    }



}
