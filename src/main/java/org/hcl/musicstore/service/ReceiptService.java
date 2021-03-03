package org.hcl.musicstore.service;

import org.hcl.musicstore.model.Receipt;
import org.hcl.musicstore.repository.ReceiptCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
