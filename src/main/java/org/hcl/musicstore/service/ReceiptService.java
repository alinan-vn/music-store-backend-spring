package org.hcl.musicstore.service;

import org.hcl.musicstore.model.Receipt;
import org.hcl.musicstore.repository.ReceiptCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {
    private static Logger logger = LoggerFactory.getLogger(ReceiptService.class);

    @Autowired
    ReceiptCrudRepository receiptCrudRepository;

    public Iterable<Receipt> getAllReceipts(){
        return receiptCrudRepository.findAll();
    }
    public Optional<Receipt> getReceipt(int id) throws Exception{
        Optional<Receipt> receipt = receiptCrudRepository.findById(id);

        if(receipt!= null) {
            logger.info("receipt: "+receipt.toString());
            return receipt;
        }

        logger.error("receipt is null");
        throw new Exception("receipt with " + id + " doesn't exist!");

    }
/*
    public List<Receipt> findReceiptByCustomerId(int customer_id) throws Exception{
        List<Receipt> receipts = receiptCrudRepository.findReceiptByCustomerId(customer_id);
        if (!receipts.isEmpty()){
            logger.info("receipts:" + receipts.toString());
            return receipts;
        }
        logger.error("receipts is null");
        throw new Exception("There isn't any receipts for customer with " + customer_id);
    }

 */

}
