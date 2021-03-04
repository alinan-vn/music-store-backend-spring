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

    public boolean validateCustomer(Customer customer) {
		logger.info("customer: "+ customer.toString());
		return customerCrudRepository.findById(customer.getId()) != null;
	}
    
    //find all customers
    public Iterable<Customer> findAllCustomer(){

        return customerCrudRepository.findAll();
    }

    //find customer by their id
    public Optional<Customer> findCustomerById(int id) throws Exception{
        Optional<Customer> customer = customerCrudRepository.findById(id);

        if(customer!= null) {
            logger.info("customer: "+customer.toString());
            return customer;
        }

        logger.error("customer is null");
        throw new Exception("customer with " + id + " doesn't exist!");

    }
    //find customer by their username
    public Customer findCustomerByUsername(String username) throws Exception{
        Customer customer = customerCrudRepository.findCustomerByUsername(username);

        if(customer!= null) {
            logger.info("customer: "+customer.toString());
            return customer;
        }

        logger.error("customer is null");
        throw new Exception("customer with " + username + " doesn't exist!");

    }

    //update and save Customer
    public Customer updateAndSaveCustomer(Customer customer){
        return customerCrudRepository.save(customer);
    }

    public boolean deleteCustomerById(Integer id) throws Exception{
		logger.info("deleting customer with id: "+id);
		if(customerCrudRepository.existsById(id)) {
			customerCrudRepository.deleteById(id);
			return true;
		}
		
		logger.error("customer is null");
		throw new Exception("Customer not found");
    }



}
