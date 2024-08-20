package com.sachith.server.service.impl;

import com.sachith.server.model.Transaction;
import com.sachith.server.repository.TransactionRepository;
import com.sachith.server.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction create(Transaction transaction) {
        try {
            return transactionRepository.save(transaction);
        } catch (Exception e){
            log.error("",e);
            return null;
        }

    }

    @Override
    public List<Transaction> readAll() {
        return transactionRepository.findAll();
    }
}
