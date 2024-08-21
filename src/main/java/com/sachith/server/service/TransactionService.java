package com.sachith.server.service;

import com.sachith.server.model.Slot;
import com.sachith.server.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TransactionService {

    public Transaction create(Transaction transaction);
    public List<Transaction> readAll() ;
    List<Transaction> transactionByStatus(String status);
}
